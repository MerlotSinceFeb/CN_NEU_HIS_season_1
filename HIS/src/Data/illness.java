package Data;

public class illness {
    private String name;//病名
    private  String ID;//编号
public illness(String name,String ID) {
    this.name = name;
    this.ID = ID;
}
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}
