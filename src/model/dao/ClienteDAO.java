package model.dao;

import model.database.DB;
import model.domain.Cliente;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {
    public static void adicionarCliente(Cliente cliente) {
        var sql = "INSERT INTO cliente(nome_cliente, telefone_cliente, endereco, cpf_cliente)" + "VALUES(?,?,?,?)";

        try (var conn = DB.connect()) {
            assert conn != null;

            try (var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getTelefone());
                pstmt.setString(3, cliente.getEndereco());
                pstmt.setString(4, cliente.getCpf());

                int insertedRow = pstmt.executeUpdate();

                if (insertedRow > 0) {
                    pstmt.getGeneratedKeys();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente buscarCliente(int id) {
        var sql = "SELECT id_cliente, nome_cliente, telefone_cliente, endereco, cpf_cliente FROM cliente WHERE id_cliente=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("telefone_cliente"),
                        rs.getString("endereco"),
                        rs.getString("cpf_cliente")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static void editarCliente(Cliente cliente) {
        var sql = "UPDATE cliente SET nome_cliente=?, telefone_cliente=?, endereco=?, cpf_cliente=? WHERE id_cliente=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.setString(3, cliente.getEndereco());
            pstmt.setString(4, cliente.getCpf());
            pstmt.setInt(5, cliente.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        var sql = "SELECT * FROM cliente";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            var rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                String nome = rs.getString("nome_cliente");
                String telefone = rs.getString("telefone_cliente");
                String endereco = rs.getString("endereco");
                String cpf = rs.getString("cpf_cliente");

                Cliente cliente = new Cliente(id, nome, telefone, endereco, cpf);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return clientes;
    }

    public static void removerCliente(int id) {
        var sql = "DELETE FROM cliente WHERE id_cliente=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}