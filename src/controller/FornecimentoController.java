package src.controller;

import src.model.domain.Fornecedor;
import src.model.domain.Fruta;

public final class FornecimentoController {

    public static void historicoDeFornecimento(Fornecedor fornecedor, Fruta fruta){
        String mensagem = fornecedor.getNome() + " forneceu " + fruta.getQuantidade() + " unidades de " + fruta.getNome();

        fornecedor.getFornecimento().getHistorico().add(mensagem);
    }



}