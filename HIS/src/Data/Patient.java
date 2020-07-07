package Data;

import java.util.Date;

public class Patient {
    private String medicalRecord;//病历号 不可重复
   // private Boolean ifRegistration;//是否已经挂号
    private String name;//患者姓名
    private String gender;//性别 "男" "女"
    private Date birthday;//出生日期
    private int age;//年龄。由出生日期可以得到年龄
    private String IDCard;//身份证号
    private String address;//家庭住址
public Patient(String medicalRecord,String name,String gender,Date birthday,int age,String IDCard,String address){
    this.medicalRecord=medicalRecord;
    this.name=name;
    this.gender=gender;
    this.birthday=birthday;
    this.age=age;
    this.IDCard=IDCard;
    this.address=address;
}



    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
