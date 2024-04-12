package fornecimento;

import java.util.ArrayList;

import entidades.Fornecedor;

public class Fornecimento {
    private Fruta fruta;
    private ArrayList<String> historico;

    public Fornecimento(Fruta fruta) {
        this.fruta = fruta;
        historico = new ArrayList<>();
    }

    public Fornecimento() {
        historico = new ArrayList<>();
    }

    public void adicionarFornecimento(int quantidade) {
        int quntidadeAtual = fruta.getQuantidade();

        fruta.setQuantidade(quntidadeAtual + quantidade);
    }

    public void removerFornecimento(int quantidadeComprada) {
        int quantidadeAtual = fruta.getQuantidade();

        fruta.setQuantidade(quantidadeAtual - quantidadeComprada);
    }

    public void historicoDeFornecimento(String nomeFornecedor) {
        String mensagem = nomeFornecedor +  " forneceu " + fruta.getQuantidade() + " quantidade(s) de " + fruta.getNome();

        historico.add(mensagem);
    }

    public void historicoDeFornecimento(Fornecedor fornecedor) {
        String mensagem = fornecedor.getNome() +  " forneceu " + fruta.getQuantidade() + " quantidade(s) de " + fruta.getNome();

        historico.add(mensagem);
    }


    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public void setFruta(Fruta fruta, Fornecedor fornecedor) {
        this.fruta = fruta;
        this.historicoDeFornecimento(fornecedor);
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }
}