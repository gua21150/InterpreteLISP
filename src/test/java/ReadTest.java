import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReadTest {
    Read reader = new Read();
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> expectedList = new ArrayList<>();
    @Test
    void readFile() {
        expectedList.add("(+ 5 6 / (- 4  19))");
        assertIterableEquals(expectedList, reader.readFile(list));
    }

    @Test
    void tokens() {
        expectedList.clear();
        expectedList.add("(");
        expectedList.add("+");
        expectedList.add("5");
        expectedList.add("6");
        expectedList.add("/");
        expectedList.add("(");
        expectedList.add("-");
        expectedList.add("4");
        expectedList.add("19");
        expectedList.add(")");
        expectedList.add(")");
        assertIterableEquals(expectedList, reader.tokens(list));
    }
}