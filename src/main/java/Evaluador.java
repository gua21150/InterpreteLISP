import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

/**
 * 
 * Evaluar y definir funciones
 *
 */
public class Evaluador {
	
	// Mapa que guarda el nombre (String) de la funcion y como valor la implementacion (ArrayList de nodos)
	private static HashMap<String,ArrayList<Nodo>> funciones = new HashMap<String,ArrayList<Nodo>>();
	
	// Mapa que guarda cada parametro (String) de la funcion y tiene como valor el valor lista de parametros
	private static HashMap<String,ArrayList<String>> parametros = new HashMap<String,ArrayList<String>>();
	
	
	// Mapa para guardar variables que se les asigna valores
	private static HashMap<String, Nodo> variables = new HashMap<String, Nodo>();
	
	/** 
	 * Convierte el String defun en una lista de nodos (tokens) 
	 * Funcion a llamar cada vez que se haga un defun
	 * @param expression: 
	*/	
	ArrayList<Nodo> a_eval;
	private Evaluador(){}

	/** Convierte el String defun en una lista de nodos (tokens) */
	static void defun(ArrayList<String> expression){
		ArrayList<Nodo> convertido = FuncionesLisp.StringToNodo(expression);
		ArrayList<Nodo> prueba = FuncionesLisp.pre(convertido,1);
        ArrayList<Nodo> a_eval = FuncionesLisp.pre1(prueba);
        
        // verifico que el primer elemento es tipo string
        // En la posicion se encuentra el nombre de la funcion
        if (a_eval.get(1).getTipo() == 2) {
        	// Implementacion es una lista de nodos en la posicion 3
        	ArrayList<Nodo> implementacion = a_eval.get(3).getArrayListNodo();
        	
        	// La key, el nombre de la funcion, esta siempre en posicion 1
        	funciones.put(a_eval.get(1).getDataS(),implementacion);
        }
        
        // Verifico que el objeto es de tipo ArrayList
        if (a_eval.get(2).getTipo() == 3) {
        	// Entonces, guardar en el mapa de parametros
        	
        	// lista de parametros
        	ArrayList<String> temp = new ArrayList<String>();
        	for(Nodo x: a_eval.get(2).getArrayListNodo()) {
        		temp.add(x.getDataS());
        	}
        	
        	// Key: el nombre de la funcion, valor: lista de nodos (parametros)
        	parametros.put(a_eval.get(1).getDataS(), temp);
        }
	} 
	
