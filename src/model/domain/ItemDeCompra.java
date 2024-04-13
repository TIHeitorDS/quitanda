package src.model.domain;

public class ItemDeCompra {
    private int quantidadeDoItem;
    private Fruta fruta;
    
    public ItemDeCompra(int quantidadeDoItem, Fruta fruta) {
        this.quantidadeDoItem = quantidadeDoItem;
        this.fruta = fruta;
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
        return "ItemDeCompra [quantidadeDoItem=" + quantidadeDoItem + ", fruta=" + fruta.getNome() +  ", preco da fruta="+ fruta.getPreco() + ", preco total="+ (fruta.getPreco() * getQuantidadeDoItem()) +"]";
    }
}
