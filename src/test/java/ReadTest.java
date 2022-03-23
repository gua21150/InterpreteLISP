import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReadTest {
   
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> expectedList = new ArrayList<>();
    @Test
    void readFile() {
        expectedList.add("(+ 5 6 / (- 4  19))");
        assertEquals("No operable", Read.readFile("lispExpression.txt",list).get(0));
    }

    @Test
    void readFile2(){
        expectedList.clear();
        expectedList.add("(");
        expectedList.add("+");
        expectedList.add("5");
        expectedList.add("6");
        expectedList.add("/");
        expectedList.add("(");
        expectedList.add("-");
        expectedList.add("4");
        expectedList.add("1.9");
        expectedList.add(")");
        expectedList.add(")");
        assertIterableEquals(expectedList, Read.readFile("lispExpression.txt",list));
    }
}