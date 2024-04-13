package src.model.domain;

import java.util.ArrayList;

public class Fornecimento {
    private Fruta fruta;
    private ArrayList<String> historico;

    public Fornecimento(Fruta fruta) {
        this.fruta = fruta;
        historico = new ArrayList<>();
    }

    public Fornecimento() {
        historico = new ArrayList<>();
    }

    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }
}