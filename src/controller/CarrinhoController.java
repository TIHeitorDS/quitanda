package src.controller;

import src.model.domain.ItemDeCompra;
import src.model.domain.CarrinhoDeCompras;

public final class CarrinhoController {

    public static void adicionarItemAoCarrinho(ItemDeCompra item, CarrinhoDeCompras carrinho) {
        carrinho.getItens().add(item);
        carrinho.setQuantidadeItens(1 + (carrinho.getQuantidadeItens()));
        carrinho.setValorTotal(carrinho.getValorTotal() + (item.getFruta().getPreco() * item.getQuantidadeDoItem()));
        item.getFruta().setQuantidade((item.getFruta().getQuantidade()) - (item.getQuantidadeDoItem()));
    }

    public static void listarItensDoCarrinho(CarrinhoDeCompras carrinho) {
        for (ItemDeCompra item : carrinho.getItens()) {
            System.out.println(item);
        }
    }

    public static ItemDeCompra buscarItemNoCarrinho(String nomeDoItem, CarrinhoDeCompras carrinho) {
        for (ItemDeCompra item : carrinho.getItens()) {
            if (item.getFruta().getNome().equals(nomeDoItem)) {
                return item;
            }
        }
        return null;
    }

    public static void editarItemDoCarrinho(ItemDeCompra item, int novaQuantidade) {
        item.setQuantidadeDoItem(novaQuantidade);
        
    }
}
