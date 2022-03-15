import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    private Read() {
    }

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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        expression=tokens(expression);
        return expression;
    }

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

    private static ArrayList<String> tokens(ArrayList<String> expression) {        
        String temp = "";
        ArrayList<Character> characters = new ArrayList<>(); // lista temporal que contiene los caracteres                                                            
        characters.addAll(getCharactersList(expression));   // se convierte la lista a una lista de caracteres
        expression.clear();

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
                        if (Character.isLetterOrDigit(chars)) {
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
}
