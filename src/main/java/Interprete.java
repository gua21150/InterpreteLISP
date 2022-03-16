import java.util.ArrayList;
import java.util.Stack;

public class Interprete {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();          // lista temporal que recibe la expresión del archivo de texto        
        Stack stack1 = new Stack();        
        Read.readFile("lispExpression.txt",list);
        for (String str : list) {
            System.out.println(str);
        }
        
        System.out.println("----------------------------------");
        
        ArrayList<Nodo> convertido = FuncionesLisp.StringToNodo(list);
        
        ArrayList<Nodo> tok =  FuncionesLisp.convert(convertido);
        
        for (Nodo x: tok) {
            if (x.getTipo()==3) {
                System.out.println("Comienza la sublista");
                for (Nodo l: x.getArrayListNodo()) {
                	System.out.print("En lista: ");
                	System.out.println(l);
                }
            }else if (x.getTipo()==1){
            	System.out.println(x.getDataF());
            }else {
            	System.out.println(x.getDataS());
            }
        }
    }
}
