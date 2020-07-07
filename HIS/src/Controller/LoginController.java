package Controller;
import Data.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
public class LoginController {
    public static String doctorName;
    @FXML
    private Label password;
    @FXML
    private PasswordField passwordfield;
    @FXML
    private Button loginButton;
    @FXML
    private Label ID;
    @FXML
    private Label title;
    @FXML
    private Label errorPasswordMessage;
    @FXML
    private TextField idfield;
    @FXML
    private Label errorIDMessage;
   Hospital hospital=Hospital.getInstance();//单例医院导入

    @FXML
    void initialize(){
        EnterLogin(loginButton);
        EnterLogin(idfield);
        EnterLogin(passwordfield);
    }
//登录方法
    @FXML
    public void login(){
        //挂号员 登录
        if(idfield.getText().equals("ghy")&&passwordfield.getText().equals("ghy")){
            Stage primaryStage = Main.getStage();
            try {
                primaryStage.setTitle("Menu");
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ghyMenu.fxml")));
                primaryStage.setScene(scene);
                scene.getStylesheets().add(this.getClass().getResource("Menu.css").toExternalForm());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{//密码有误
            errorPasswordMessage.setVisible(true);}
        //医生登录
        for(int i=0;i<hospital.getDoctorList().size();i++){
            Doctor d=hospital.getDoctorList().get(i);
            if(idfield.getText().equals(d.getID())) {//账号存在
                errorIDMessage.setVisible(false);
                errorIDMessage.setManaged(false);
                if (passwordfield.getText().equals(d.getPassword())) {//账号存在。登录成功
                    Stage primaryStage = Main.getStage();
                    try {
                        doctorName=d.getName();
                        primaryStage.setTitle("Menu");
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("DocMenu.fxml")));
                        primaryStage.setScene(scene);
                        scene.getStylesheets().add(this.getClass().getResource("Menu.css").toExternalForm());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{//密码有误
                    errorPasswordMessage.setVisible(true);
                }
            }
            }



    }
    @FXML
    public void EnterLogin(Control c){
        c.setOnKeyPressed(event -> {
            if (event.getCode()== KeyCode.ENTER) {

                login();

            }
        });
    }
}
