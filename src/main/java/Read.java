import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Realiza la preparación del texto dentro de un archivo de texto 
 * @author Mariel Guamuche
 * @version 2.0 
 */
public class Read {
    private Read() {
    }

    /**
     * Realiza la lectura del archivo validando la entrada del archivo de texto 
     * @param nombre: String del nombre del archivo
     * @param expression: ArrayList<String> donde se desea colocar la expresi�n le�da.
     * @return ArrayList<String> con conversi�n de expresi�n
     */
    public static ArrayList<String> readFile(String nombre, ArrayList<String> expression){
        try {
            File myObj = new File(nombre);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                expression.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se ha encontrado");            
        }
        expression=tokens(expression);
        return expression;
    }

    /**
     * Convierte la lista en una lista de caracteres 
     * @param expression: ArrayList<String> arreglo que se desea que sea convertido a uno de caracter por caracter
     * @return Expresion convertida
     */
    private static ArrayList<Character> getCharactersList(ArrayList<String> expression){
        ArrayList<Character> charactersExpression = new ArrayList<>(); // lista temporal
        try {
            for (String str: expression) {
                for (int i = 0; i < str.length(); i++) {
                    charactersExpression.add(str.charAt(i)); // se agregan los caracteres
                }
            }
        } catch(Exception e) {
            System.out.println("new error occurred" +e.getMessage());
        }        
        return charactersExpression;
    }

    /**
     * Valida que exista la misma cantidad de parentesis de apertura como parentesis para cerrar
     * @param expression: Expresion caracter que es validada
     * @return: true -> misma cantidad de parentesis, false -> no tiene la misma cantidad de parentesis
     */
    private static boolean parentesisCorrectos(ArrayList<Character> expression) {
        int parApertura = 0;
        int parCerrar = 0;
        for (Character character : expression) {
            if(character.equals('('))
                parApertura++;
            else
                if(character.equals(')'))
                    parCerrar++;
        }
        return parApertura==parCerrar;
    }

    /**
     * Convierte la expresion ingresada en un arreglo de expresiones
     * @param expression: Expresion que sera convertida
     * @return: Expresion separada por strings 
     */
    private static ArrayList<String> tokens(ArrayList<String> expression) {        
        String temp = "";
        ArrayList<Character> characters = new ArrayList<>(); // lista temporal que contiene los caracteres                                                            
        characters.addAll(getCharactersList(expression));   // se convierte la lista a una lista de caracteres
        expression.clear();
        String str = ".,'-";
        if(parentesisCorrectos(characters)==true) {
            for (Character chars : characters) {
                if (chars == '('){
                    if(!temp.isEmpty()){
                        expression.add(temp); temp="";
                    }                        
                    expression.add(chars+"");
                } else {
                    if(chars==')') {
                        if(!temp.equals("")) {
                            expression.add(temp);
                            temp="";
                        }
                        expression.add(chars+"");
                    }
                    else { 
                        if (Character.isLetterOrDigit(chars) || chars.equals('.')) {
                            temp += chars+"";
                        } else {                            
                            if(!Character.isLetterOrDigit(chars)&&!Character.isWhitespace(chars)){
                                if(!temp.isEmpty()){
                                    expression.add(temp); temp="";
                                }                                    
                                expression.add(chars+"");
                            } else {
                                if (!temp.equals("") && chars.equals(' ')) {
                                    expression.add(temp);
                                    temp = "";
                                }
                            }                                        
                        }
                    }
                }
            }
        } else 
            expression.add("No operable");
        return expression;
    }        
}