import java.util.ArrayList;
import java.util.Scanner;

public class Interprete {

    public static void main(String[] args) {
    	
        ArrayList<String> list = new ArrayList<>();          // lista temporal que recibe la expresión del archivo de texto        
        Scanner scan = new Scanner(System.in);
        Scanner scanS = new Scanner(System.in);
        String nameFile = "";
        int opcion = 0;
        System.out.println("Bienvenido al interprete LISP");
        while(opcion!=3) {            
            System.out.println("--------------------------------------");
            System.out.println("Ingrese la opcion a realizar.");
            System.out.println("1. Definir una función");
            System.out.println("2. Evaluar una función o expresion aritmetica");
            System.out.println("3. Salir");
            opcion=isNumberC(scan);
            list.clear();
            if(opcion==1) {
                System.out.println("Ingrese el nombre del archivo de texto para definir la funcion");
                nameFile = scanS.nextLine();
                try {                
                    Read.readFile(nameFile, list);
                    if(list.get(0).equals("No operable")) {
                        System.out.println("Verifique el archivo, no se cuenta con la misma cantidad de parentesis");
                    } else {
                        // se debe de hacer la llamada a lo que lee y define las expresiones                                               
                        Evaluador.defun(list);
                    }                    
                } catch (Exception e) {
                    System.out.println("El archivo no existe");
                }
            } else 
            {
                if(opcion==2) {
                    System.out.println("Ingrese el nombre del archivo de texto para evaluar la funcion.");
                    nameFile = scanS.nextLine();
                    try {                
                        Read.readFile(nameFile, list);
                        if(list.get(0).equals("No operable")) {
                            System.out.println("Verifique el archivo, no se cuenta con la misma cantidad de parentesis");
                        } else {
                            // se debe de hacer la llamada a lo que lee y evalua las expresiones
                            ArrayList<Nodo> convertido = FuncionesLisp.StringToNodo(list);        
                            ArrayList<Nodo> prueba = FuncionesLisp.pre(convertido,1);
                            ArrayList<Nodo> prueba1 = FuncionesLisp.pre1(prueba);                        
                            System.out.println(Evaluador.evaluar1(prueba1, prueba1).getDataF());
                        }                    
                    } catch (Exception e) {
                        System.out.println("Se ha producido un error" + e.getMessage());
                    }
                }
                else 
                    System.out.println("Ten buen dia");
            }                         
        }
        scan.close();
        scanS.close();
    
        
        /*
        System.out.println("----------------------------------");
        
        ArrayList<Nodo> convertido = FuncionesLisp.StringToNodo(list);
        
        ArrayList<Nodo> prueba = FuncionesLisp.pre(convertido,1);
        ArrayList<Nodo> prueba1 = FuncionesLisp.pre1(prueba);
        
        Evaluador.defun(list);
        
        
        
        ArrayList<Nodo> temperatura = new ArrayList<Nodo>();
        Nodo nombre = new Nodo("ftoc");
        temperatura.add(nombre);
        
        float num = 100;
        Nodo parametro = new Nodo(num);
        temperatura.add(parametro);
        
        
        
        ArrayList<Nodo> temperatura = new ArrayList<Nodo>();
        Nodo nombre = new Nodo("+");
        temperatura.add(nombre);
        
        float num = 100;
        Nodo parametro = new Nodo(num);
        temperatura.add(parametro);
        
        float num1 = 6;
        Nodo parametro1 = new Nodo(num1);
        temperatura.add(parametro1);
        
        System.out.println(temperatura.get(0).getDataS());
        
        
        System.out.println(Evaluador.evaluar1(temperatura, temperatura).getDataF());
        
        System.out.println("----------------------------------");
        System.out.println(prueba1.get(3).getArrayListNodo().get(2).getDataF());
        
        // (defun ftoc (temp)(/(- temp 32) 1.8))
        //ArrayList<Nodo> tok =  FuncionesLisp.convert(convertido);
        
        // int cont_lista = 0;
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
                	
        */
    }

    public static int isNumberC(Scanner scanner) {
        boolean correct = false;
        int a = 0;
        while(correct==false){
            try{
                a = Integer.parseInt(scanner.nextLine());
                correct=true;
            } catch(NumberFormatException e ){
                System.out.println("Ingrese un valor numerico valido");
            }
        }
        return a;
    }
}
