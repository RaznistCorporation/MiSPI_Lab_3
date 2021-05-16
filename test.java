package tests;

import backpack.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    private Information information;

    @Before
    public void create() {
        information = new Information(0.0, 0.0, 0.0, "");
    }

    @After
    public void resetPoint() {
        information = null;
    }


    @Test
    public void testTotal() {

        String testResult = "null";

        for (double x = -3.0; x<4; x+=0.1) {
            for (double y = -5; y<5; y+=0.1) {
                for (double r = 1.0; r<=5.0; r+=1.0){
                information.setCoordinateX(x);
                information.setCoordinateY(y);
                information.setValueR(r);
                if ((x * x + y * y <= r * r / 4 && x >= 0 && y <= 0) ||
                        (((y+x/2) <= r/2) && x >= 0 && y >= 0) ||
                        (-y <=r && -x <= r/2 && y <= 0 && x <= 0)){
                    testResult = "true";
                }
                else {
                    testResult = "false";
                }
                }

                assertEquals(information.getResult(), testResult);
            }
        }
    }

    @Test
    public void testTotalRandom() {

        String testResult = "null";

        double x,y,r;
        for (int i = 0; i<1000; i++) {
            x = (double) (Math.random() * 50);
            y = (double) (Math.random() * 50);
            r = (double) (Math.random() * 100 + 1);
            information.setCoordinateX(x);
            information.setCoordinateY(y);
            information.setValueR(r);
            if ((x * x + y * y <= r * r / 4 && x >= 0 && y <= 0) ||
                    (((y+x/2) <= r/2) && x >= 0 && y >= 0) || (-y <=r && -x <= r/2 && y <= 0 && x <= 0)){
                            testResult = "true";
                        }
                        else {
                            testResult = "false";
                        }

                assertEquals(information.getResult(), testResult);

        }
    }
}
