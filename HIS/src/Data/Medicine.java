package Data;

public class Medicine {
    private String name;//药名
    private String ID;//药品编码
    private double  cost;//药品单价
    private String specification;//规格
    private String usage;//用法
    private String dosage;//剂量
    private int quantity;//数量
    private String unit;//单位，袋，盒
    private String kind;//类别 中西
//每个药品初始只有名称。编号。单价。规格。单位。剂量，类别
//用法，数量在写处方的时候编写
public Medicine(String name,String ID,String specification,String unit,double cost,String dosage,String kind){
    this.name=name;
    this.ID=ID;
    this.specification=specification;
    this.unit=unit;
    this.cost=cost;
    this.kind=kind;
    this.dosage=dosage;
}
public Medicine(String name,double cost){
    this.name=name;
    this.cost=cost;
}

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
