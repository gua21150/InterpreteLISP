import java.util.ArrayList;
import java.util.HashMap;

public class FuncionesLisp {
    private ArrayList<Nodo> secuencia = new ArrayList<>();
    /*
    private ArrayList<String> sucio = new ArrayList<>();
    public void operar(){
        // oh no
        this.sucio = Read.readFile("lispExpression.txt",sucio);

    }*/

    public ArrayList<Nodo> convert(ArrayList<Nodo> expression) {
        ArrayList<Nodo> respuesta = new ArrayList<Nodo>();
        Nodo nodo; 
               
        for (int i = 1; i < expression.size(); i++) {
            if(expression.get(i).equals("(")) {
                respuesta.remove(0);
                Nodo temp = new Nodo(convert(expression));
                respuesta.add(temp);
            } else {
                if(expression.get(i).equals(")")){
                    return respuesta;
                } else{
                    
                    respuesta.add(expression.get(i));
                    expression.remove(i);
                }
            }
        }        
    }

    /*
    public ArrayList<Nodo> convert(ArrayList<Nodo> expression) {
        ArrayList<Integer> posiciones = new ArrayList<>(); // sirve para colocar las posiciones de cada parentesis de apertura
        int posicion = 0;
        int parentesisAbiertos=0;

        for (Nodo str : expression) {
            if(str.equals("(")) {                
                parentesisAbiertos++;            
        }

        for (int i = 0; i < array.length; i++) {
            
        }
        for (Nodo Nodo : expression) {
            if(str.equals("(")) {
                posicion++;
                parentesisAbiertos++;
            } 
            if(str.equals(")")) {
                posicion--;
            }
        }
        
        for (int i = 0; i < expression.size(); i++) {
            
        }
        return secuencia;
    }*/
}