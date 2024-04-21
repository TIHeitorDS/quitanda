package view;

import model.dao.ProprietarioDAO;
import model.domain.Proprietario;

import java.util.Scanner;

public class Login {
    public static Proprietario displayLogin(Scanner input) {
        String email;
        String senha;

        do {
            System.out.println("\t\t|SISTEMA DE GERENCIAMENTO DE QUITANDA|");
            System.out.println("\n[LOGIN]");
            System.out.print("Insira o email: ");
            email = input.nextLine();

            System.out.print("Insira a senha: ");
            senha = input.nextLine();

            Proprietario proprietario = ProprietarioDAO.retornaProprietario(email, senha);

            if (proprietario != null) {
                System.out.print("\033[H\033[2J");
                System.out.println("Carregando...");
                return proprietario;
            }

            System.out.println("Email e/ou senha inválidos.\n");

        } while (true);
    }
}
