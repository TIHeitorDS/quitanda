package model.dao;

import model.database.DB;
import model.domain.Proprietario;
import java.sql.SQLException;

public class ProprietarioDAO {
    public static Proprietario retornaProprietario(int id) {
        var sql = "SELECT id_proprietario, nome, telefone, endereco, email, senha FROM proprietario WHERE id_proprietario=?";

        try (var conn = DB.connect(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            var rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Proprietario(
                        rs.getInt("id_proprietario"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    
    }
}