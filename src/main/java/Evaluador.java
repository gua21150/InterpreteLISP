import java.util.ArrayList;
import java.util.HashMap;

public class Evaluador {
	
	private static HashMap<String,Nodo> funciones = new HashMap<String,Nodo>();
	
	/** Convierte el String defun en una lista de nodos (tokens) */
	static void defun(ArrayList<String> expression){
		ArrayList<Nodo> convertido = FuncionesLisp.StringToNodo(expression);
		ArrayList<Nodo> prueba = FuncionesLisp.pre(convertido,1);
        ArrayList<Nodo> a_eval = FuncionesLisp.pre1(prueba);
        
        /** verifico que el primer elemento es tipo string*/
        if (a_eval.get(0).getTipo() == 2) {
        	Nodo implementacion = new Nodo (a_eval.get(2).getArrayListNodo());
        	funciones.put(a_eval.get(0).getDataS(),implementacion);
        }
	} 
	
	static Nodo evaluar(String nombreFunc, ArrayList<Nodo> implementacion, ArrayList<Nodo> parametros) {
		
		/** Recorrer el mapa y buscar el nombre de la funcion */
		if(funciones.containsKey(nombreFunc)) {
			
		/** El primer elemento siempre es el nombre de una funcion, un String*/
		if (implementacion.get(0).getTipo() == 2) {
			
			if (implementacion.get(0).getDataS().equals("+")) {
				
				/** Cada parametro puede ser una funcion*/
				//Nodo a = new Nodo(evaluar(implementacion.get(1) ))
				
				//OperacionesBasicas.suma(0, 0);
			}
			
		}
			
			
		}else { 
			return null;
		}
		
		return null;
	}
	
	/* ( defun fibonacci (parametro1  parametro1) (+ paramtero1 parametro 2) ) */
	
		
	/*
	static evaluarUsurio(ArrayList<Nodo> expresion, ArrayList<Nodo> parametros) {
		
	}*/
}
