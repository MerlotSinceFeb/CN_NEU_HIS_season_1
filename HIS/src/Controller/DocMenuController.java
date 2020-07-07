package  Controller;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import Data.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.beans.property.StringProperty;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jshell.Diag;
import org.w3c.dom.Text;

import java.awt.event.ActionEvent;
import java.util.*;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;

public class DocMenuController {
private ArrayList<Registration> yourPatient0=new ArrayList<>();
    private ArrayList<Registration> yourPatient1=new ArrayList<>();
    private ArrayList<Registration> allPatient1=new ArrayList<>();
    private ArrayList<Registration> allPatient0=new ArrayList<>();
    private ArrayList<Registration> canDiagnose=new ArrayList<>();
    private ArrayList<MedicineToFinish> allMTFList=new ArrayList<>();
    private ArrayList<PrescriptionToFinish> allPTFList=new ArrayList<>();
    private ArrayList<Registration> alreadyDiagnose=new ArrayList<>();
private Hospital hospital=Hospital.getInstance();
private Doctor doctor;
@FXML
private Label Pname;
@FXML
    private TableColumn<PatientToFinish,String> yourName1;
    @FXML
    private TableColumn<PatientToFinish,String> yourName0;
    @FXML
    private TableView<PatientToFinish> yourPatientT0;
    ObservableList<PatientToFinish> yourPatientT0options=FXCollections.observableArrayList();
    ObservableList<PatientToFinish> allPatientT0options=FXCollections.observableArrayList();
    ObservableList<PatientToFinish> allPatientT1options=FXCollections.observableArrayList();
    ObservableList<PatientToFinish> yourPatientT1options=FXCollections.observableArrayList();
    @FXML
    private TableView<PatientToFinish> yourPatientT1;
    @FXML
    private TableColumn<PatientToFinish,String> yourAge0;
    @FXML
    private TableColumn<PatientToFinish,String> allAge0;
    @FXML
    private TableColumn<PatientToFinish,String> yourAge1;
    @FXML
    private TableColumn<PatientToFinish,String> allAge1;
    @FXML
    private TableColumn<PatientToFinish,String> allName1;
    @FXML
    private Label doctorName;
    @FXML
    private Button diagnose;
    @FXML
    private Pane tippane2;
    @FXML
    private Label success2;
    @FXML
    private Label fail2;
    @FXML
    private TextField diagnosesearch;
    @FXML
    private TableColumn<PatientToFinish,String> allName0;
    @FXML
    private TableView<PatientToFinish> allPatientT0;
    @FXML
    private TableView<PatientToFinish> allPatientT1;
    @FXML
    private Button Exit;
    @FXML
    private TableColumn<MedicineToFinish,String> MedSp;
    @FXML
    private TableView<MedicineToFinish> TableMedInf;
    ObservableList<MedicineToFinish> TableMedInfoptions=FXCollections.observableArrayList();
    @FXML
    private TableColumn<MedicineToFinish,String> MedUnit;
    @FXML
    private TableView<PrescriptionToFinish> TableChoosePList;
    ObservableList<PrescriptionToFinish> TableChoosePListoptions=FXCollections.observableArrayList();
    //@FXML
    //private TableColumn<MedicineToFinish,String> MedKind;
    @FXML
    private TableColumn<PrescriptionToFinish,String >PListNum0;
    @FXML
    private TableView<PrescriptionToFinish> TablePList;
    ObservableList<PrescriptionToFinish> TablePListoptions=FXCollections.observableArrayList();
    @FXML
    private TableColumn<PrescriptionToFinish,String> PListName0;
    @FXML
    private TableColumn<PrescriptionToFinish,String> PlistName1;
    @FXML
    private TableColumn<MedicineToFinish,String> MedCost;
    @FXML
    private TableColumn<PrescriptionToFinish,String> PListNum1;
@FXML
private Button FinalButton;
    @FXML
    private TableColumn<MedicineToFinish,String> MedName;
    @FXML
    private TextArea Diagnose1;
    @FXML
    private TextArea Diagnose2;
    @FXML
    private TextArea Diagnose3;
    @FXML
    private TextArea Diagnose4;
    @FXML
    private TextArea Diagnose5;

