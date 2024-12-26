import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.getConnection();
            System.out.println("Conexão bem-sucedida!");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}
