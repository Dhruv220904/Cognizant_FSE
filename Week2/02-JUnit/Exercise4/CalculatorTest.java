import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest{
 Calculator c;
 @BeforeEach
 void setUp(){ c=new Calculator(); }
 @AfterEach
 void tearDown(){ c=null; }
 @Test
 void testMultiply(){
   // Arrange done in setUp
   int result=c.multiply(4,5); // Act
   assertEquals(20,result);    // Assert
 }
}
