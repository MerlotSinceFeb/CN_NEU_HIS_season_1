package Data;

public class Doctor {
    private String ID;//医生用登录账号
    private String password;//医生用密码
    private String name;//医生姓名
    private String department;//医生所属科室

    public Doctor(String ID,String password,String name,String department){
        this.ID=ID;
        this.password=password;
        this.name=name;
        this.department=department;
    }
    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
