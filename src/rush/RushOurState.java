package rush;

public class RushOurState {

    /*
    Temos que mover o carro 3 apenas para cima e para baixo (norte e sul);
    Temos que mover o carro 2 apenas para o lado esquerdo e direito (leste e oeste);
    Apenas movimentar, se (if (espaço == 0)), se for vazio, ai ele anda, se nao, procura outro lugar (retrocede);
    E se encontrar a saída if(espaço == 4) para o programa;
     */
    private int[][] m = {
        {1, 1, 1, 1, 1, 1, 1, 1}, // labirinto zerado
        {1, 3, 3, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 2, 2, 2, 2, 1},
        {1, 4, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1}};

    private int row = 2, col = 2; // posição inicial

    public RushOurState() {
    }

    public RushOurState(RushOurState s) {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 8; c++) {
                this.m[r][c] = s.m[r][c];
            }
        }
        this.row = s.row;
        this.col = s.col;
    }

    public int get(int r, int c) {
        return this.m[r][c];
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void set(int r, int c, int v1, int v2) {
        this.m[r][c] = v1;
        this.m[r + 1][c + 1] = v2;
    }

    public void setRow(int r) {
        this.row = r;
    }

    public void setCol(int c) {
        this.col = c;
    }

    public String toString() {
        String s = "";
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 8; c++) {
                s += this.m[r][c];
            }
            s += '\n';
        }
        return s;
    }
}
