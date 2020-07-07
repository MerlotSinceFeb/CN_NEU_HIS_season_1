package Data;

import java.util.HashSet;
import java.util.Set;

public class Prescription {
    private String name;//处方名
    private Set<Medicine> medicineSet=new HashSet<>();//药品列表
    private double allCost;//总共花费
public Prescription(String name ,double allCost){
    this.name=name;
    this.allCost=allCost;
}
public Prescription(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Medicine> getMedicineSet() {
        return medicineSet;
    }

    public void setMedicineSet(Set<Medicine> medicineSet) {
        this.medicineSet = medicineSet;
    }

    public double getAllCost() {
        return allCost;
    }

    public void setAllCost(double allCost) {
        this.allCost = allCost;
    }
}
