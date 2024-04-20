package model.domain;

import java.util.ArrayList;

public class CarrinhoDeCompras {
    private ArrayList<ItemDeCompra> itens;
    private int quantidadeItens;
    private double valorTotal;

    public CarrinhoDeCompras(int quantidadeItens, double valorTotal) {
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
        this.itens = new ArrayList<>();
    }

    public ArrayList<ItemDeCompra> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemDeCompra> itens) {
        this.itens = itens;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
