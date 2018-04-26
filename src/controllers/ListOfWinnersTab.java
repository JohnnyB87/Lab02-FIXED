package controllers;

import classes.ListOfWinners;
import classes.Winner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import java.io.*;
import java.util.Arrays;

public class ListOfWinnersTab extends Tab {

    private TableView<Winner> winnersTableView;
    private TableColumn<Winner, String> firstName;
    private TableColumn<Winner, String> lastName;
    private TableColumn<Winner, String> starPrize;
    private Button reportBtn;
    private static ListOfWinners lof;

    public ListOfWinnersTab() throws Exception{
        lof = new ListOfWinners();
        lof.readFromFile();

        Pane winnerPane = new Pane();
        winnerPane.prefHeight(350);
        winnerPane.prefWidth(410);

        reportBtn = new Button("Generate Report");
        reportBtn.setLayoutX(150);
        reportBtn.setLayoutY(270);

        firstName = new TableColumn<>("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        firstName.setMaxWidth(100);

        lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        lastName.setMaxWidth(100);

        starPrize = new TableColumn<>("Prize Value");
        starPrize.setCellValueFactory(new PropertyValueFactory<>("prizeValue"));
        starPrize.setMaxWidth(100);

        winnersTableView = new TableView<>();
        winnersTableView.setMaxSize(300,200);
        winnersTableView.setLayoutX(75);
        winnersTableView.setLayoutY(50);

        winnersTableView.setItems(toObservableList());

        winnersTableView.getColumns().addAll(firstName, lastName, starPrize);

        winnerPane.getChildren().addAll(winnersTableView, reportBtn);

        this.setContent(winnerPane);

        reportBtn.setOnAction(e -> reportButtonPressed());
    }

    public void reportButtonPressed() {
        String str = winnersTableView.getSortOrder().size() > 0
                ? winnersTableView.getSortOrder().get(0).getText(): "Unordered";
        String fileName = str + "Report.txt";
        try {
            File file = new File("docs/" + fileName);
            PrintWriter pw = new PrintWriter(file);
            System.out.println("CREATING FILE...");
            System.out.println("-----------------");
            for (Winner w : winnersTableView.getItems()) {
                System.out.println(w.toString());
                pw.write(w.toString()+ "\n");
            }
            pw.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("-----------------\n");

    }



    public ObservableList<Winner> toObservableList(){
        ObservableList<Winner> ol = FXCollections.observableArrayList();
        for(Winner w : lof.getWinners()) {
            ol.add(new Winner(w.getFName(), w.getLName(),w.getPrizeValue()));
        }
        return ol;
    }

    public ListOfWinners getLof(){
        return lof;
    }

    public TableView<Winner> getWinnersTableView() {
        return this.winnersTableView;
    }
}
