package model.dao;

import model.database.DB;
import model.domain.Cliente;
import model.domain.Fruta;
import model.domain.ItemDeCompra;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarrinhoDAO {
    public static void adicionarItem(ItemDeCompra item, Cliente cliente) {
        var sql = "INSERT INTO carrinho_cliente(quantidade_item, valor, id_cliente, nome_item, id_fruta)" + "VALUES(?,?,?,?,?)";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, item.getQuantidadeDoItem());
            pstmt.setDouble(2, item.getFruta().getPreco() * item.getQuantidadeDoItem());
            pstmt.setInt(3, cliente.getId());
            pstmt.setString(4, item.getFruta().getNome());
            pstmt.setInt(5, item.getFruta().getId());

            var adicionarTupla = pstmt.executeUpdate();

            if (adicionarTupla > 0) {
                pstmt.getGeneratedKeys();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ItemDeCompra buscarItem(Cliente cliente, String nome) {
        var sql = "SELECT id_fruta, nome_item, quantidade_item FROM carrinho_cliente WHERE id_cliente=? AND nome_item=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cliente.getId());
            pstmt.setString(2, nome);

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                Fruta fruta = FrutaDAO.buscarFruta(nome);

                return new ItemDeCompra(
                        rs.getInt("id_fruta"),
                        rs.getInt("quantidade_item"),
                        fruta
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void editarItem(ItemDeCompra item) {
        var sql = "UPDATE carrinho_cliente SET quantidade_item=?, valor=? WHERE id_fruta=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, item.getQuantidadeDoItem());
            pstmt.setDouble(2, item.getQuantidadeDoItem() * item.getFruta().getPreco());
            pstmt.setInt(3, item.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<ItemDeCompra> atualizarCarrinho(Cliente cliente) {
        ArrayList<ItemDeCompra> itens = new ArrayList<>();

        var sql = "SELECT nome_item, quantidade_item FROM carrinho_cliente WHERE id_cliente=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cliente.getId());

            var rs = pstmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome_item");
                int quantidade = rs.getInt("quantidade_item");
                Fruta fruta = FrutaDAO.buscarFruta(nome);
                int id = fruta.getId();
                ItemDeCompra item = new ItemDeCompra(id, quantidade, fruta);

                itens.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return itens;
    }

    public static void removerItem(ItemDeCompra item) {
        var sql = "DELETE FROM carrinho_cliente WHERE id_fruta=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, item.getFruta().getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
