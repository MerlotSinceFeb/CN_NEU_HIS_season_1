package Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientToFinish {
    public StringProperty name;
    public StringProperty age;
    public PatientToFinish(String name,int age){
        this.name=new SimpleStringProperty(name);
        this.age=new SimpleStringProperty(Integer.toString(age));
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }



    public String getAge() {
        return age.get();
    }

    public StringProperty ageProperty() {
        return age;
    }


}