	// (defun fibonacci (n) (cond ((= n 1) 1) ((= n 2) 1) (T (+ (fibonacci (- n 1)) (fibonacci (- n 2))))))
	
	
	
	
	
	
	
	
	/*
	static Nodo cond(Nodo expression) {
		// El primer elemento de expression ser� cond
		Nodo respuesta = null;
		
		// Verifico que el nodo sea de tipo ArrayList
		if (expression.getTipo() == 3) {
			// Recorremos la expression a partir del segundo elemento
			for (int i = 1; i<expression.getArrayListNodo().size(); i++) {
				
				// Creo nodo expression1 que son las condiciones a evaluar
				
				Nodo eval = expression.getArrayListNodo().get(i);
				
				// Si el nodo es de tipo Arraylist
				if (eval.getTipo() == 3) {
					
					// Recorremos el ArrayList de eval
					ArrayList<Nodo> condicion = eval.getArrayListNodo();
					
					for (int j = 0; j<condicion.size(); j++) {
						
						if (condicion.get(j).getTipo() == 2) {
							// Entonces el nodo es tipo String
							// Debe ser T, significa que devuelve el siguiente nodo como valor
							
							if (condicion.get(j).getDataS().equals("T")) {
								
								if (condicion.get(j+1).getTipo() == 1 || condicion.get(j+1).getTipo()== 0) {
									// Rompo el ciclo 
									// Si el siguiente elemento es un string o float, devuelve ese nodo
									respuesta = condicion.get(j+1);
									return respuesta;
									
									
								}else {
									// Es tipo 3, ArrayList
									// Evaluamos la expresion 
									respuesta = evaluar(condicion.get(j+1).getArrayListNodo());
									return respuesta;
								}
							}else {
								// Error de sintaxtis
								// No se puede evaluar
								return null;
							}
							
						} else if (condicion.get(j).getTipo() == 3) {
							// Entonces hay que evaluar la condici�n
							
							// Utilizar operaciones de comparacion
							
							// el primer elemento debe ser un String, operaci�n, para comparar
							if (condicion.get(j).getArrayListNodo().get(0).getTipo() == 2) {
								
								if (condicion.get(j).getArrayListNodo().get(0).getDataS().equals("=")) {
									// Evaluo u obtengo el valor de los parametros
									
									
									if (condicion.get(j).getArrayListNodo().get(1).getTipo() == 3){
										condicion.set(j, evaluar(condicion.get(j).getArrayListNodo().get(1).getArrayListNodo()));
									}
									
									if (condicion.get(j).getArrayListNodo().get(2).getTipo() == 3){
										condicion.set(j, evaluar(condicion.get(j).getArrayListNodo().get(2).getArrayListNodo()));
									}
									
									
									if (OperacionesBasicas.igual(condicion.get(j).getArrayListNodo().get(1), condicion.get(j).getArrayListNodo().get(2))) {
										// Entonces son iguales
										respuesta = eval.getArrayListNodo().get(1);
									}else {
										
									}
									
								}else {
									return null;
								}
								
							}else {
								// No puede darse el caso
								return null;
							}
						}
					}
					
				}else {
					// Error de sintaxtis, no ser� posible evaluar
					return null;
				}

			}
		}else {
			// no es posible este caso
			return null;
		}
		return respuesta;
		
	}
	
	*/
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param expression: es la funcion a evaluar, lista de nodos. Ej: (+ 5 6) ---> [+ 5 6]
	 *  @param expression1: es una copia de expression
	 * @return un nodo, el valor resultante de evaluar la funcion
	 */
	/*
	static Nodo evaluar(ArrayList<Nodo> expression, ArrayList<Nodo> expression1) {
		
		//ArrayList<Nodo> val_parametros = new ArrayList<Nodo>();
		
		
		// Se crea una lista de parametros tipo nodo
		ArrayList <Nodo> parametros1 = new ArrayList <Nodo>();
		
		// Recoro los nodos que son par�metros de la expressionj
		for (int i = 1; i<expression.size(); i++) {
			
			// Verifico si el parametro es ArrayList
			if (expression.get(i).getTipo() == 3) {
				// Entonces el parametro es una funcion
				// Encontrar el valor resultante de evaluar la funcion
				Nodo parametro = evaluar(expression.get(i).getArrayListNodo(), expression1);
				
				// Intercambiar por su valor el parametro a lista de parametros
				parametros1.set(i, parametro);
			}
			
			// Verifico si el nodo es un tipo 2, un String
			if (expression.get(i).getTipo() == 2) {
				// Solo ocurre cuando se esta evaluando internamente
				// El primer elemento de expression1 es el nombre de la funcion principal que se eval�a
				ArrayList<String> para = parametros.get(expression1.get(0).getDataS());
				for (int k = 0; k<para.size();k++) {
					if (para.get(k).equals(expression.get(i).getDataS())) {
						// Entonces intercambiar String por valor
						
						// identificando de que tipo es
						if (expression1.get(k+1).getTipo() == 3) {
							Nodo parametro = evaluar(expression1.get(k+1).getArrayListNodo(), expression1.get(k+1).getArrayListNodo());
						}
					}
				}
			}
			// Si es de tipo 1, es un float, no hay que hacerle ajustes
		}
		
		// El primer elemento de expression siempre ser� el nombre de la funci�n
		// Verifico que el primer elemento es String
		if (expression.get(0).getTipo() == 2) {
			// Verifico si es operacion suma 
			if (expression.get(0).getDataS().equals("+")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.suma(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
				
				// Regreso el valor de la evaluacion
				return resultado;
				
				// Verifico si es operacion resta
			}else if(expression.get(0).getDataS().equals("-")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.resta(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
			
				// Regreso el valor de la evaluacion
				return resultado;
				
				// Verifico si es operacion division
			}else if (expression.get(0).getDataS().equals("/")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.division(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
			
				// Regreso el valor de la evaluacion
				return resultado;
				
				// Verifico si es operacion multiplicacion
			}else if (expression.get(0).getDataS().equals("*")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.multiplicacion(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
			
				// Regreso el valor de la evaluacion
				return resultado;
			
				
			}else {
				// Quiere decir que no es una funcion basica
				// Entonces, se comprueba si fue una funcion ingresada
				
				if (funciones.containsKey(expression.get(0).getDataS())) {
					// Entonces es una funcion definida con defun
					
					Nodo resultado = evaluar(funciones.get(expression.get(0).getDataS()), nombreF);
					
					// Regreso el valor de la evaluacion
					return resultado;
				}else {
					// No se puede evaluar, ya que no se encontr� la funci�n
					return null;
				}
			}
			
		}else {
			// No se puede evaluar sin nombre de la funci�n
			return null;
		}
		
		
	}*/
	
