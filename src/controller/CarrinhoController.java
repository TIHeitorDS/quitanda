package controller;

import model.dao.FrutaDAO;
import model.domain.CarrinhoDeCompras;
import model.domain.Cliente;
import model.domain.ItemDeCompra;

public final class CarrinhoController {
    public static void adicionarItemAoCarrinho(ItemDeCompra item, Cliente cliente) {
        CarrinhoDeCompras carrinho = cliente.getCarrinhoDeCompras();

        carrinho.getItens().add(item);
        carrinho.setQuantidadeItens(1 + (carrinho.getQuantidadeItens()));
        carrinho.setValorTotal(carrinho.getValorTotal() + (item.getFruta().getPreco() * item.getQuantidadeDoItem()));
        item.getFruta().setQuantidade((item.getFruta().getQuantidade()) - (item.getQuantidadeDoItem()));

        FrutaDAO.editarFruta(item.getFruta());
    }

    public static void editarItemDoCarrinho(ItemDeCompra item, int novaQuantidade, Cliente cliente) {
        CarrinhoDeCompras carrinho = cliente.getCarrinhoDeCompras();

        if (item.getQuantidadeDoItem() > novaQuantidade) {
            item.getFruta().setQuantidade(item.getFruta().getQuantidade() + (item.getQuantidadeDoItem() - novaQuantidade));
        } else {
            item.getFruta().setQuantidade(item.getFruta().getQuantidade() - (novaQuantidade - item.getQuantidadeDoItem()));
        }

        carrinho.setValorTotal(carrinho.getValorTotal() - (item.getFruta().getPreco() * novaQuantidade));

        item.setQuantidadeDoItem(novaQuantidade);
        FrutaDAO.editarFruta(item.getFruta());
    }

    public static void listarItensDoCarrinho(CarrinhoDeCompras carrinho) {
        for (ItemDeCompra item : carrinho.getItens()) {
            System.out.println(item);
        }
    }

    public static void removerItemDoCarrinho(ItemDeCompra item, CarrinhoDeCompras carrinho) {
        carrinho.getItens().remove(item);
        carrinho.setQuantidadeItens(1 - (carrinho.getQuantidadeItens()));
        carrinho.setValorTotal(carrinho.getValorTotal() - (item.getFruta().getPreco() * item.getQuantidadeDoItem()));

        FrutaController.editar(item.getFruta(), item.getFruta().getPreco(), item.getFruta().getQuantidade());
    }

    public static ItemDeCompra buscarItemNoCarrinho(String nomeDoItem, CarrinhoDeCompras carrinho) {
        for (ItemDeCompra item : carrinho.getItens()) {
            if (item.getFruta().getNome().equals(nomeDoItem)) {
                return item;
            }
        }
        return null;
    }
}
