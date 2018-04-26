package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import treePackage.*;

public class PrizeTab extends Tab{

    private Tree<String, String> prizes;
    private TilePane tileButtons;
    private ListView<String> list;
    private ObservableList<String> items;

    public PrizeTab(String colour) {
        this.setText("Prizes");
        this.setClosable(false);

        Label label = new Label("CONGRATULATIONS");
        label.setAlignment(Pos.BASELINE_CENTER);

        this.tileButtons = new TilePane(Orientation.VERTICAL);
        this.tileButtons.setBackground(new Background(new BackgroundFill(Color.web(colour), CornerRadii.EMPTY, Insets.EMPTY)));
        this.tileButtons.setAlignment(Pos.CENTER);
        this.tileButtons.setHgap(5.0);
        this.tileButtons.setVgap(10.0);
        this.tileButtons.setMinHeight(75);
        this.tileButtons.getChildren().add(label);

        this.setContent(this.tileButtons);

    }

    public void loadPrizes(int n){

        this.items = FXCollections.observableArrayList();

        try{
            this.prizes = new Tree<>();
            String pathToFile = "docs/prizes.txt";

            File readMe = new File(pathToFile);
            FileReader fr = new FileReader(readMe);
            BufferedReader br = new BufferedReader(fr);

            String newLine = br.readLine();
            do{
                fillTree(n, newLine);
                newLine = br.readLine();
            }while(newLine != null);

            br.close();

        }catch(IOException ioe){

        }

        createListView();

        this.tileButtons.getChildren().clear();
        this.tileButtons.getChildren().add(this.list);


    }

    public void fillTree(int n, String newLine){

        String[] array = newLine.split(",");
        int prizeValue = -1;

        try{
            prizeValue = Integer.parseInt(array[0]);
        }catch(NumberFormatException nfe) {
            System.out.println("ERROR: " + Arrays.toString(array));
        }

        if(prizeValue == n) {
            String key = array[1];
            String value = array[2];
            this.prizes.insertNode(key, value);
            this.items.add(key);
        }
        else if(prizeValue == -1) {
            System.out.println("ERROR: prizeValue = -1    -     " + array[0]);
        }


    }

    private void createListView(){
        this.list = new ListView<>();

        this.list.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("You selected " + newValue);

                    String str = "You won \n" + prizes.findByKey(newValue);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, str);
                    alert.showAndWait();

                    this.setDisable(true);
                }
        );

        this.list.setItems(this.items);
        this.list.getSelectionModel().clearSelection();
        this.list.setPrefHeight((this.items.size() + 2)* 24 + 2);
    }

}
