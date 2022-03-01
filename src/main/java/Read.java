import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    public String readFile(){
        int contador=0;
        int tamaño=0;
        String string ="";
        BufferedReader br = null;

        try {
            String sCurrentLine;
            File file = new File("datosLisp.txt");
            br = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            while ((sCurrentLine = br.readLine()) != null) {
                tamaño++;
            }
            br = new BufferedReader(new FileReader(file));

            while ((sCurrentLine = br.readLine()) != null) {
                string = string.concat(sCurrentLine);
            }

            return string;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<String> lista(String params){
        // Code
        ArrayList<String> bebe = new ArrayList<String>();
        return bebe;
    }
}
