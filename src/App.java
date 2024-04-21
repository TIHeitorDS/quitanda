import controller.CarrinhoController;
import model.dao.CarrinhoDAO;
import model.dao.ClienteDAO;
import model.dao.FornecedorDAO;
import model.dao.FrutaDAO;
import model.domain.Cliente;
import model.domain.Fornecedor;
import model.domain.Fruta;
import model.domain.ItemDeCompra;
import view.ProprietarioView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) {
        Thread thread = new Thread(App::clienteCompra);
        Scanner input = new Scanner(System.in);

        ArrayList<Fruta> frutas = new ArrayList<>();
        ArrayList<Fornecedor> fornecedores = FornecedorDAO.listarFornecedores();
        ProprietarioView.display(thread, input, frutas, fornecedores);

        input.close();
    }

    public static void clienteCompra() {
        SecureRandom secureRandom = new SecureRandom();
        ArrayList<Fruta> frutas = FrutaDAO.listarFrutas();

        do {
            CompletableFuture<Void> future1 = comprarFruta(ClienteDAO.buscarCliente(1), secureRandom, frutas);
            CompletableFuture<Void> future2 = comprarFruta(ClienteDAO.buscarCliente(2), secureRandom, frutas);
            CompletableFuture<Void> future3 = comprarFruta(ClienteDAO.buscarCliente(3), secureRandom, frutas);
            CompletableFuture<Void> future4 = comprarFruta(ClienteDAO.buscarCliente(4), secureRandom, frutas);

            CompletableFuture.allOf(future1, future2, future3, future4).join();
        } while (true);
    }

    private static CompletableFuture<Void> comprarFruta(Cliente cliente, SecureRandom secureRandom, ArrayList<Fruta> frutas) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            int index = secureRandom.nextInt(0, frutas.size());
            int quantidade = secureRandom.nextInt(1, 10);

            Fruta fruta = FrutaDAO.buscarFruta(frutas.get(index).getNome());

            assert fruta != null;
            if (quantidade > fruta.getQuantidade()) return;

            if (fruta != null && cliente != null) {
                ItemDeCompra item = new ItemDeCompra(fruta.getId(), quantidade, fruta);
                if (CarrinhoDAO.buscarItem(cliente, fruta.getNome()) == null) {
                    CarrinhoController.adicionarItemAoCarrinho(item, cliente);
                }
            }
        });
    }
}