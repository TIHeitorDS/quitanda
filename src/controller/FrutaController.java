package controller;

import model.dao.FrutaDAO;
import model.domain.Fruta;

public final class FrutaController {
    public static void editar(Fruta fruta, double novoPreco, int novaQuantidade) {
        fruta.setPreco(novoPreco);
        fruta.setQuantidade(novaQuantidade);

        FrutaDAO.editarFruta(fruta);
    }
}
