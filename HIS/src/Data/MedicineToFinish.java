package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicineToFinish {
    private StringProperty name;//药名
    private StringProperty  cost;//药品单价
    private StringProperty specification;//规格
    private StringProperty unit;//单位，袋，盒
    private StringProperty kind;//类别 中西
public MedicineToFinish(String name,String cost,String specification,String unit,String kind){
    this.name=new SimpleStringProperty(name);
    this.cost=new SimpleStringProperty(cost);

    this.specification=new SimpleStringProperty(specification);
    this.unit=new SimpleStringProperty(unit);
    this.kind=new SimpleStringProperty(kind);
}
    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCost() {
        return cost.get();
    }

    public StringProperty costProperty() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost.set(cost);
    }

    public String getSpecification() {
        return specification.get();
    }

    public StringProperty specificationProperty() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification.set(specification);
    }

    public String getUnit() {
        return unit.get();
    }

    public StringProperty unitProperty() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit.set(unit);
    }

    public String getKind() {
        return kind.get();
    }

    public StringProperty KindProperty() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind.set(kind);
    }
}