    ArrayList<TextArea> DiagInfList =new ArrayList<>();
    @FXML
    public void initialize() {
        getInf();
        getInf2();
        getInf3();
        doctorName.setText(LoginController.doctorName);
        TableChoose(yourPatientT0);
        TableChoose(yourPatientT1);
        TableChoose(allPatientT0);
        TableChoose(allPatientT1);
        TableChoose2(TablePList);
        TableoverChoose(TableChoosePList);
        yourName0.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        yourName1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        yourAge0.setCellValueFactory(cellData->cellData.getValue().ageProperty());
        yourAge1.setCellValueFactory(cellData->cellData.getValue().ageProperty());
        allName0.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        allName1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        allAge0.setCellValueFactory(cellData->cellData.getValue().ageProperty());
        allAge1.setCellValueFactory(cellData->cellData.getValue().ageProperty());
        yourPatientT0.setItems(yourPatientT0options);
        yourPatientT1.setItems(yourPatientT1options);
        allPatientT0.setItems(allPatientT0options);
        allPatientT1.setItems(allPatientT1options);
        DiagInfList=new ArrayList<>(){{add( Diagnose1);add( Diagnose2);add( Diagnose3);add( Diagnose4);add( Diagnose5);}};
    }
    //退出
    public void exit(){

        Stage primaryStage = Main.getStage();
        try {
            primaryStage.setTitle("Menu");
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
            primaryStage.setScene(scene);
            scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    //定位医生，并给患者分类。4类
public void getInf(){
        for(Doctor d:hospital.getDoctorList()){
            if(LoginController.doctorName.equals(d.getName())){
                doctor=d;
                break;
            }
        }
        for(Registration R:hospital.getRegistrationList()){
            if(R.getD().getName().equals(doctor.getName())){
                if(R.isIfFinish()){
                    yourPatient1.add(R);
                    alreadyDiagnose.add(R);
                }else{
                    yourPatient0.add(R);
                    canDiagnose.add(R);
            }
            }else if(R.getD().getDepartment().equals(doctor.getDepartment())){
                if(R.isIfFinish()){
                    allPatient1.add(R);
                    alreadyDiagnose.add(R);
                }else if(!R.isIfFinish()){
                    canDiagnose.add(R);
                    allPatient0.add(R);
            }}

        }
}
//为了让table展示，病人换类
public void getInf2(){

for(Registration R:yourPatient0){
    PatientToFinish ptf =new PatientToFinish(R.getP().getName(),R.getP().getAge());
    yourPatientT0options.add(ptf);
}
for(Registration R:yourPatient1)
    yourPatientT1options.add(new PatientToFinish(R.getP().getName(),R.getP().getAge()));
    for(Registration R:allPatient0)
        allPatientT0options.add(new PatientToFinish(R.getP().getName(),R.getP().getAge()));
    for(Registration R:allPatient1)
        allPatientT1options.add(new PatientToFinish(R.getP().getName(),R.getP().getAge()));

}
//处方和药品导入列表
public void getInf3(){
        for(Medicine m:hospital.getMedicineList()){
            MedicineToFinish M=new MedicineToFinish(m.getName(),Double.toString(m.getCost()),m.getSpecification(),m.getUnit(),m.getKind());
            //System.out.println(M.getKind());
            allMTFList.add(M);
        }

        for(Prescription p:hospital.getPrescriptionList()){
            Iterator<Medicine> iterator = p.getMedicineSet().iterator();
            Medicine m1=iterator.next();
            Medicine m2=iterator.next();
            MedicineToFinish  M1=new MedicineToFinish(m1.getName(),Double.toString(m1.getCost()),m1.getSpecification(),m1.getUnit(),m1.getKind());
            MedicineToFinish M2=new MedicineToFinish(m2.getName(),Double.toString(m2.getCost()),m2.getSpecification(),m2.getUnit(),m2.getKind());
          Set<MedicineToFinish> MTFList=new HashSet<>();
          MTFList.add(M1);
          MTFList.add(M2);
          PrescriptionToFinish P=new PrescriptionToFinish(p.getName(),Integer.toString(p.getMedicineSet().size()),MTFList);
          allPTFList.add(P);
            TablePListoptions.add(P);
        }
    PListName0.setCellValueFactory(cellData->cellData.getValue().nameProperty());
    PlistName1.setCellValueFactory(cellData->cellData.getValue().nameProperty());
    PListNum0.setCellValueFactory(cellData->cellData.getValue().numProperty());
    PListNum1.setCellValueFactory(cellData->cellData.getValue().numProperty());
    MedName.setCellValueFactory(cellData->cellData.getValue().nameProperty());
    MedSp.setCellValueFactory(cellData->cellData.getValue().specificationProperty());
    MedCost.setCellValueFactory(cellData->cellData.getValue().costProperty());
   // MedKind.setCellValueFactory(cellData->cellData.getValue().KindProperty());
    MedUnit.setCellValueFactory(cellData->cellData.getValue().unitProperty());
    TablePList.setItems(TablePListoptions);
}
//系统提示气泡
    public void regtip(){
        FadeTransition ft = new FadeTransition(Duration.millis(3000), tippane2);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.setCycleCount(1);
        tippane2.setVisible(true);
        ft.setAutoReverse(true);
        ft.play();
    }
    //诊断按钮方法
    public void Diagnose(){
        if(diagnosesearch.getText().equals("")) {
            fail2.setText("未输入患者！");
            fail2.setVisible(true);
            success2.setVisible(false);
            regtip();
        }
        else {
            for(Registration R : alreadyDiagnose){
                if(diagnosesearch.getText().trim().equals(R.getP().getName())){
                    //确认诊断对象已经诊断
                    success2.setText("该患者已诊断");
                    success2.setVisible(true);
                    fail2.setVisible(false);
                    Pname.setText(R.getP().getName());
                    for(Registration  r: hospital.getDiagMap().keySet()){
                      if(r.getP().getName().trim().equals(R.getP().getName().trim())){
                          DiagnoseInf DI=hospital.getDiagMap().get(r);
                          Diagnose1.setText(DI.getZhusu());
                          Diagnose2.setText(DI.getXianbingshi());
                          Diagnose3.setText(DI.getZhiliaoqingkuang());
                          Diagnose4.setText(DI.getJiwangshi());
                          Diagnose5.setText(DI.getDiagnose());
                      break;}
                    }

                    regtip();
                    return;
                }

            }
            for(Registration R :canDiagnose){
                if(diagnosesearch.getText().trim().equals(R.getP().getName())){
                    //确认诊断对象
                    Diagnose1.setText("");
                    Diagnose2.setText("");
                    Diagnose3.setText("");
                    Diagnose4.setText("");
                    Diagnose5.setText("");
                    success2.setText("已确认诊断对象。请填写诊断信息并开药");
                    success2.setVisible(true);
                    fail2.setVisible(false);
                    Pname.setText(R.getP().getName());
                    regtip();
                }
            }

        }
    }
    //实现双机表格选人
    public void TableChoose(TableView T){
        T.setRowFactory(tv -> {
            TableRow<PatientToFinish> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    PatientToFinish pp = row.getItem();
                    diagnosesearch.setText(pp.getName());
                }
            });
            return row;
        });

    }
    //左键显示信息。右键加处方
    public void TableChoose2(TableView T){
       T.setRowFactory(tv -> {
            TableRow<PrescriptionToFinish> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getButton()==SECONDARY&& (!row.isEmpty())) {
                    PrescriptionToFinish pp = row.getItem();

                    TableChoosePListoptions.add(pp);
                    TableChoosePList.setItems(TableChoosePListoptions);
                }
                if (event.getButton()== PRIMARY && (!row.isEmpty())) {
                    PrescriptionToFinish pp = row.getItem();
                    Iterator<MedicineToFinish> iterator = pp.getMTFList().iterator();
                    MedicineToFinish M1=iterator.next();
                    MedicineToFinish M2=iterator.next();
                    ObservableList<MedicineToFinish> TableMedInfoptions1=FXCollections.observableArrayList(M1,M2);
                    TableMedInf.setItems(TableMedInfoptions1);
                }
            });
            return row;
        });

    }
