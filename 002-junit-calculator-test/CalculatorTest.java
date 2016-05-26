import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testAdd() {

    Calculator calculator = new Calculator();

    // Arrange
    double firstNumber = 10;
    double secondNumber = 50;
    double expected = 60;

    // Act
    double result = calculator.add(firstNumber, secondNumber);

    // Assert
    assertEquals(expected, result, 0);
    
  }
}
