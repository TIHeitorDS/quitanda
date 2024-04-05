package fornecimento;

import java.util.List;
import entidades.Fornecedor;

public class Fornecimento extends Fornecedor {
    public List<String> historicoDeFornecimento;

    public Fornecimento(String nome, String telefone, String endereco, String cnpj, List<String> historicoDeFornecimento) {
        super(nome, telefone, endereco, cnpj);
        this.historicoDeFornecimento = historicoDeFornecimento;
    }

    public List<String> getHistoricoDeFornecimento() {
        return historicoDeFornecimento;
    }

    public void setHistoricoDeFornecimento(List<String> historicoDeFornecimento) {
        this.historicoDeFornecimento = historicoDeFornecimento;
    }

    public Fornecedor criarFornecimento(String nome, String telefone, String endereco, String cnpj, List<String> historicoDeFornecimento) {
        return new Fornecimento(nome, telefone, endereco, cnpj, historicoDeFornecimento);
    }

    public void editarFornecimento(Fornecimento fornecimento, String nome, String telefone, String endereco, String cnpj, List<String> historicoDeFornecimento) {
        fornecimento.setNome(nome);
        fornecimento.setTelefone(telefone);
        fornecimento.setEndereco(endereco);
        fornecimento.setCnpj(cnpj);
        fornecimento.setHistoricoDeFornecimento(historicoDeFornecimento);
    }
}