package JunitTesting;

import classes.Winner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {
    Winner winner;
    @BeforeEach
    public void before(){
        this.winner = new Winner("John","Brady",5);
    }

    @Test
    public void getFName() {
        String res = this.winner.getFName();
        assertEquals("John",res);
    }

    @Test
    public void getLName() {
        String res = this.winner.getLName();
        assertEquals("Brady",res);
    }

    @Test
    public void getPrizeValue() {
        int res = this.winner.getPrizeValue();
        assertEquals(5,res);
    }

    @Test
    public void setFName() {
        this.winner.setFName("Emma");
        String res = this.winner.getFName();
        assertEquals("Emma",res);
    }

    @Test
    public void setLName() {
        this.winner.setFName("Dunne");
        String res = this.winner.getLName();
        assertEquals("Dunne",res);
    }

    @Test
    public void setPrizeValue() {
        this.winner.setPrizeValue(6);
        int res = this.winner.getPrizeValue();
        assertEquals(6,res);
    }

}
