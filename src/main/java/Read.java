import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    public ArrayList<String> readFile(ArrayList<String> expression){
        try {
            File myObj = new File("lispExpression.txt");
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
        return expression;
    }

    public ArrayList<Character> getCharactersList(ArrayList<String> expression){
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
}
