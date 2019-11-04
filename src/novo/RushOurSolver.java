package novo;

import novo.RushOurState;

public class RushOurSolver {

    /*
     Temos que mover o carro 3 apenas para cima e para baixo (norte e sul);
     Temos que mover o carro 2 apenas para o lado esquerdo e direito (leste e oeste);
     Apenas movimentar, se (if (espaço == 0)), se for vazio, ai ele anda, se nao, procura outro lugar (retrocede);
     E se encontrar a saída if(espaço == 4) para o programa;
     */
    // contador de estados gerados
    public static int contador = 0;
    public static int contadorZERO = 0;
    public static int contMovimentoVeiculo2 = 0;
    public static int contMovimentoVeiculo3 = 0;
    public static int contMovimentoVeiculo5 = 0;
    public static int liberaCampo = 0;

    public static boolean solve(RushOurState state) {
        contador++;
        System.out.println("LEGENDA");
        System.out.println("5 = Veiculo Esquerda/Direita");
        System.out.println("4 = Saída");
        System.out.println("3 = Veiculo Cima,Baixo");
        System.out.println("2 = Veiculo Principal");
        System.out.println("1 = Parede");
        System.out.println("0 = Lugar Vazio");
        System.out.println("");
        System.out.println(state);

        int linha = sortearLinha(); // sorteia posição atual
        int coluna = sortearColuna(); // sorteia posição atual
        while (state.get(linha, coluna) == 0) { // sorteia novamente se sortear a posição com valor 0 - VAZIO
            contadorZERO++;
            linha = sortearLinha();
            coluna = sortearColuna();
        }
        System.out.println("ENTRANDO NO WHILE COM O VEICULO: " + state.get(linha, coluna));
        // baseado no estado parcial atual, gera novos estados
        if (state.get(linha, coluna) == 2) { //verifica se é carro 2, se for entra no outro if
            if (state.get(linha, coluna + 1) == 0) { //verifica se tem espaço vazio para direita e se não é parede
                // existe caminho não explorado para direita
                System.out.println("ANDANDO PARA DIREITA: " + state.get(linha, coluna + 1));
                RushOurState direita = new RushOurState(state);
                direita.setDireita(linha, coluna, liberaCampo, 2);
                direita.setColuna(coluna + 1);
                contMovimentoVeiculo2++;
                System.out.println("NÚMERO DE MOVIMENTOS DO VEÍCULO 2: " + contMovimentoVeiculo2);
//                if (contMovimentoVeiculo2 == 5) {
//                    contMovimentoVeiculo2 = 0;
//                    System.out.println("CHEGOU A 5 MOVIMENTOS? ENTÃO ZERA?" + contMovimentoVeiculo2);
//                    return false;
//                }
                if (solve(direita) == true) {
                    return true;
                }
            } else if (state.get(linha, coluna + 1) == 4) { //saida encontrada
                System.out.println("O QUE TEM NA DIREITA? " + state.get(linha, coluna + 1));
                System.out.println("=====================");
                System.out.println("==SAÍDA ENCONTRADA!==");
                System.out.println("=====================");
                return true;
            } else {
                System.out.println("PRA DIREITA NÃO DÁ");
            }
        }

        if (state.get(linha, coluna) == 2) { //verifica se é carro 2, se for entra no outro if
            if (state.get(linha, coluna - 1) == 0) { //verifica se tem espaço vazio para esquerda e se não é parede
                // existe caminho não explorado para esquerda
                System.out.println("ANDANDO PARA ESQUERDA: " + state.get(linha, coluna - 1));
                RushOurState esquerda = new RushOurState(state);
                esquerda.setEsquerda(linha, coluna, liberaCampo, 2);
                esquerda.setColuna(coluna - 1);
                contMovimentoVeiculo2++;
                System.out.println("NÚMERO DE MOVIMENTOS DO VEÍCULO 2: " + contMovimentoVeiculo2);
//                if (contMovimentoVeiculo2 == 5) {
//                    contMovimentoVeiculo2 = 0;
//                    System.out.println("CHEGOU A 5 MOVIMENTOS? ENTÃO ZERA?" + contMovimentoVeiculo2);
//                    return false;
//                }
                if (solve(esquerda) == true) {
                    return true;
                }
            } else if (state.get(linha, coluna - 1) == 4) { //saida encontrada
                System.out.println("O QUE TEM NA ESQUERDA? " + state.get(linha, coluna - 1));
                System.out.println("=====================");
                System.out.println("==SAÍDA ENCONTRADA!==");
                System.out.println("=====================");
                return true;
            } else {
                System.out.println("PRA ESQUERDA NÃO DÁ");
            }
        }

        if (state.get(linha, coluna) == 3) { //verifica se é carro 3, se for entra no outro if
            if (state.get(linha - 1, coluna) == 0) { //verifica se tem espaço vazio para cima e se não é parede
                // existe caminho não explorado para cima
                System.out.println("ANDANDO PARA CIMA: " + state.get(linha - 1, coluna));
                RushOurState cima = new RushOurState(state);
                cima.setCima(linha, coluna, liberaCampo, 3);
                cima.setLinha(linha - 1);
                if (solve(cima) == true) {
                    return true;
                }
                contMovimentoVeiculo3++;
                System.out.println("NÚMERO DE MOVIMENTOS DO VEÍCULO 3: " + contMovimentoVeiculo3);
//                if (contMovimentoVeiculo3 == 5) {
//                    contMovimentoVeiculo3 = 0;
//                    System.out.println("CHEGOU A 5 MOVIMENTOS? ENTÃO ZERA?" + contMovimentoVeiculo3);
//                    return false;
//                }
            } else if (state.get(linha - 1, coluna) == 4) { //saida encontrada
                System.out.println("O QUE TEM EM CIMA? " + state.get(linha - 1, coluna));
                System.out.println("=====================");
                System.out.println("==SAÍDA ENCONTRADA!==");
                System.out.println("=====================");
                return true;
            } else {
                System.out.println("PRA CIMA NÃO DÁ");
            }
        }

        if (state.get(linha, coluna) == 3) { //verifica se é carro 3, se for entra no outro if
            if (state.get(linha + 1, coluna) == 0) { //verifica se tem espaço vazio para baixo e se não é parede
                // existe caminho não explorado para baixo
                System.out.println("ANDANDO PARA BAIXO: " + state.get(linha + 1, coluna));
                RushOurState baixo = new RushOurState(state);
                baixo.setBaixo(linha, coluna, liberaCampo, 3);
                baixo.setLinha(linha + 1);
                contMovimentoVeiculo3++;
                System.out.println("NÚMERO DE MOVIMENTOS DO VEÍCULO 3: " + contMovimentoVeiculo3);
//                if (contMovimentoVeiculo3 == 5) {
//                    contMovimentoVeiculo3 = 0;
//                    System.out.println("CHEGOU A 5 MOVIMENTOS? ENTÃO ZERA?" + contMovimentoVeiculo3);
//                    return false;
//                }
                if (solve(baixo) == true) {
                    return true;
                }
            } else if (state.get(linha + 1, coluna) == 4) { //saida encontrada
                System.out.println("O QUE TEM EM BAIXO? " + state.get(linha + 1, coluna));
                System.out.println("=====================");
                System.out.println("==SAÍDA ENCONTRADA!==");
                System.out.println("=====================");
                return true;
            } else {
                System.out.println("PRA BAIXO NÃO DÁ");
            }
        }
        if (state.get(linha, coluna) == 5) { //verifica se é carro 5, se for entra no outro if
            if (state.get(linha, coluna + 1) == 0) { //verifica se tem espaço vazio para direita e se não é parede
                // existe caminho não explorado para direita
                System.out.println("ANDANDO PARA DIREITA: " + state.get(linha, coluna + 1));
                RushOurState direita = new RushOurState(state);
                direita.setDireita(linha, coluna, liberaCampo, 5);
                direita.setColuna(coluna + 1);
                contMovimentoVeiculo5++;
                System.out.println("NÚMERO DE MOVIMENTOS DO VEÍCULO 5: " + contMovimentoVeiculo5);
//                if (contMovimentoVeiculo5 == 5) {
//                    contMovimentoVeiculo5 = 0;
//                    System.out.println("CHEGOU A 5 MOVIMENTOS? ENTÃO ZERA?" + contMovimentoVeiculo5);
//                    return false;
//                }
                if (solve(direita) == true) {
                    return true;
                }
            } else if (state.get(linha, coluna + 1) == 4) { //saida encontrada
                System.out.println("O QUE TEM NA DIREITA? " + state.get(linha, coluna + 1));
                System.out.println("=====================");
                System.out.println("==SAÍDA ENCONTRADA!==");
                System.out.println("=====================");
                return true;
            } else {
                System.out.println("PRA DIREITA NÃO DÁ");
            }
        }

        if (state.get(linha, coluna) == 5) { //verifica se é carro 5, se for entra no outro if
            if (state.get(linha, coluna - 1) == 0) { //verifica se tem espaço vazio para esquerda e se não é parede
                // existe caminho não explorado para esquerda
                System.out.println("ANDANDO PARA ESQUERDA: " + state.get(linha, coluna - 1));
                RushOurState esquerda = new RushOurState(state);
                esquerda.setEsquerda(linha, coluna, liberaCampo, 5);
                esquerda.setColuna(coluna - 1);
                contMovimentoVeiculo5++;
                System.out.println("NÚMERO DE MOVIMENTOS DO VEÍCULO 5: " + contMovimentoVeiculo5);
//                if (contMovimentoVeiculo5 == 5) {
//                    contMovimentoVeiculo5 = 0;
//                    System.out.println("CHEGOU A 5 MOVIMENTOS? ENTÃO ZERA?" + contMovimentoVeiculo5);
//                    return false;
//                }
                if (solve(esquerda) == true) {
                    return true;
                }
            } else if (state.get(linha, coluna - 1) == 4) { //saida encontrada
                System.out.println("O QUE TEM NA ESQUERDA? " + state.get(linha, coluna - 1));
                System.out.println("=====================");
                System.out.println("==SAÍDA ENCONTRADA!==");
                System.out.println("=====================");
                return true;
            } else {
                System.out.println("PRA ESQUERDA NÃO DÁ");
            }
        }
        return false; // tudo mais falhou, retorne falso
    }

    public static int sortearLinha() {
        int linha = (int) (Math.random() * 3) + 1;
        //System.out.println("linha random: " + linha);
        return linha;
    }

    public static int sortearColuna() {
        int coluna = (int) (Math.random() * 3) + 1;
        //System.out.println("coluna random: " + coluna);
        return coluna;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        RushOurState first = new RushOurState();
        solve(first);
        System.out.println("CONTADOR: " + contador);
        System.out.println("TEMPO: " + (System.currentTimeMillis() - start) / 1000.0 + " s");
        System.out.println("TOTAL DE MOVIMENTOS VEICULO 2: " + contMovimentoVeiculo2);
        System.out.println("TOTAL DE MOVIMENTOS VEICULO 3: " + contMovimentoVeiculo3);
        System.out.println("TOTAL DE MOVIMENTOS VEICULO 5: " + contMovimentoVeiculo5);
        System.out.println("TOTAL DE VEZES QUE SORTEOU A POSIÇÃO DO VALOR 0: " + contadorZERO);
    }
}
