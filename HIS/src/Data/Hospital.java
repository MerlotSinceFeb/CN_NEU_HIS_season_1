/*
医院，携带病人列表。医生列表，挂号信息列表。处方列表，药品列表。疾病列表
单例模式
 */
package Data;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.image.MemoryImageSource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.JSON.parseObject;
public class Hospital {  private static Hospital instance = new Hospital();
   private List<Patient> PatientList=new ArrayList<>();
    private List<Doctor> DoctorList=new ArrayList<>();
    private List<Registration> RegistrationList=new ArrayList<>();
    private List<Prescription> PrescriptionList=new ArrayList<>();
    private List<Medicine> MedicineList=new ArrayList<>();
    private List<illness> illnessesList=new ArrayList<>();
    private HashMap<Registration,DiagnoseInf> DiagMap=new HashMap<>();
    public List<Patient> getPatientList() {
        return PatientList;
    }
    public void setPatientList(List<Patient> patientList) {
        PatientList = patientList;
    }
    public List<Doctor> getDoctorList() {
        return DoctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        DoctorList = doctorList;
    }

    public List<Registration> getRegistrationList() {
        return RegistrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        RegistrationList = registrationList;
    }

    public List<Prescription> getPrescriptionList() {
        return PrescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        PrescriptionList = prescriptionList;
    }

    public List<Medicine> getMedicineList() {
        return MedicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        MedicineList = medicineList;
    }

    public List<illness> getIllnessesList() {
        return illnessesList;
    }

    public void setIllnessesList(List<illness> illnessesList) {
        this.illnessesList = illnessesList;
    }

    public HashMap<Registration, DiagnoseInf> getDiagMap() {
        return DiagMap;
    }

    public void setDiagMap(HashMap<Registration, DiagnoseInf> diagMap) {
        DiagMap =  diagMap;
    }

    //让构造函数为 private，这样该类就不会被实例化
    private Hospital(){}
    //获取唯一可用的对象
    public static Hospital getInstance(){
        return instance;
    }
    //读取药品数据，从同目录下的MedicineList.txt;
    //读医生数据，从同目录下的DoctorList.txt;
    //读病毒数据,illness.txt

//用来储存一些处方
    public void saveP(){
Prescription P1=new Prescription();
        P1.getMedicineSet().add(MedicineList.get(0));
        P1.getMedicineSet().add(MedicineList.get(1));
        P1.setAllCost((double)(MedicineList.get(0).getCost()+MedicineList.get(1).getCost()));
        P1.setName("处方1");
PrescriptionList.add(P1);
        Prescription P2=new Prescription();
        P2.getMedicineSet().add(MedicineList.get(1));
        P2.getMedicineSet().add(MedicineList.get(2));
        P2.setAllCost((double)(MedicineList.get(1).getCost()+MedicineList.get(2).getCost()));
        P2.setName("处方2");
        PrescriptionList.add(P2);
        Prescription P3=new Prescription();
        P3.getMedicineSet().add(MedicineList.get(2));
        P3.getMedicineSet().add(MedicineList.get(3));
        P3.setAllCost((double)(MedicineList.get(2).getCost()+MedicineList.get(3).getCost()));
        P3.setName("处方3");
        PrescriptionList.add(P3);
        Prescription P4=new Prescription();
        P4.getMedicineSet().add(MedicineList.get(3));
        P4.getMedicineSet().add(MedicineList.get(4));
        P4.setAllCost((double)(MedicineList.get(3).getCost()+MedicineList.get(4).getCost()));
        P4.setName("处方4");
        PrescriptionList.add(P4);
        Prescription P5=new Prescription();
        P5.getMedicineSet().add(MedicineList.get(1));
        P5.getMedicineSet().add(MedicineList.get(4));
        P5.setAllCost((double)(MedicineList.get(1).getCost()+MedicineList.get(4).getCost()));
        P5.setName("处方5");
        PrescriptionList.add(P5);
        Prescription P6=new Prescription();
        P6.getMedicineSet().add(MedicineList.get(2));
        P6.getMedicineSet().add(MedicineList.get(4));
        P6.setAllCost((double)(MedicineList.get(2).getCost()+MedicineList.get(4).getCost()));
        P6.setName("处方6");
        PrescriptionList.add(P6);
        Prescription P7=new Prescription();
        P7.getMedicineSet().add(MedicineList.get(3));
        P7.getMedicineSet().add(MedicineList.get(0));
        P7.setAllCost((double)(MedicineList.get(3).getCost()+MedicineList.get(0).getCost()));
        P7.setName("处方7");
        PrescriptionList.add(P7);
        Prescription P8=new Prescription();
        P8.getMedicineSet().add(MedicineList.get(0));
        P8.getMedicineSet().add(MedicineList.get(4));
        P8.setAllCost((double)(MedicineList.get(4).getCost()+MedicineList.get(0).getCost()));
        P8.setName("处方8");
        PrescriptionList.add(P8);
        String json= JSONArray.toJSONString(PrescriptionList);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Prescription.data")) ;
            pw.print(json);
            pw.close();
            //清空选项
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
