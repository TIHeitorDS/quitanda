package fornecimento;

import java.util.List;

public class EstoqueDeFrutas {
    private List<Fruta> frutasEmEstoque;

    public EstoqueDeFrutas(List<Fruta> frutasEmEstoque) {
        this.frutasEmEstoque = frutasEmEstoque;
    }

    public void adicionarFruta(Fruta fruta) {
        frutasEmEstoque.add(fruta);
    }

    public List<Fruta> getFrutasEmEstoque() {
        return frutasEmEstoque;
    }

    public void setFrutasEmEstoque(List<Fruta> frutasEmEstoque) {
        this.frutasEmEstoque = frutasEmEstoque;
    }

    public void editarEstoqueDeFrutas(EstoqueDeFrutas estoqueDeFrutas, List<Fruta> frutasEmEstoque) {
        estoqueDeFrutas.setFrutasEmEstoque(frutasEmEstoque);
    }

    public EstoqueDeFrutas criarEstoqueDeFrutas(List<Fruta> frutasEmEstoque) {
        return new EstoqueDeFrutas(frutasEmEstoque);
    }

    public void removerFruta(Fruta fruta) {
        frutasEmEstoque.remove(fruta);
    }

    public void listarEstoqueDeFrutas() {
        for (Fruta fruta : frutasEmEstoque) {
            System.out.println(fruta.toString());
        }
    }

}
