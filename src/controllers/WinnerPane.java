package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WinnerPane extends Pane {

    @FXML
    private Button clear;
    @FXML
    private Button submit;
    @FXML
    private Label fNameLabel;
    @FXML
    private Label lNameLabel;
    @FXML
    private TextField fNameTxtFld;
    @FXML
    private TextField lNameTxtFld;
    private String fName;
    private String lName;

    public void clickSubmitButton(){
        if(!this.fNameTxtFld.getText().equals("")
                && !this.lNameTxtFld.getText().equals("")) {
            this.fName = this.fNameTxtFld.getText();
            this.lName = this.lNameTxtFld.getText();
            Stage s = (Stage)this.submit.getScene().getWindow();
            s.close();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR,"Enter a valid name.");
            alert.showAndWait();
        }
    }

    public void clickClearButton(){
        this.fNameTxtFld.clear();
        this.lNameTxtFld.clear();
    }

    public String getFName(){
        System.out.println("FIRST NAME: "+ this.fName);
        return this.fName;
    }

    public String getLName() {
        System.out.println("LAST NAME: "+ this.lName);
        return this.lName;
    }

}
