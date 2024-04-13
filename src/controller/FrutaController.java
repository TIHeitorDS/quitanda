package src.controller;

import java.util.ArrayList;
import src.model.domain.Fruta;

public final class FrutaController {
    private static ArrayList<Fruta> frutas = new ArrayList<>();

    public static ArrayList<Fruta> getFrutas() {
        return frutas;
    }

    public static void setFrutas(ArrayList<Fruta> frutas) {
        FrutaController.frutas = frutas;
    }

    public static void adicionarFruta(Fruta fruta) {
        FrutaController.frutas.add(fruta);
    }

    public static void removerFruta(Fruta fruta) {
        FrutaController.frutas.remove(fruta);
    }

    public static Fruta buscarFruta(String nome) {
        for (Fruta fruta : frutas)
            if (fruta.getNome().equals(nome))
                return fruta;
        return null;
    }

    public static void listarFrutas() {
        for (Fruta fruta : frutas) {
            System.out.println(fruta);
        }
    }
}
