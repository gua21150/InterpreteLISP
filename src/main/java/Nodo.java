import java.util.ArrayList;

public class Nodo {
    private float dataF;
    private String dataS;
    private ArrayList<Nodo> lista;
    private int tipo;
    
    public Nodo(float v){
        dataF=v;
        tipo=1;
    }
     
    public Nodo(String v){
        dataS=v;
        tipo=2;
    }
    
    public Nodo(ArrayList<Nodo> v){
        lista=v;
        tipo=3;
    }
    
    public int getTipo() {
    	return tipo;
    }
    
    public float getDataF() {
    	return dataF;
    }
    
    public String getDataS() {
    	return dataS;
    }
    public ArrayList<Nodo> getArrayListNodo() {
    	return lista;
    }
    

}
