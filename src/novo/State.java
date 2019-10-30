package novo;

/**
 *
 * @author Bruno Bencke
 */
public class State {
    
    private int[][] matriz = {{1, 1, 1, 1, 1, 1}, // labirinto zerado
                              {1, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 4, 1},
                              {1, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 1},
                              {1, 1, 1, 1, 1, 1}};
    
    private int linha = 1, coluna = 1; // posição inicial
    
    public State() {}

    public State(State s) {
        for (int r=0; r<6; r++) {
            for (int c=0; c<6; c++) {
                this.matriz[r][c] = s.matriz[r][c]; } } 
        this.linha = s.linha;
        this.coluna = s.coluna; }
    
    public int get(int r, int c) { return this.matriz[r][c]; }
    public int getlinha()          { return this.linha; }
    public int getcoluna()          { return this.coluna; }

    public void set(int r, int c, int v) { this.matriz[r][c] = v; }
    public void setlinha(int r)            { this.linha = r; }
    public void setcoluna(int c)            { this.coluna = c; }
    
    public void adicionarVeiculo(Veiculo v){
        //verifica se a posicao que quer colocar o veiculo é vazia 0
        if (matriz[v.getLinha()][v.getColuna()] == 0) {
            matriz[v.getLinha()][v.getColuna()] = v.getNome();
        }
    }
    
    public String toString() {
        String s = "";
        for (int r=0; r<6; r++) {
            for (int c=0; c<6; c++) {
                s += this.matriz[r][c];
            }
            s += '\n';
        }
        return s;
    }      
}
