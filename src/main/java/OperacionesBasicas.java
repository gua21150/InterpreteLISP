public class OperacionesBasicas {
	// -------------- Operaciones aritmeticas
	private OperacionesBasicas(){}
	// suma dos numeros
	static float suma(float a, float b) {
		return a+b;
	}
	
	static float resta(float a, float b) {
		return a-b;
	}
	
	static float multiplicacion(float a, float b) {
		return a*b;
	}
	
	static float division(float a, float b) {
		if (b != 0) {
			double resultado = (double)a/b;
			return (float)resultado;
		}else {
			return 0;
		}
	}
	
	static boolean igual(Nodo a, Nodo b) {
		
		if(a.getTipo() == b.getTipo()) {
			if (a.getTipo() == 1 && b.getTipo() == 1) {
				if (a.getDataF() == b.getDataF()) {
					return true;
				}else {
					return false;
				}
			}else if (a.getTipo() == 2 && b.getTipo() == 2) {
				if (a.getDataS().equals(b.getDataS())) {
					return true;
				}else {
					return false;
				}
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		
	}
	
	
	
}
