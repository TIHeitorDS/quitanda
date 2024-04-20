package controller;

import model.dao.CarrinhoDAO;
import model.dao.FrutaDAO;
import model.domain.CarrinhoDeCompras;
import model.domain.Cliente;
import model.domain.ItemDeCompra;

import java.util.ArrayList;

public final class CarrinhoController {
    public static void adicionarItemAoCarrinho(ItemDeCompra item, Cliente cliente) {
        cliente.getCarrinhoDeCompras().getItens().add(item);
        cliente.getCarrinhoDeCompras().setQuantidadeItens(1 + (cliente.getCarrinhoDeCompras().getQuantidadeItens()));
        cliente.getCarrinhoDeCompras().setValorTotal(cliente.getCarrinhoDeCompras().getValorTotal() + (item.getFruta().getPreco() * item.getQuantidadeDoItem()));
        item.getFruta().setQuantidade((item.getFruta().getQuantidade()) - (item.getQuantidadeDoItem()));

        CarrinhoDAO.adicionarItem(item, cliente);
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
        CarrinhoDAO.editarItem(item);
        FrutaDAO.editarFruta(item.getFruta());
    }

    public static void atualizarCarrinho(Cliente cliente) {
        ArrayList<ItemDeCompra> itens = CarrinhoDAO.atualizarCarrinho(cliente);

        cliente.getCarrinhoDeCompras().setItens(itens);
    }

    public static void listarItensDoCarrinho(CarrinhoDeCompras carrinho) {
        for (ItemDeCompra item : carrinho.getItens()) {
            System.out.println(item);
        }
    }

    public static void removerItemDoCarrinho(ItemDeCompra item, CarrinhoDeCompras carrinho) {
        carrinho.getItens().remove(item);
        carrinho.setQuantidadeItens(1 - (carrinho.getQuantidadeItens()));

        assert item != null;

        carrinho.setValorTotal(carrinho.getValorTotal() - (item.getFruta().getPreco() * item.getQuantidadeDoItem()));
        item.getFruta().setQuantidade((item.getFruta().getQuantidade()) + (item.getQuantidadeDoItem()));
        CarrinhoDAO.removerItem(item);
        FrutaController.editar(item.getFruta(), item.getFruta().getPreco(), item.getFruta().getQuantidade());
    }
}
