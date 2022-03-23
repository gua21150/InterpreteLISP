import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EvaluadorTest {
    @Test
    void setQ() {
        Nodo a = new Nodo("a");
        Nodo b = new Nodo(45);
        // Evaluador.setQ(a,b);
        // assertEquals(b.getDataF(), Evaluador.getQ(a).getDataF());
    }

    @Test 
    void isQuoteTest(){
        Nodo a = new Nodo("456 789");
        assertEquals("456 789", Evaluador.isQuote(a));
        Nodo b = new Nodo(78);
        assertEquals(Float.parseFloat("78"), Evaluador.isQuote(b));
        
        ArrayList<Nodo> ay = new ArrayList<>();
        ay.add(a); ay.add(b);
        Nodo c = new Nodo(ay);
        assertEquals(("456 789 " + Float.parseFloat("78")+" "), Evaluador.isQuote(c)); 
    }
}