import java.util.ArrayList;

public class FuncionesLisp {
    private ArrayList<Nodo> secuencia = new ArrayList<>();            
    
    public static ArrayList<Nodo> StringToNodo(ArrayList<String> expression){
    	ArrayList<Nodo> listaNod = new ArrayList<>();
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
    
    public static ArrayList<Nodo> pre(ArrayList<Nodo> expression, int a){
    	ArrayList<Nodo> respuesta = new ArrayList<>();        	
    	// solo para llamarla la primera vez usamos a=1
    	for (int i = a; i<expression.size(); i++) {
    		if (expression.get(i).getTipo() == 1) {
    			respuesta.add(expression.get(i));
    		}    		
    		// verificar si es string
    		if (expression.get(i).getTipo() == 2) {
    			String compare = expression.get(i).getDataS();    			
    			//verificar si es (
    			if(compare.equals("(")) {
    				int c = 1; // contador 
    				
    				ArrayList<Nodo> sublista = new ArrayList<Nodo>(); // crea una sublista
    				while (c != 0) {
    					i ++; // avanzo en la expression
    					
    					// verifico si es string
    					if (expression.get(i).getTipo() == 2) {
    						// verifico si hay "(", + 1
    						
    						if (expression.get(i).getDataS().equals("(")) {
    							c++;
    							sublista.add(expression.get(i));
    						}else if (expression.get(i).getDataS().equals(")")){
    							c--;
    							if (c != 0) { // aca esta el cierre ")"
    								sublista.add(expression.get(i));
    							}
    						}else {
    							sublista.add(expression.get(i));
    						}       						
    					}
    					
    					if (expression.get(i).getTipo() == 1) {
    						sublista.add(expression.get(i));
    					}
    				}
    				Nodo Sublista = new Nodo(sublista);
    				respuesta.add(Sublista);
    			}else {
    				if (expression.get(i).getDataS().equals(")")) {
    					
    				}else {
    					respuesta.add(expression.get(i));
    				}
    				
    			}
    		}
    		// verificar si es arraylist
    		if(expression.get(i).getTipo()==3) {    			
    		}
    	}
    	
    	return respuesta;
    }
    
    static ArrayList<Nodo> pre1(ArrayList<Nodo> expression){
    	for (int i = 0; i<expression.size();i++) {
    		if (expression.get(i).getTipo() == 3) { // encontro un arrayList
    			Nodo temp = new Nodo(pre(expression.get(i).getArrayListNodo(),0));
    			expression.set(i, temp);
    			
    			Nodo tempFinal = new Nodo(pre1(expression.get(i).getArrayListNodo()));
    			expression.set(i, tempFinal);
    		}
    	}
    	return expression;
    }
    
    /*
    // La expresion tiene si o si que comenzar con "("
    static ArrayList<Nodo> convert(ArrayList<Nodo> expression) {
    	
    	ArrayList<Nodo> respuesta = new ArrayList<Nodo>();
    	
    	// La expresion tiene si o si que comenzar con "("
    	//expression.remove(0); 	// Le quitamos el "("
    	
    	int max = expression.size();
    	
    	for (int i = 1; i < max; i++) {
    		if (expression.get(i).getTipo() == 2) {
    			String compare = expression.get(i).getDataS();
    			if (compare.equals("(")) { // hay construir una lista
        			
        			ArrayList<Nodo> sublista = new ArrayList<Nodo>(); // parametro a evaluar
        			sublista.add(expression.get(i)); // agrego el nodo con "("
        			// expression.remove(0); // borrando "(" del original
        			
        			int c =1;	//contador que me indica cuando "(" se cierra con su pareja ")"
        			
        			//int i1 = 0; //para que recorra expresion
        			while (c != 0) {
        				
        				if (expression.get(i).getTipo() == 2) {
        					String comp = expression.get(i).getDataS();
        					if (comp.equals("(")) {
            					c++;
            				}
        					if (comp.equals(")")) {
            					c--;
            				}
        				}

        				sublista.add(expression.get(i));
        				i++;
        			}
        			
        			//i = i1;
        			ArrayList<Nodo> Sublista1 = convert(sublista); 
        			Nodo Sublista = new Nodo(Sublista1); // haciendo un tipo nodo con atributo lista de nodos
        			respuesta.add(Sublista); // agregando sublistas a la lista
        		}
    		}
    		else {
    				respuesta.add(expression.get(i));
    			
    		}
    	}
    	
    	return respuesta;
    }*/
    
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