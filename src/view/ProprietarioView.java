package view;

import controller.FrutaController;
import model.dao.ClienteDAO;
import model.dao.FornecedorDAO;
import model.dao.FrutaDAO;
import model.domain.Cliente;
import model.domain.Fornecedor;
import model.domain.Fruta;
import model.domain.Proprietario;

import java.util.ArrayList;
import java.util.Scanner;

public class ProprietarioView {
    public static void display(Thread thread, Scanner input, ArrayList<Fruta> frutas, ArrayList<Fornecedor> fornecedores) {
        thread.start();

        int option = 0;

        Proprietario proprietario = Login.displayLogin(input);

        do {

            System.out.println("Bem vindo, " + proprietario.getNome() + ".\nO que deseja fazer?");
            try {
                System.out.println("1. Visualizar frutas em estoques");
                System.out.println("2. Visualizar frutas esgotadas");
                System.out.println("3. Solicitar fruta a fornecedor");
                System.out.println("4. Remover oferta de fruta");
                System.out.println("5. Editar preço da fruta");
                System.out.println("6. Adicionar cliente da loja");
                System.out.println("7. Listar clientes da loja");
                System.out.println("8. Remover clientes da loja");
                System.out.println("9. Sair");

                System.out.print("Informe sua opção: ");
                option = Integer.parseInt(input.nextLine());

                switch (option) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[VISUALIZAR FRUTAS EM ESTOQUE]");
                        frutas = FrutaDAO.listarFrutas();
                        for (Fruta fruta : frutas) {
                            if (fruta.getQuantidade() != 0)
                                System.out.println("\t" + fruta);
                        }

                        System.out.println();
                        break;

                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[VISUALIZAR FRUTAS ESGOTADAS]");
                        int countFrutasEsgotadas = 0;
                        frutas = FrutaDAO.listarFrutas();
                        for (Fruta fruta : frutas) {
                            if (fruta.getQuantidade() == 0) {
                                System.out.println(fruta);
                                countFrutasEsgotadas++;
                            }
                        }
                        if (countFrutasEsgotadas == 0) {
                            System.out.println("Todas as frutas possuem estoque.");
                        }

                        System.out.println();
                        break;

                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[SOLICITAR FRUTA A FORNECEDOR]");

                        for (Fornecedor fornecedor : fornecedores)
                            System.out.println(fornecedor);

                        try {
                            System.out.print("Insira o ID do fornecedor: ");
                            int idFornecedor = Integer.parseInt(input.nextLine());

                            Fornecedor fornecedor = FornecedorDAO.buscarForncedor(idFornecedor);

                            System.out.print("Nome da fruta: ");
                            String nomeFruta = input.nextLine().toLowerCase();

                            Fruta fruta = FrutaDAO.buscarFruta(nomeFruta);

                            System.out.print("Quantidade da fruta: ");
                            int quantidade = Integer.parseInt(input.nextLine());

                            System.out.print("Preço da fruta: ");
                            double preco = Double.parseDouble(input.nextLine());

                            if (fruta != null) {
                                FrutaController.editar(fruta, fruta.getPreco(), quantidade);
                            } else {
                                fruta = new Fruta(nomeFruta, preco, quantidade);
                                FrutaDAO.adicionarFruta(fruta, fornecedor.getId());
                            }

                            System.out.println("\nOperação efetuada.");

                        } catch (NullPointerException e) {
                            System.out.println("Fruta/fornecedor não encontrada(o) e/ou informações incorretas.");
                        } catch (NumberFormatException e) {
                            System.out.println("ID ou quantidade invalida(o).");
                        }

                        System.out.println();
                        break;

                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[REMOVER OFERTA DE FRUTA]");
                        try {
                            System.out.print("Nome da fruta: ");
                            String nomeFruta = input.nextLine().toLowerCase();

                            Fruta fruta = FrutaDAO.buscarFruta(nomeFruta);

                            assert fruta != null;
                            FrutaDAO.removerFruta(fruta.getId());

                            System.out.println("\nOperação efetuada.");

                        } catch (NullPointerException e) {
                            System.out.println("Fruta não encontrada e/ou informações incorretas.");
                        }

                        System.out.println();
                        break;

                    case 5:
                        try {
                            System.out.print("\033[H\033[2J");
                            System.out.println("[EDITAR PREÇO DE FRUTA]");
                            System.out.print("Insira o nome da fruta: ");
                            String nomeFruta = input.nextLine().toLowerCase();

                            Fruta fruta = FrutaDAO.buscarFruta(nomeFruta);

                            System.out.print("Informe o novo preço da fruta: ");

                            double preco = Double.parseDouble(input.nextLine());

                            assert fruta != null;
                            FrutaController.editar(fruta, preco, fruta.getQuantidade());

                            System.out.println("\nOperação efetuada.");
                        } catch (NullPointerException e) {
                            System.out.println("Fruta não encontrada e/ou informações incorretas.");
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade invalida.");
                        }

                        System.out.println();
                        break;

                    case 6:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[ADICIONAR CLIENTE DA LOJA]");

                        try {
                            System.out.print("Insira o id do cliente: ");
                            int idCliente = Integer.parseInt(input.nextLine());
                            Cliente cliente = ClienteDAO.buscarCliente(idCliente);
                            if (cliente == null) {
                                System.out.print("Insira o nome do cliente: ");
                                String nomeCliente = input.nextLine();
                                System.out.print("Insira o telefone do cliente: ");
                                String telefoneCliente = input.nextLine();
                                System.out.print("Insira o endereço do cliente: ");
                                String enderecoCliente = input.nextLine();
                                System.out.print("Insira o CPF do cliente: ");
                                String cpfCliente = input.nextLine();
                                cliente = new Cliente(nomeCliente, telefoneCliente, enderecoCliente, cpfCliente);
                                ClienteDAO.adicionarCliente(cliente);
                            } else {
                                System.out.println("Cliente ja cadastrado.");
                            }

                        } catch (NullPointerException e) {
                            System.out.println("Cliente não encontrado e/ou informações incorretas.");
                        }

                        System.out.println("\nOperação efetuada.");
                        break;

                    case 7:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[LISTAR CLIENTES]");
                        ArrayList<Cliente> clientes = ClienteDAO.listarClientes();

                        for (Cliente cliente : clientes) {
                            System.out.println("\t" + cliente);
                        }

                        System.out.println();
                        break;

                    case 8:
                        System.out.print("\033[H\033[2J");
                        System.out.println("[REMOVER CLIENTE]");
                        try {
                            System.out.print("Insira o Id do cliente: ");
                            int idCliente = Integer.parseInt(input.nextLine());

                            Cliente cliente = ClienteDAO.buscarCliente(idCliente);

                            assert cliente != null;
                            if (cliente == null) {
                                System.out.println("Cliente não encontrado.");
                            } else {
                                ClienteDAO.removerCliente(idCliente);
                                System.out.println("\nOperação efetuada.");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Cliente não encontrado e/ou informações incorretas.");
                        }

                        System.out.println();
                        break;

                    case 9:
                        System.out.println("Encerrando sessão...");
                        thread.interrupt();
                        break;

                    default:
                        System.out.println("Opção incorreta");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção incorreta. Por favor, insira um número.");
            }
        } while (option != 9);

    }
}