package model.dao;

import model.database.DB;
import model.domain.Fornecedor;
import model.domain.Fruta;

import java.sql.SQLException;
import java.util.ArrayList;

public class FornecedorDAO {
    public static Fornecedor buscarForncedor(int id) {
        var sql = "SELECT id_fornecedor, nome_fornecedor, telefone_fornecedor, endereco, cnpj_fornecedor FROM fornecedor WHERE id_fornecedor=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Fornecedor(
                        rs.getInt("id_fornecedor"),
                        rs.getString("nome_fornecedor"),
                        rs.getString("telefone_fornecedor"),
                        rs.getString("endereco"),
                        rs.getString("cnpj_fornecedor")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void editarFornecedor(Fornecedor fornecedor) {
        var sql = "UPDATE fornecedor SET nome_fornecedor=?, telefone_fornecedor=?, endereco=?, cnpj_fornecedor=? WHERE id_fornecedor=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getTelefone());
            pstmt.setString(3, fornecedor.getEndereco());
            pstmt.setString(4, fornecedor.getCnpj());
            pstmt.setInt(5, fornecedor.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Fornecedor> listarFornecedores() {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        var sql = "SELECT * FROM fornecedor";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_fornecedor");
                String nome = rs.getString("nome_fornecedor");
                String telefone = rs.getString("telefone_fornecedor");
                String endereco = rs.getString("endereco");
                String cnpj = rs.getString("cnpj_fornecedor");

                Fornecedor fornecedor = new Fornecedor(id, nome, telefone, endereco, cnpj);
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fornecedores;
    }

    public static ArrayList<Fruta> listarFornecimento(Fornecedor fornecedor) {
        ArrayList<Fruta> frutas = new ArrayList<>();

        var sql = "SELECT id_fruta, nome_fruta, preco_fruta, quantidade_fruta FROM frutas WHERE id_fornecedor=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fornecedor.getId());
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_fruta");
                String nome = rs.getString("nome_fruta");
                double preco = rs.getDouble("preco_fruta");
                int quantidade = rs.getInt("quantidade_fruta");

                Fruta fruta = new Fruta(id, nome, preco, quantidade);

                frutas.add(fruta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return frutas;
    }
}
