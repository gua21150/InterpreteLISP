import java.util.ArrayList;

public class Nodo {
    protected float dataF; 
    protected String dataS; 
    protected ArrayList<Nodo> lista;
    protected int tipo;
    
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
}
