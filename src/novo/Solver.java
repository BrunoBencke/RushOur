package novo;
import java.util.ArrayList;

/**
 *
 * @author Bruno Bencke
 */
public class Solver {
    
    // contador de estados gerados
    public static int count = 0;
    public static ArrayList<Veiculo> veiculos = new ArrayList();
    
    public static boolean solve(State state)
    {
        count++;
        System.out.println(state);
        
        // obtém posição atual
        int r = state.getlinha();
        int c = state.getcoluna();
    
        if (state.get(r, c) == 4) { // saída encontrada
            System.out.println("Econtrou Solução!");
            return true;
        }
        
        // baseado no estado parcial atual, gera novos estados
        if (state.get(r - 1, c) == 5) {
            // existe caminho não explorado ao norte
            State n = new State(state); 
            n.set(r, c, 5); 
            n.setlinha(r - 1);
            if (solve(n) == true) { 
                return true; 
            }
        }
        if (state.get(r + 1, c) == 5) {
            // existe caminho não explorado ao sul 
            State s = new State(state); 
            s.set(r, c, 5); 
            s.setlinha(r + 1);
            if (solve(s) == true) { 
                return true; 
            }
        }
        if (state.get(r, c - 1) == 2) {
            // existe caminho não explorado a oeste
            State o = new State(state); 
            o.set(r, c, 2); 
            o.setcoluna(c - 1);
            if (solve(o) == true) { 
                return true; 
            }
        }
        if (state.get(r, c + 1) == 2) {
            // existe caminho não explorado a leste
            State l = new State(state); 
            l.set(r, c, 2); 
            l.setcoluna(c + 1);
            if (solve(l) == true) { 
                return true; 
            }
        }
        
                // baseado no estado parcial atual, gera novos estados
        if (state.get(r - 1, c) == 3) {
            // existe caminho não explorado ao norte
            State n = new State(state); 
            n.set(r, c, 3); 
            n.setlinha(r - 1);
            if (solve(n) == true) { 
                return true; 
            }
        }
        if (state.get(r + 1, c) == 3) {
            // existe caminho não explorado ao sul 
            State s = new State(state); 
            s.set(r, c, 3); 
            s.setlinha(r + 1);
            if (solve(s) == true) { 
                return true; 
            }
        }
        
        System.out.println("retornou falso");
        return false; // tudo mais falhou, retorne falso
    }
    
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        State first = new State();
//        veiculos.add(new Veiculo(2,2,1,"vertical"));
//        veiculos.add(new Veiculo(5,1,2,"horizontal"));
//        veiculos.add(new Veiculo(3,2,3,"vertical"));
        first.adicionarVeiculos(veiculos);
        solve(first);
        System.out.println("count: " + count);
        System.out.println("time : " + (System.currentTimeMillis()-start)/1000.0 + " s");
    }
}
