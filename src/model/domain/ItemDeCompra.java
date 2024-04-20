package model.domain;

public class ItemDeCompra {
    private int id;
    private int quantidadeDoItem;
    private Fruta fruta;

    public ItemDeCompra(int quantidadeDoItem, Fruta fruta) {
        this.quantidadeDoItem = quantidadeDoItem;
        this.fruta = fruta;
    }

    public ItemDeCompra(int id, int quantidadeDoItem, Fruta fruta) {
        this.id = id;
        this.quantidadeDoItem = quantidadeDoItem;
        this.fruta = fruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeDoItem() {
        return quantidadeDoItem;
    }

    public void setQuantidadeDoItem(int quantidadeDoItem) {
        this.quantidadeDoItem = quantidadeDoItem;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    @Override
    public String toString() {
        return "Fruta: " + fruta.getNome() + ", quantidade do Item: " + quantidadeDoItem + ", preco da fruta: " + fruta.getPreco() + ", preco total: R$" + (fruta.getPreco() * getQuantidadeDoItem());
    }
}
