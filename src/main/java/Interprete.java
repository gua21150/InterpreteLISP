import java.util.ArrayList;

public class Interprete {

    public static void main(String[] args) {
        Read file = new Read();                              // creación objeto de lectura
        ArrayList<String> list = new ArrayList<>();          // lista temporal que recibe la expresión del archivo de texto
        ArrayList<Character> characters = new ArrayList<>(); // lista temporal que contiene los caracteres
        file.readFile(list);                                 // lectura del archivo
        characters.addAll(file.getCharactersList(list));     // se convierte la lista a una lista de caracteres
        for (Character chars: characters) {
            System.out.println(chars);                       // solo para ver la lectura realizada
        }
    }
}
