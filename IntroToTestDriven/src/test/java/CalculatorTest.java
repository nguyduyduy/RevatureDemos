import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // we do not need a constructor in this class
    // note we did not add a constructor to our 'Calculator' class either

    // implementing our tests

    @Test
    public void additionTest(){
        Assertions.assertEquals(8, Calculator.add(3,5));
    }

    @Test
    public void isDivisibleTest(){

        Assertions.assertEquals(true, Calculator.divide(10,2));
    }
}
