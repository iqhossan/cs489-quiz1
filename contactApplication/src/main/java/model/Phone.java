package model;

public class Phone {
    String phone;
    String label;

    public Phone(){

    }
    public Phone(String phone, String label) {
        this.phone = phone;
        this.label = label;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
