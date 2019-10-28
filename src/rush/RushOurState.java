package rush;

public class RushOurState {

    /*
    Temos que mover o carro 3 apenas para cima e para baixo (norte e sul);
    Temos que mover o carro 2 apenas para o lado esquerdo e direito (leste e oeste);
    Apenas movimentar, se (if (espaço == 0)), se for vazio, ai ele anda, se nao, procura outro lugar (retrocede);
    E se encontrar a saída if(espaço == 4) para o programa;
     */
    private int[][] matriz = {
        {1, 1, 1, 1, 1, 1, 1, 1}, // labirinto zerado
        {1, 3, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 2, 0, 0, 0, 4},
        {1, 2, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 3, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1}};

    private int linha = 4, coluna = 1; // posição inicial

    public RushOurState() {
    }

    public RushOurState(RushOurState state) {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                this.matriz[linha][coluna] = state.matriz[linha][coluna];
            }
        }
        this.linha = state.linha;
        this.coluna = state.coluna;
    }

    public int get(int linha, int coluna) {
        return this.matriz[linha][coluna];
    }

    public int getLinha() {
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public void setCima(int linha, int coluna, int v1, int v2) {
        this.matriz[linha][coluna] = v1;
        this.matriz[linha -1][coluna] = v2;
    }

    public void setBaixo(int linha, int coluna, int v1, int v2) {
        this.matriz[linha][coluna] = v1;
        this.matriz[linha + 1][coluna] = v2;
    }

    public void setEsquerda(int linha, int coluna, int v1, int v2) {
        this.matriz[linha][coluna] = v1;
        this.matriz[linha][coluna - 1] = v2;
    }

    public void setDireita(int linha, int coluna, int v1, int v2) {
        this.matriz[linha][coluna] = v1;
        this.matriz[linha][coluna + 1] = v2;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String toString() {
        String s = "";
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                s += this.matriz[linha][coluna];
            }
            s += '\n';
        }
        return s;
    }
}