//右键删除处方0
    public void TableoverChoose(TableView T){ T.setRowFactory(tv -> {
        TableRow<PrescriptionToFinish> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getButton()==SECONDARY&& (!row.isEmpty())) {
                PrescriptionToFinish pp = row.getItem();
                TableChoosePListoptions.remove(pp);
                TableChoosePList.setItems(TableChoosePListoptions);
            }
        });
        return row;
    });
        }
        //开药确认
        public void FinalCheck(){
        boolean flagForFinal=false;
            TableChoosePListoptions=TableChoosePList.getItems();
            if(Pname.getText().equals("")){
                fail2.setText("请选择患者！");
                fail2.setVisible(true);
                success2.setVisible(false);
                regtip();

            }
       else if(TableChoosePListoptions.size()==0){
            fail2.setText("请添加处方！");
            fail2.setVisible(true);
            success2.setVisible(false);
            regtip();
        }
       else{
           for(Registration R:yourPatient0){
           if(R.getP().getName().equals(Pname.getText().trim())){
               //找到患者
               R.setIfFinish(true);
               ArrayList<Prescription> P1=new ArrayList<>();
               for(PrescriptionToFinish PTF:TableChoosePListoptions){
                  Prescription p=new Prescription(PTF.getName(),Double.parseDouble(PTF.getAllCost()));
                  P1.add(p);
               }
               R.setPrescriptionList(P1);
               yourPatient0.remove(R);
               yourPatient1.add(R);
               flagForFinal=true;
               DiagnoseInf Di=new DiagnoseInf(Diagnose1.getText(),Diagnose2.getText(),Diagnose3.getText(),Diagnose4.getText(),Diagnose5.getText());
               hospital.getDiagMap().put(R,Di);
               alreadyDiagnose.add(R);
               break;
           }}
          if(flagForFinal==false){
               for(Registration R:allPatient0){
                   if(R.getP().getName().equals(Pname.getText().trim())){
                       //找到患者
                       R.setIfFinish(true);
                       ArrayList<Prescription> P1=new ArrayList<>();
                       for(PrescriptionToFinish PTF:TableChoosePListoptions){
                           double cost2=Double.parseDouble(PTF.getAllCost());
                           Prescription p=new Prescription(PTF.getName(),cost2);
                           P1.add(p);
                       }
                       DiagnoseInf Di=new DiagnoseInf(Diagnose1.getText(),Diagnose2.getText(),Diagnose3.getText(),Diagnose4.getText(),Diagnose5.getText());
                       R.setPrescriptionList(P1);
                       hospital.getDiagMap().put(R,Di);
                       allPatient0.remove(R);
                       allPatient1.add(R);
                       alreadyDiagnose.add(R);
break;
                   }
               }
           }
           //getInf2();
                Pname.setText("");
               success2.setText("诊断成功！");
               success2.setVisible(true);
               fail2.setVisible(false);
               regtip();
            }
       this.freshwindow();
            }
            //刷新界面
 public void  freshwindow(){
     yourPatientT0options.removeAll(yourPatientT0options);
     yourPatientT1options.removeAll(yourPatientT1options);
     allPatientT0options.removeAll(allPatientT0options);
     allPatientT1options.removeAll( allPatientT1options);
 getInf2();
 Pname.setText("");
 for(TextArea Ta: DiagInfList)
     Ta.setText("");
    }
}

