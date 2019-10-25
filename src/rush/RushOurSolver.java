package rush;

public class RushOurSolver {

    /*
    Temos que mover o carro 3 apenas para cima e para baixo (norte e sul);
    Temos que mover o carro 2 apenas para o lado esquerdo e direito (leste e oeste);
    Apenas movimentar, se (if (espaço == 0)), se for vazio, ai ele anda, se nao, procura outro lugar (retrocede);
    E se encontrar a saída if(espaço == 4) para o programa;
     */
    
    // contador de estados gerados
    public static int count = 0;

    public static boolean solve(RushOurState state) {
        count++;
        System.out.println("LEGENDA");
        System.out.println("4 = Saída");
        System.out.println("3 = Veiculo");
        System.out.println("2 = Veiculo");
        System.out.println("1 = Parede");
        System.out.println("0 = Vazio");
        System.out.println("");
        System.out.println(state);

        // obtém posição atual
        int r = state.getRow();
        int c = state.getCol();

        if (state.get(r, c) == 4) { // saída encontrada
            System.out.println("EXIT FOUND!");
            return true;
        }
        // baseado no estado parcial atual, gera novos estados
        if (state.get(r - 1, c) == 0 || state.get(r - 1, c) == 4) {
            // existe caminho não explorado ao norte
            RushOurState n = new RushOurState(state);
            n.set(r, c, 3, 3);
            n.setRow(r - 1);
            if (solve(n) == true) {
                return true;
            }
        }

        if (state.get(r + 1, c) == 0 || state.get(r + 1, c) == 4) {
            // existe caminho não explorado ao sul 
            RushOurState s = new RushOurState(state);
            s.set(r, c, 3, 3);
            s.setRow(r + 1);
            if (solve(s) == true) {
                return true;
            }
        }

        if (state.get(r, c - 1) == 0 || state.get(r, c - 1) == 4) {
            // existe caminho não explorado a oeste
            RushOurState o = new RushOurState(state);
            o.set(r, c, 3, 3);
            o.setCol(c - 1);
            if (solve(o) == true) {
                return true;
            }
        }

        if (state.get(r, c + 1) == 0 || state.get(r, c + 1) == 4) {
            // existe caminho não explorado a leste
            RushOurState l = new RushOurState(state);
            l.set(r, c, 3, 3);
            l.setCol(c + 1);
            if (solve(l) == true) {
                return true;
            }
        }
        return false; // tudo mais falhou, retorne falso
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RushOurState first = new RushOurState();
        solve(first);
        System.out.println("count: " + count);
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000.0 + " s");
    }
}
