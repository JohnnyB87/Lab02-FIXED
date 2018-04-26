package classes;

import java.io.*;
import java.util.*;

public class ListOfWinners implements Serializable{

    private ArrayList<Winner> winners = new ArrayList<>();
    private String fileName = "docs/Winners.bin";

    public void readFromFile(){

        try {
            FileInputStream fis = new FileInputStream(this.fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.winners = (ArrayList<Winner>) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e  ) {
            System.out.println("No such file exists\nCREATING FILE...");
            File file = new File(this.fileName);
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void writeToFile(){

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.winners);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Winner getWinnerByName(String fName, String lName){
        for(Winner w : this.winners){
            if(w.getFName().equalsIgnoreCase(fName)
                    && w.getLName().equalsIgnoreCase(lName)){
                return w;
            }
        }
        System.out.println("No winner by this name.");
        return null;
    }

    public ArrayList<Winner> getWinners(){
        return this.winners;
    }

    public void setWinners(ArrayList<Winner> winners) {
        this.winners = winners;
    }

}
