package controller;

import model.dao.FrutaDAO;
import model.domain.Fornecedor;
import model.domain.Fruta;

import java.util.ArrayList;

public final class FornecimentoController {
    public static void fornecerFruta(String nome, double preco, int quantidade, Fornecedor fornecedor) {
        Fruta fruta = FrutaDAO.buscarFruta(nome);

        if (fruta != null) {
            int quantidadeAtual = fruta.getQuantidade();

            fruta.setQuantidade(quantidadeAtual + quantidade);

            FrutaDAO.editarFruta(fruta);
        } else {
            fruta = new Fruta(nome, preco, quantidade);
            FrutaDAO.adicionarFruta(fruta, fornecedor.getId());
        }
    }
}