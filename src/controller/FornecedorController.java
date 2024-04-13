package src.controller;

import src.model.domain.Fornecedor;
import src.model.domain.Fruta;

public final class FornecedorController {

    public static void fornecerFruta(String nome, double preco, int quantidade, Fornecedor fornecedor) {
        Fruta fruta = new Fruta(nome, preco, quantidade);

        fornecedor.getFornecimento().setFruta(fruta);
        FornecimentoController.historicoDeFornecimento(fornecedor, fruta);
        FrutaController.adicionarFruta(fruta);
    }


}
