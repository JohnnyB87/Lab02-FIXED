package JunitTesting;

import classes.ListOfWinners;
import classes.Winner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOfWinnersTest {

    ListOfWinners lof;
    @BeforeEach
    void before(){
        setUp();
    }

    void setUp() {
        this.lof = new ListOfWinners();
        Winner w;
        for(int i=0;i<10;i++){
            w = new Winner("Forename"+i,"Surname"+i,5);
            lof.getWinners().add(w);
        }
    }

    @AfterEach
    void after(){

    }

    @Test
    void readFromFile() {
    }

    @Test
    void writeToFile() {
    }

    @Test
    void getWinnerByName() {
        Winner res = this.lof.getWinnerByName("Forename1","Surname1");
        Winner expected = new Winner("Forename1","Surname1",5);
        assertEquals(expected.getFName(), res.getFName());
        assertEquals(expected.getLName(), res.getLName());
        assertEquals(expected.getPrizeValue(), res.getPrizeValue());
    }

    @Test
    void getWinners() {
        ArrayList<Winner> res = this.lof.getWinners();
        for(int i=0; i<10;i++) {
            Winner expected = new Winner("Forename"+i,"Surname"+i,5);
            assertEquals(expected.getFName(), res.get(i).getFName());
            assertEquals(expected.getLName(), res.get(i).getLName());
            assertEquals(expected.getPrizeValue(), res.get(i).getPrizeValue());
        }
    }

    @Test
    void setWinners() {
    }

}