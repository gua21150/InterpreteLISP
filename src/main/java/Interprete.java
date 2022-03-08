import java.util.ArrayList;
import java.util.Stack;

public class Interprete {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();          // lista temporal que recibe la expresión del archivo de texto
        Stack stack1 = new Stack();
        Read read = new Read();
        read.tokens(list);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
