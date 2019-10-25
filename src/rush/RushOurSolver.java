package rush;

public class RushOurSolver {

    /*
    Temos que mover o carro 3 apenas para cima e para baixo (norte e sul);
    Temos que mover o carro 2 apenas para o lado esquerdo e direito (leste e oeste);
    Apenas movimentar, se (if (espaço == 0)), se for vazio, ai ele anda, se nao, procura outro lugar (retrocede);
    E se encontrar a saída if(espaço == 4) para o programa;
     */
    // contador de estados gerados
    public static int contador = 0;

    public static boolean solve(RushOurState state) {
        contador++;
        System.out.println("LEGENDA");
        System.out.println("4 = Saída");
        System.out.println("3 = Veiculo");
        System.out.println("2 = Veiculo");
        System.out.println("1 = Parede");
        System.out.println("0 = Vazio");
        System.out.println("");
        System.out.println(state);

        // obtém posição atual
        int linha = state.getLinha();
        int coluna = state.getColuna();

        System.out.println("TESTE " + state.get(linha, coluna));

        if (state.get(linha, coluna) == 4) { // saída encontrada
            System.out.println("SAÍDA ENCONTRADA!");
            return true;
        }

        // baseado no estado parcial atual, gera novos estados
        if (state.get(linha, coluna) == 3) { //verifica se é carro 3, se for entra no outro if
            if (state.get(linha - 1, coluna) == 0 || state.get(linha - 1, coluna) == 4 && state.get(linha - 1, coluna) != 1) { //verifica se tem espaço vazio ao norte, se é saída e se não é parede
                // existe caminho não explorado ao norte
                RushOurState norte = new RushOurState(state);
                norte.set(linha, coluna, 3, 3);
                norte.setLinha(linha - 1);
                if (solve(norte) == true) {
                    return true;
                }
            }
        }

        if (state.get(linha, coluna) == 3) { //verifica se é carro 3, se for entra no outro if
            if (state.get(linha + 1, coluna) == 0 || state.get(linha + 1, coluna) == 4 && state.get(linha - 1, coluna) != 1) { //verifica se tem espaço vazio ao sul, se é saída e se não é parede
                // existe caminho não explorado ao sul 
                RushOurState sul = new RushOurState(state);
                sul.set(linha, coluna, 3, 3);
                sul.setLinha(linha + 1);
                if (solve(sul) == true) {
                    return true;
                }
            }
        }
        if (state.get(linha, coluna) == 2) { //verifica se é carro 2, se for entra no outro if
            if (state.get(linha, coluna - 1) == 0 || state.get(linha, coluna - 1) == 4 && state.get(linha - 1, coluna) != 1) { //verifica se tem espaço vazio ao oeste, se é saída e se não é parede
                // existe caminho não explorado a oeste
                RushOurState oeste = new RushOurState(state);
                oeste.set(linha, coluna, 3, 3);
                oeste.setColuna(coluna - 1);
                if (solve(oeste) == true) {
                    return true;
                }
            }
        }

        if (state.get(linha, coluna) == 2) { //verifica se é carro 2, se for entra no outro if
            if (state.get(linha, coluna + 1) == 0 || state.get(linha, coluna + 1) == 4 && state.get(linha - 1, coluna) != 1) { //verifica se tem espaço vazio ao oeste, se é saída e se não é parede
                // existe caminho não explorado a leste
                RushOurState leste = new RushOurState(state);
                leste.set(linha, coluna, 3, 3);
                leste.setColuna(coluna + 1);
                if (solve(leste) == true) {
                    return true;
                }
            }
        }
        return false; // tudo mais falhou, retorne falso
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RushOurState first = new RushOurState();
        solve(first);
        System.out.println("Contador: " + contador);
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) / 1000.0 + " s");
    }
}
