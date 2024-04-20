package model.dao;

import model.database.DB;
import model.domain.Fruta;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FrutaDAO {
    public static void adicionarFruta(Fruta fruta, int idFornecedor) {
        var sql = "INSERT INTO frutas(nome_fruta, preco_fruta, quantidade_fruta, id_fornecedor)" + "VALUES(?,?,?,?)";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, fruta.getNome());
            pstmt.setDouble(2, fruta.getPreco());
            pstmt.setInt(3, fruta.getQuantidade());
            pstmt.setInt(4, idFornecedor);

            int insertedRow = pstmt.executeUpdate();

            if (insertedRow > 0) {
                pstmt.getGeneratedKeys();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Fruta buscarFruta(String nome) {
        var sql = "SELECT id_fruta, nome_fruta, preco_fruta, quantidade_fruta FROM frutas WHERE nome_fruta=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Fruta(
                        rs.getInt("id_fruta"),
                        rs.getString("nome_fruta"),
                        rs.getDouble("preco_fruta"),
                        rs.getInt("quantidade_fruta")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void editarFruta(Fruta fruta) {
        var sql = "UPDATE frutas SET preco_fruta=?, quantidade_fruta=? WHERE id_fruta=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, fruta.getPreco());
            pstmt.setInt(2, fruta.getQuantidade());
            pstmt.setInt(3, fruta.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Fruta> listarFrutas() {
        ArrayList<Fruta> frutas = new ArrayList<>();

        var sql = "SELECT * FROM frutas";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
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

    public static void removerFruta(int id) {
        var sql = "DELETE FROM frutas WHERE id_fruta=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}