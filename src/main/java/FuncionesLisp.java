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
    
    
    
    // Necesitamos convertir nuestra lista de tokens (tipo String) en tipo Nodo 
    // para que entre en la función convert
    
    static ArrayList<Nodo> StringToNodo(ArrayList<String> expression){
    	ArrayList<Nodo> listaNod = new ArrayList<Nodo>();
    	for (String x: expression) {
    		try {
    			float num = Float.parseFloat(x);
    			Nodo nodo = new Nodo(num);
    			listaNod.add(nodo);
    		}catch (Exception e) {
    			Nodo nodo = new Nodo(x);
    			listaNod.add(nodo);
    		}
    	}
    	
    	return listaNod;
    }
    
    // La expresion tiene si o si que comenzar con "("
    static ArrayList<Nodo> convert(ArrayList<Nodo> expression) {
    	
    	ArrayList<Nodo> respuesta = new ArrayList<Nodo>();
    	
    	// La expresion tiene si o si que comenzar con "("
    	expression.remove(0); 	// Le quitamos el "("
    	
    	for (int i = 0; i < expression.size(); i++) {
    		if (expression.get(i).getTipo() == 2) {
    			String compare = expression.get(i).getDataS();
    			if (compare.equals("(")) { // hay construir una lista
        			
        			ArrayList<Nodo> sublista = new ArrayList<Nodo>(); // parametro a evaluar
        			sublista.add(expression.get(i)); // agrego el nodo con "("
        			expression.remove(0); // borrando "(" del original
        			
        			int c =1;	//contador que me indica cuando "(" se cierra con su pareja ")"
        			
        			int i1 = 0; //para que recorra expresion
        			while (c != 0) {
        				
        				if (expression.get(i).getTipo() == 2) {
        					String comp = expression.get(i).getDataS();
        					if (comp.equals("(")) {
            					c++;
            				}
        					if (comp.equals(")")) {
            					c++;
            				}
        				}

        				sublista.add(expression.get(i1));
        				i1++;
        			}
        			
        			i = i1;
        			
        			Nodo Sublista = new Nodo(convert(sublista)); // haciendo un tipo nodo con atributo lista de nodos
        			respuesta.add(Sublista); // agregando sublistas a la lista
        		}
    		}
    		else {
    				respuesta.add(expression.get(i));
    			
    		}
    	}
    	
    	return respuesta;
    }
    
    /*
    public ArrayList<Nodo> convert(ArrayList<Nodo> expression) {
        ArrayList<Nodo> respuesta = new ArrayList<Nodo>();
               
        for (int i = 0; i < expression.size(); i++) {
        	if (i ==1) {
        		respuesta.remove(0); // se esta eliminando el primer parentesis 
        	}
            if(expression.get(i).equals("(")) {
                Nodo temp = new Nodo(convert(expression));
                respuesta.add(temp);
            } else {
                respuesta.add(expression.get(i));
                expression.remove(i);
                
            }
        }
        
        return respuesta;
    }*/

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