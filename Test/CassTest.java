import org.junit.Test;

import static org.junit.Assert.*;

public class CassTest {
    Cass c = new Cass();
    @Test
    public void maxP() throws Exception {
        int [] price = {1,2,3,4,5,6,6};
        Cass.Res res = c.max(c.deltaP(price),0,c.deltaP(price).length-1);
        assertEquals(0,res.leftIndex);
        assertEquals(5,res.rightIndex);
        assertEquals(5,res.sum);
    }
    @Test
    public void maxP1() throws Exception {
        int [] price = {4,3,2,1};
        Cass.Res res = c.max(c.deltaP(price),0,c.deltaP(price).length-1);
        assertEquals(0,res.leftIndex);
        assertEquals(0,res.rightIndex);
        assertEquals(0,res.sum);
    }
    @Test
    public void maxP2() throws Exception {
        int [] price = {1,1,1,1};
        Cass.Res res = c.max(c.deltaP(price),0,c.deltaP(price).length-1);
        assertEquals(0,res.leftIndex);
        assertEquals(0,res.rightIndex);
        assertEquals(0,res.sum);
    }

}