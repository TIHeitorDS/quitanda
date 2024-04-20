package controller;

import model.domain.Fornecedor;

public final class FornecedorController {
    public static void editar(Fornecedor fornecedor, String nome, String telefone, String cnpj, String endereco) {
        fornecedor.setTelefone(telefone);
        fornecedor.setEndereco(endereco);
        fornecedor.setNome(nome);
        fornecedor.setCnpj(cnpj);
    }
}
