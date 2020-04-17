import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testIsSameNumber() {
        int i = 50;
        int j = 2;
        int k = 500;
        //assertTrue("isSameNumber method has a bug",!Flik.isSameNumber(i, j));
        assertTrue("isSameNumber method has a bug", Flik.isSameNumber(i, i));
    }
}
