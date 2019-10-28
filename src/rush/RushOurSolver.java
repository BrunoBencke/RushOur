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
    public static int liberaCampo = 0;

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

        while (true) {
            System.out.println("ENTRANDO NO WHILE COM O VEICULO: " + state.get(linha, coluna));

            // baseado no estado parcial atual, gera novos estados
            if (state.get(linha, coluna) == 3) { //verifica se é carro 3, se for entra no outro if
                if (state.get(linha - 1, coluna) == 0 && state.get(linha - 1, coluna) != 1) { //verifica se tem espaço vazio para cima e se não é parede
                    // existe caminho não explorado para cima
                    System.out.println("O QUE TEM EM CIMA: " + state.get(linha - 1, coluna));
                    RushOurState cima = new RushOurState(state);
                    cima.setCima(linha, coluna, liberaCampo, 3);
                    //cima.setLinha(linha - 1);
                    if (solve(cima) == true) {
                        return true;
                    }
                } else {
                    System.out.println("PRA CIMA NÃO DÁ");
                }
            } else if (state.get(linha - 1, coluna) == 4) { //saida encontrada
                System.out.println("SAÍDA ENCONTRADA!");
                return true;
            }

            if (state.get(linha, coluna) == 3) { //verifica se é carro 3, se for entra no outro if
                if (state.get(linha + 1, coluna) == 0 && state.get(linha + 1, coluna) != 1) { //verifica se tem espaço vazio para baixo e se não é parede
                    // existe caminho não explorado para baixo
                    System.out.println("O QUE TEM EM BAIXO: " + state.get(linha + 1, coluna));
                    RushOurState baixo = new RushOurState(state);
                    baixo.setBaixo(linha, coluna, liberaCampo, 3);
                    //baixo.setLinha(linha + 1);
                    if (solve(baixo) == true) {
                        return true;
                    }
                } else {
                    System.out.println("PRA BAIXO NÃO DÁ");
                }
            } else if (state.get(linha + 1, coluna) == 4) { //saida encontrada
                System.out.println("SAÍDA ENCONTRADA!");
                return true;
            }

            if (state.get(linha, coluna) == 2) { //verifica se é carro 2, se for entra no outro if
                if (state.get(linha, coluna - 1) == 0 && state.get(linha, coluna - 1) != 1) { //verifica se tem espaço vazio para esquerda e se não é parede
                    // existe caminho não explorado para esquerda
                    System.out.println("O QUE TEM NA ESQUERDA: " + state.get(linha, coluna - 1));
                    RushOurState esquerda = new RushOurState(state);
                    esquerda.setEsquerda(linha, coluna, liberaCampo, 2);
                    //esquerda.setColuna(coluna - 1);
                    if (solve(esquerda) == true) {
                        return true;
                    }
                } else {
                    System.out.println("PRA ESQUERDA NÃO DÁ");
                }
            } else if (state.get(linha - 1, coluna) == 4) { //saida encontrada
                System.out.println("SAÍDA ENCONTRADA!");
                return true;
            }

            if (state.get(linha, coluna) == 2) { //verifica se é carro 2, se for entra no outro if
                if (state.get(linha, coluna + 1) == 0 && state.get(linha, coluna + 1) != 1) { //verifica se tem espaço vazio para direita e se não é parede
                    // existe caminho não explorado para direita
                    System.out.println("O QUE TEM NA DIREITA: " + state.get(linha, coluna + 1));
                    RushOurState direita = new RushOurState(state);
                    direita.setDireita(linha, coluna, liberaCampo, 2);
                    //direita.setColuna(coluna + 1);
                    if (solve(direita) == true) {
                        return true;
                    }
                } else {
                    System.out.println("PRA DIREITA NÃO DÁ");
                }
            } else if (state.get(linha + 1, coluna) == 4) { //saida encontrada
                System.out.println("SAÍDA ENCONTRADA!");
                return true;
            }
            return false; // tudo mais falhou, retorne falso
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RushOurState first = new RushOurState();
        solve(first);
        System.out.println("Contador: " + contador);
        System.out.println("Tempo: " + (System.currentTimeMillis() - start) / 1000.0 + " s");
    }
}
