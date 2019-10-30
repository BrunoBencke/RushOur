package novo;

/**
 *
 * @author Bruno Bencke
 */
public class Veiculo {
    
    private int nome;
    private int linha;
    private int coluna;
    private String orientacao;
    
    public Veiculo(){
        
    }
    
    public Veiculo(int nome, int linha, int coluna, String orientacao){
        this.nome = nome;
        this.linha = linha;
        this.coluna = coluna;
        this.orientacao = orientacao;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getOrientacao() {
        return orientacao;
    }

    public void setOrientacao(String orientacao) {
        this.orientacao = orientacao;
    }

    
    
}