	static Nodo evaluar1(ArrayList<Nodo> expression, ArrayList<Nodo> expression1) {
		
		//ArrayList<Nodo> val_parametros = new ArrayList<Nodo>();
		
		
		// Se crea una lista de parametros tipo nodo
		ArrayList <Nodo> parametros1 = new ArrayList <Nodo>();
		
		// Recoro los nodos que son par�metros de la expression j
		for (int i = 1; i<expression.size(); i++) {
			
			// Verifico si el parametro es ArrayList
			if (expression.get(i).getTipo() == 3) {
				// Entonces el parametro es una funcion
				// Encontrar el valor resultante de evaluar1 la funcion
				Nodo parametro = evaluar1(expression.get(i).getArrayListNodo(), expression1);
				
				// Intercambiar por su valor el parametro a lista de parametros
				parametros1.add(parametro);
			}
			
			// Verifico si el nodo es un tipo 2, un String
			if (expression.get(i).getTipo() == 2) {
				
				// Solo ocurre cuando se esta evaluando internamente
				// El primer elemento de expression1 es el nombre de la funcion principal que se eval�a
				ArrayList<String> para = parametros.get(expression1.get(0).getDataS());
				for (int k = 0; k<para.size();k++) {
					if (para.get(k).equals(expression.get(i).getDataS())) {
						// Entonces intercambiar String por valor
						Nodo parametro_nuevo = expression1.get(k+1);
						parametros1.add(parametro_nuevo);
					}
				}
				
			}
			
			if (expression.get(i).getTipo() == 1) {
				parametros1.add(expression.get(i));
			}
			// Si es de tipo 1, es un float, no hay que hacerle ajustes
		}
		
		// El primer elemento de expression siempre ser� el nombre de la funci�n
		// Verifico que el primer elemento es String
		if (expression.get(0).getTipo() == 2) {
			// Verifico si es operacion suma 
			if (expression.get(0).getDataS().equals("+")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.suma(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
				
				// Regreso el valor de la evaluacion
				return resultado;
				
				// Verifico si es operacion resta
			}else if(expression.get(0).getDataS().equals("-")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.resta(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
			
				// Regreso el valor de la evaluacion
				return resultado;
				
				// Verifico si es operacion division
			}else if (expression.get(0).getDataS().equals("/")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo ((float)OperacionesBasicas.division(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
			
				// Regreso el valor de la evaluacion
				return resultado;
				
				// Verifico si es operacion multiplicacion
			}else if (expression.get(0).getDataS().equals("*")) {
				// Realizo la operacion con los parametros correspondientes
				Nodo resultado = new Nodo (OperacionesBasicas.multiplicacion(parametros1.get(0).getDataF(), parametros1.get(1).getDataF()));
			
				// Regreso el valor de la evaluacion
				return resultado;
			}else {
				// Quiere decir que no es una funcion basica
				// Entonces, se comprueba si fue una funcion ingresada
				
				if (funciones.containsKey(expression.get(0).getDataS())) {
					// Entonces es una funcion definida con defun
					
					Nodo resultado = evaluar1(funciones.get(expression.get(0).getDataS()), expression1);
					
					// Regreso el valor de la evaluacion
					return resultado;
				}else {
					// No se puede evaluar1, ya que no se encontr� la funci�n
					return null;
				}
			}
			
		}else {
			// No se puede evaluar1 sin nombre de la funci�n
			return null;
		}
		
		
	}

	private static void setQ(Nodo a, Nodo b){
		switch (b.getTipo()){
			case 1:
				variables.put(a.getDataS(), b); // se agrega este valor
				System.out.println(b.getDataF());
			break;
			case 2:
				variables.put(a.getDataS(), b); // se agrega este valor
				System.out.println(b.getDataS());
			break;
			default:
				System.out.println("ASIGNACION NO VALIDA");
			break;
		}
	}

	private static Nodo getQ(Nodo a) {
		if(variables.containsKey(a.getDataS())) {			
			return variables.get(a.getDataS());
		} else {
			return null;
		}
	}

	public static Object isQuote(Nodo a) {
		switch(a.getTipo()) {
			case 1:
				System.out.println(a.getDataF());
				return a.getDataF();				
			case 2:
				System.out.println(a.getDataS());
				return a.getDataS();			
			case 3:
				String temp = "";
				for (Nodo element : a.getArrayListNodo()) {
					if(element.getTipo()==1){
						temp += element.getDataF()+" ";
					} else {
						if(element.getTipo()==2) {
							temp += element.getDataS()+" ";
						} else {
							if(element.getTipo()==3){
								isQuote(element);
							}
						}
					}
				}
				System.out.println(temp);
				return temp;		
			default: 
				return null;			
		}
	}
}
