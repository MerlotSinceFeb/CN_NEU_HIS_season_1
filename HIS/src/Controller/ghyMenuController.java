package Controller;
import Data.*;
import com.alibaba.fastjson.JSONObject;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class ghyMenuController {
Hospital hospital=Hospital.getInstance();
    @FXML
    private ComboBox<String> gender;
    ObservableList<String> genderoptions =FXCollections.observableArrayList("男","女");
    @FXML
    private TextField mR3;
    @FXML
    private Pane payPane3;
    @FXML
    private Label name3;
    @FXML
    private Label mR4;
    @FXML
    private Label allCost3;
    @FXML
    private Button search3;
    @FXML
    private Button payButton3;
    @FXML
    private Button returnReg;
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> rKind;
    ObservableList<String> rKindoptions =FXCollections.observableArrayList("专家号","普通号");
    @FXML
    private Button freshB;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private StackPane stackScene;
    @FXML
    private Pane pane5;
    @FXML
    private ComboBox<String> payKind1;
    ObservableList<String> payKind1options =FXCollections.observableArrayList("医保","自费","新农合");
    @FXML
    private ComboBox<String> payKind2;
    ObservableList<String> payKind2options =FXCollections.observableArrayList("现金","网银","支付宝","微信","visa");
    @FXML
    private Button returnPay;
    @FXML
    private Button regB;
    @FXML
    private ComboBox<String> department;
    ObservableList<String> departmentoptions =FXCollections.observableArrayList("儿科","普外科","感染科","内分泌科","妇科","免疫内科","血液科","呼吸内科","肝胆内科","精神心理科");
    @FXML
    private CheckBox bookC;
    @FXML
    private TextField IDField;
    @FXML
    private DatePicker sDDate;
    @FXML
    private Button pay;
    @FXML
    private DatePicker birthDate;
    @FXML
    private TextField costField;
    @FXML
    private ComboBox<String> doctor;
    @FXML
    private TextField cardField;
    @FXML
    private TextField mRField;
    @FXML
    private Button registration;
    @FXML
    private TextField addressField;
    @FXML
    private TextField age;
    @FXML
    private StackPane tippane;
    @FXML
    private Label success;
    @FXML
    private Label fail;
    @FXML
    private Button exit;
    @FXML
    private Label ifFinishField22;
    @FXML
    private Button returnRegComfrim;
    @FXML
    private Label mRField22;
    @FXML
    private TextField mRField2;
    @FXML
    private Label department22;
    @FXML
    private Label nameField22;
    @FXML
    private Label sDDate22;
    @FXML
    private Label IDField22;
    @FXML
    private TextField IDField2;
    @FXML
    private TextField nameField2;
    @FXML
    private Button search;
    @FXML
    private Label defaultReturnReg;
    @FXML
    private HBox infTable;
  private ArrayList<TextField> RegTextList;
  private ArrayList<ComboBox<String>> RegBoxList;

   @FXML
   void initialize(){
     RegBoxList=new ArrayList<ComboBox<String>>(){{add(payKind1);add(payKind2);add(department);add(doctor);add(rKind);add(gender);}};
       RegTextList=new  ArrayList<TextField>(){{add(addressField); add(cardField);add(mRField);add(nameField);add(IDField);add(costField);add(age);}};

   }

    @FXML//挂号界面按钮。顺便加载combobox中的元素
    void registration(ActionEvent event) {
payKind1.setItems(payKind1options);
payKind2.setItems(payKind2options);
department.setItems(departmentoptions);
gender.setItems(genderoptions);
rKind.setItems(rKindoptions);
pane1.setVisible(true);
pane2.setVisible(false);
pane3.setVisible(false);
pane4.setVisible(false);
pane5.setVisible(false);
    }
    @FXML//退号界面按钮
    void returnReg(ActionEvent event) {
        pane1.setVisible(false);
        pane2.setVisible(true);
        pane3.setVisible(false);
        pane4.setVisible(false);
        pane5.setVisible(false);
        //判断病历号是否填写
        }
    @FXML//缴费界面按钮
    void pay(ActionEvent event) {
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(true);
        pane4.setVisible(false);
        pane5.setVisible(false);

    }
    @FXML//按病历查询挂号信息
    void search1(){
        boolean flag=false;
        if(mRField2.getText().equals("")&&nameField2.getText().equals("")&&IDField2.getText().equals("")) {
            fail.setText("        请输入查找信息!");
            fail.setVisible(true);
            success.setVisible(false);
            regtip();
        }
        //1轮病历号查找
        else{
            for(Registration R:hospital.getRegistrationList()){
                if(R.getP().getMedicalRecord().equals(mRField2.getText())){
                    //1轮查找结束
                    infBySearch1(R);
                flag=true;
                }
                //二轮姓名查找
                else if(R.getP().getName().equals(nameField2.getText())){
                    infBySearch1(R);
                flag=true;
                }
                //三轮身份证号 查找
                else if(R.getP().getName().equals(nameField2.getText())){
                    infBySearch1(R);
                flag=true;
                }
                else{
                   //显示暂无数据
                    defaultReturnReg.setVisible(true);
                }
            }
            if(!flag){
                fail.setText("未找到任何数据");
                fail.setVisible(true);
                success.setVisible(false);
                regtip();
                infTable.setVisible(false);
                defaultReturnReg.setVisible(true);
            }



        }

    }
    @FXML//挂号信息查询到展示结果
    void infBySearch1(Registration R){
        mRField22.setText(" "+R.getP().getMedicalRecord());
        nameField22.setText(" "+R.getP().getName());
        IDField22.setText(R.getP().getIDCard());
        Date d=R.getRegDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
        sDDate22.setText(sdf.format(d));
        department22.setText(R.getD().getDepartment());
        if(R.isIfFinish())
        ifFinishField22.setText("已就诊");
        else
        ifFinishField22.setText("未就诊");
        defaultReturnReg.setVisible(false);
        infTable.setVisible(true);
        fail.setVisible(false);
        success.setText("查询到挂号信息");
        success.setVisible(true);
        regtip();
    }
@FXML//点击退号
void ReturnRegFinal(ActionEvent event){
if(ifFinishField22.getText().equals("已就诊")){
    fail.setText("已就诊，不能退号！");
    fail.setVisible(true);
    success.setVisible(false);
    regtip();
}else{
    for(Registration R :hospital.getRegistrationList()){
        if(mRField22.getText().trim().equals(R.getP().getMedicalRecord())){
            hospital.getRegistrationList().remove(R);
            success.setText("退号成功！");
            fail.setVisible(false);
            success.setVisible(true);
            regtip();
            infTable.setVisible(false);
            defaultReturnReg.setVisible(true);
            break;
        }
    }

}

}
    @FXML
    void paySearch(ActionEvent event) {
        boolean flagForPay=false;
        if(mR3.getText().equals("")){
            fail.setText("        请输入查找信息!");
            fail.setVisible(true);
            success.setVisible(false);
            regtip();
        }
        else {
            for(Registration R:hospital.getRegistrationList()){
                if(R.getP().getMedicalRecord().equals(mR3.getText())&&!R.isIfPay()){
                 infBySearch2(R);
                    flagForPay=true;
                }
            }
            if(!flagForPay){
               fail.setText("        未查询到结果!");
                fail.setVisible(true);
                success.setVisible(false);
                regtip();
            }
        }
    }
    void infBySearch2(Registration R){
        mR4.setText(" "+R.getP().getMedicalRecord());
        name3.setText(" "+R.getP().getName());
        double allcost=0;
        for(Prescription Pre:R. getPrescriptionList()){
            allcost=allcost+Pre.getAllCost();
        }
        allCost3.setText(""+allcost);
        mR4.setVisible(true);
        payPane3.setVisible(true);
        name3.setVisible(true);
        allCost3.setVisible(true);
        success.setText("        查询到结果!");
        fail.setVisible(false);
        success.setVisible(true);
        regtip();



    }
    @FXML
    void PayCheck(ActionEvent event){
        for(Registration R:hospital.getRegistrationList()){
            if(R.getP().getMedicalRecord().equals(mR4.getText().trim())){
               R.setIfPay(true);
            break;
            }

        }

        success.setText("缴费成功");
        fail.setVisible(false);
        success.setVisible(true);
        regtip();
        mR3.setText("");
        mR4.setText("");
        name3.setText("");
        allCost3.setText("");
        payPane3.setVisible(false);



    }
    @FXML
    void returnPay(ActionEvent event) {
    }
@FXML//根据科室联想医生
void chooseDoctor(){
    ObservableList<String> doctoroptions=FXCollections.observableArrayList( " ");
if(department.getValue()!=null){
    doctor.setItems(null);
            String chooseDepartment=department.getValue();
            for(Doctor d:hospital.getDoctorList()){
                if(d.getDepartment().equals(chooseDepartment)){
                    //找到科室对应人
                    doctoroptions.add(d.getName());
            }
            }
            doctor.setItems(doctoroptions);
}
}
@FXML//挂号确认
void regConfirm(){
       //判断必填项是否填写
    //String mR=mRField.getText();
        if(age.getText()!=null&&addressField.getText()!=null&&cardField.getText()!=null&&mRField.getText()!=null&&birthDate.getValue()!=null&&sDDate.getValue()!=null&&nameField.getText()!=null&&IDField.getText()!=null&&payKind1.getValue()!=null&&payKind2.getValue()!=null&&department.getValue()!=null&&doctor.getValue()!=null&&costField.getText()!=null&&rKind.getValue()!=null&&gender.getValue()!=null){
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = birthDate.getValue().atStartOfDay(zoneId);
            Date date1 =Date.from(zdt.toInstant());
            ZoneId zoneId1 = ZoneId.systemDefault();
            ZonedDateTime zdt1 = sDDate.getValue().atStartOfDay(zoneId1);
            Date date2 =Date.from(zdt1.toInstant());

            Patient p=new Patient(mRField.getText(),nameField.getText(),gender.getValue(),date1,Integer.parseInt(age.getText()),IDField.getText(),addressField.getText());
            for(Doctor d:hospital.getDoctorList()){
                if(d.getName().equals(doctor.getValue())){
                    boolean ifFinish=false;
                    ArrayList<Prescription> prescriptionList =new ArrayList<>();
                    Registration R=new Registration(p,d,payKind1.getValue(),rKind.getValue(),Integer.parseInt(costField.getText()),payKind2.getValue(),cardField.getText(),date2,ifFinish,prescriptionList);
                    //加上判断病历号和发票号是否重复
                    for(Registration r:hospital.getRegistrationList()){
                         if(r.getCard().equals(R.getCard())){//发票号一样
                             fail.setText("     发票号重复！");
                             fail.setVisible(true);
                             success.setVisible(false);
                             regtip();
                             return;
                    }else if(r.getP().getMedicalRecord().equals(R.getP().getMedicalRecord())){//病历号一样
                             fail.setText("     病历号已存在！");
                             fail.setVisible(true);
                             success.setVisible(false);
                             regtip();
                             return;
                         }
                    }
                   hospital.getRegistrationList().add(R);
                    success.setVisible(true);
                    fail.setVisible(false);
                    success.setText("挂号成功");
                    regtip();
                    refreshReg();
                    break;
                }
            }
        }else{
            fail.setText("            有未填项!");
            success.setVisible(false);
            fail.setVisible(true);
            regtip();
        }

}
//这里是清除挂号信息的选项的方法
public void refreshReg(){
    for(TextField tf:RegTextList)
        tf.setText("");
birthDate.setValue(null);
sDDate.setValue(null);
for(ComboBox<String> cb: RegBoxList)
    cb.setValue(null);
    }
    @FXML
    void refreshByHand(ActionEvent event){
        refreshReg();
    }
    //显示信息
    public void regtip(){
        FadeTransition ft = new FadeTransition(Duration.millis(3000), tippane);
        tippane.setVisible(true);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
    @FXML
    void exit(){
        Stage primaryStage = Main.getStage();
        try {
            primaryStage.setTitle("Menu");
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
            primaryStage.setScene(scene);
            scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}