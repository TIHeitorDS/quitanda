package fornecimento;

import java.util.ArrayList;

import entidades.Fornecedor;

public class Fornecimento {
    private Fruta fruta;
    private ArrayList<String> historico;

    public Fornecimento(Fruta fruta) {
        this.fruta = fruta;
        this.historico = new ArrayList<>();
    }

    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }

    public void historicoDeFornecimento(Fornecedor fornecedor) {
        String mensagem = fornecedor.getNome() +  " forneceu " + fruta.getQuantidadeFornecida() + " quantidade(s) de " + fruta.getNome();
        historico.add(mensagem);
    }
    
}