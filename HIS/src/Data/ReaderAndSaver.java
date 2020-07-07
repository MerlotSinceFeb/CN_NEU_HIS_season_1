/*
读取与存储数据的工具类
单例模式
 */
package Data;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import jdk.jshell.Diag;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReaderAndSaver {
    private static ReaderAndSaver instance = new ReaderAndSaver();
    //让构造函数为 private，这样该类就不会被实例化
    private ReaderAndSaver(){}
    //获取唯一可用的对象
    public static ReaderAndSaver getInstance(){
        return instance;
    }
    //读取json数据
    public void ReadJsonList(Hospital h,String path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            if(laststr=="[]")
                return;
            if(laststr=="")
                return;
            reader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        if(path.equals("Prescription.data"))
            h.setPrescriptionList(JSON.parseArray(laststr,Prescription.class));
        else if(path.equals("Registration.data"))
            h.setRegistrationList(JSON.parseArray(laststr,Registration.class));
        else if(path.equals("DiagnoseMap.data")){
            Map<Registration, DiagnoseInf> map = (Map<Registration, DiagnoseInf>) JSON.parseObject(laststr, new TypeReference<Map<Registration, DiagnoseInf>>() {
            });
            h.setDiagMap((HashMap<Registration, DiagnoseInf>)map);
        }

        }


    //存储json数据
    public void saveJsonList(Hospital h,String str){
        String json="";
        if(str.equals("Registration.data")){
            json= JSONArray.toJSONString(h.getRegistrationList());
        }

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(str)) ;
            pw.print(json);
            pw.close();
            //清空选项
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
    //DiagnoseMap.data
    public void ReadJsonMap(Hospital h,String path){}
    public void SaveJsonMap(Hospital h,String path){
        String json="";
        if(path.equals("DiagnoseMap.data")){
            json= JSONArray.toJSONString(h.getDiagMap());
        }

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path)) ;
            pw.print(json);
            pw.close();
            //清空选项
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    //字符流读取已知文件
    public void getInf(Hospital h,String pathname){

        try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"GBK"))){
            String line;
            br.readLine();//空掉属性行
            if(pathname.equals("MedicineList.txt"))
            while((line=br.readLine())!=null){
                String[] str=line.split("-");
                String ID=str[0];
                String name=str[1];
                String dosage=str[2];
                String specification=str[3];
                String unit=str[4];
                double cost=Double.parseDouble(str[5]);
                String kind=str[6];
                Medicine m=new Data.Medicine(name,ID,specification,unit,cost,dosage,kind);
                h.getMedicineList().add(m);
            }
            else  if(pathname.equals("DoctorList.txt"))
                while((line=br.readLine())!=null){

                    String[] str=line.split("-");
                    String ID=str[0];
                    String password=str[1];
                    String name=str[2];
                    String department=str[3];
                    Doctor d=new Doctor(ID,password,name,department);
                    h.getDoctorList().add(d);
                }
            else  if(pathname.equals("illness.txt"))
                while((line=br.readLine())!=null){

                    String[] str=line.split("-");
                    String ID=str[0];
                    String name=str[1];
                    illness i=new illness(name,ID);
                    h.getIllnessesList().add(i);
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
