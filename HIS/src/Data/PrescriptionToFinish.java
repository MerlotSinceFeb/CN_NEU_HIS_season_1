package Data;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrescriptionToFinish {
private StringProperty name;
private StringProperty num;
private Set<MedicineToFinish> MTFList=new HashSet<>();
private StringProperty allCost;
public PrescriptionToFinish(String name,String num,Set<MedicineToFinish> MTFList){
    this.name=new SimpleStringProperty(name);
    this.num=new SimpleStringProperty(num);
    this.setMTFList(MTFList);
    Iterator<MedicineToFinish> iterator = this.getMTFList().iterator();
    double costd=Double.parseDouble(iterator.next().getCost())+Double.parseDouble(iterator.next().getCost());
  this.allCost=new SimpleStringProperty  (""+costd);

}

    public String getNum() {
        return num.get();
    }

    public String getAllCost() {
        return allCost.get();
    }

    public StringProperty allCostProperty() {
        return allCost;
    }

    public void setAllCost(String allCost) {
        this.allCost.set(allCost);
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

    public String getAllcost() {
        return num.get();
    }

    public StringProperty numProperty() {
        return num;
    }

    public void setNum(String allcost) {
        this.num.set(allcost);
    }

    public Set<MedicineToFinish> getMTFList() {
        return MTFList;
    }

    public void setMTFList(Set<MedicineToFinish> MTFList) {
        this.MTFList = MTFList;
    }
}
