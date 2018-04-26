package classes;

import controllers.GuessingGameTab;
import controllers.LotteryGameTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    private static Stage primaryStage = new Stage();

    public static void main(String[] args){
//        createOutOfMemory();
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return Main.primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage = getPrimaryStage();
        primaryStage.setTitle("Window");
        primaryStage.setResizable(false);

        TabPane tabPane = new TabPane();

        String colour = "#bcbcbc";
        GuessingGameTab guessingGameTab = new GuessingGameTab("Guessing Game","Guess", colour);
        LotteryGameTab lotteryGameTab = new LotteryGameTab("Lottery Game","Submit", colour);

        guessingGameTab.setClosable(false);
        lotteryGameTab.setClosable(false);

        tabPane.getTabs().addAll(guessingGameTab, lotteryGameTab);
        guessingGameTab.showLOfWTab();
        guessingGameTab.showPrizeTab();

        StackPane layout = new StackPane();
        layout.getChildren().addAll(tabPane);

        int windowWidth = 400;
        int windowHeight = 350;
        Scene scene = new Scene(layout, windowWidth, windowHeight);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static void createOutOfMemory(){
        ArrayList<Winner> winners = new ArrayList<>();
        while(true){
            Winner w = new Winner("fName","lName",3);
            winners.add(w);
        }
    }
}