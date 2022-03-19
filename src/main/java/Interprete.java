import java.util.ArrayList;
import java.util.Stack;

public class Interprete {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();          // lista temporal que recibe la expresión del archivo de texto        
        Stack stack1 = new Stack();        
        Read.readFile("lispExpression.txt",list);
        int cd = 0;
        for (String str : list) {
        	cd++;
            System.out.println(str);
        }
        System.out.println(cd);
        
        System.out.println("----------------------------------");
        
        ArrayList<Nodo> convertido = FuncionesLisp.StringToNodo(list);
        
        ArrayList<Nodo> prueba = FuncionesLisp.pre(convertido,1);
        ArrayList<Nodo> prueba1 = FuncionesLisp.pre1(prueba);
        
        System.out.println(prueba1.get(5).getArrayListNodo().get(0).getDataS());
        
        System.out.println("----------------------------------");
       
        
        //ArrayList<Nodo> tok =  FuncionesLisp.convert(convertido);
        
        int cont_lista = 0;
        /*
        for (Nodo x: prueba) {
            if (x.getTipo()==3) {
            	cont_lista ++;
                System.out.println("Comienza la sublista:" + cont_lista);
                //System.out.println(x.getArrayListNodo().size());
                for (Nodo l: x.getArrayListNodo()) {
                	
                		System.out.print("Esta en lista: ");
                		if (l.getTipo()==2) {
                			System.out.println(l.getDataS());
                		}
                		if (l.getTipo()==1) {
                			System.out.println(l.getDataF());
                		}
                	
                }
            }else if (x.getTipo()==1){
            	System.out.println(x.getDataF());
            }else {
            	System.out.println(x.getDataS());
            }
        }*/
    }
}
