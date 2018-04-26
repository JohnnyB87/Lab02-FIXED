package classes;

import java.io.Serializable;

public class Winner implements Serializable{

    //---------------------------
    //          ATTRIBUTES
    //---------------------------
    private String fName;
    private String lName;
    private int prizeValue;

    //---------------------------
    //          CONSTRUCTORS
    //---------------------------
    public Winner(int prizeValue){
        this.prizeValue = prizeValue;
    }

    public Winner(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public Winner(String fName, String lName, int prizeValue){
        this.fName = fName;
        this.lName = lName;
        this.prizeValue = prizeValue;
    }

    //---------------------------
    //          GETTERS
    //---------------------------
    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    //---------------------------
    //          SETTERS
    //---------------------------
    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setPrizeValue(int prizeValue) {
        this.prizeValue = prizeValue;
    }

    public String toString(){
        String str = String.format("Name: %s %s Prize Value: %d",this.fName,this.lName,this.prizeValue);
        return str;
    }
}
