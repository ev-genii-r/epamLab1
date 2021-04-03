import com.epam.lab1.sort.BubbleSort;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class outputTest {
   public void sortTest(){
       String commonString="qwerty\nqwerty22\nqwerty1\n";
       String expected="qwerty\nqwerty1\nqwerty22\n";
       BubbleSort bubbleSort=new BubbleSort();
       String actual=bubbleSort.sortString(commonString);
       Assert.assertEquals(actual,expected);
   }
}
