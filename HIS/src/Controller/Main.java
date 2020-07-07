package Controller;
import Data.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.jshell.Diag;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Main extends Application{
    static private Stage primaryStage;
   public static Stage getStage() { return primaryStage; }
    public static Stage getPrimaryStage() { return primaryStage; }
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
       // primaryStage.setResizable(false);
        primaryStage.setTitle("Welcome To Medical System");
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root, 1141, 618);
        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
        scene.getStylesheets().add(this.getClass().getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
    public static void main(String args[]){
        Hospital h=Hospital.getInstance();
        ReaderAndSaver r=ReaderAndSaver.getInstance();
       r.getInf(h,"MedicineList.txt");
        System.out.println("药品数据存入成功");
        r.getInf(h,"DoctorList.txt");
        System.out.println("医生信息录入成功");
       r.getInf(h,"illnessList.txt");
        System.out.println("疾病信息存入成功");
r.ReadJsonList(h,"Registration.data");
System.out.println("挂号信息录入成功");
r.ReadJsonList(h,"DiagnoseMap.data");
System.out.println("诊断信读取成功");

       HashMap<Registration,DiagnoseInf> hm=h.getDiagMap();
        for(DiagnoseInf value : hm.values()){
           // System.out.println(value.getZhusu());
        }
        r.ReadJsonList(h,"Prescription.data");
System.out.println("处方存储成功");
launch(args);
r.saveJsonList(h,"Registration.data");
r.SaveJsonMap(h,"DiagnoseMap.data");
System.out.println("信息存储完毕");

    }
}
