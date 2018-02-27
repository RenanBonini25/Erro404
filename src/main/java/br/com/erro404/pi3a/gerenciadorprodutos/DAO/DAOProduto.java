package br.com.erro404.pi3a.gerenciadorprodutos.DAO;

import br.com.erro404.pi3a.gerenciadorprodutos.classes.Categoria;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DAOProduto {

    private static Connection obterConexao() throws ClassNotFoundException, SQLException {
        //1A) Registrar drive JDBC
        Class.forName("com.mysql.jdbc.Driver");

        //1B) Abrir conexão com o BD
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/produtobd", "root", "");
    }

    public static long incluir(Produto produto) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO produto (NOME, DESCRICAO, PRECO_COMPRA, PRECO_VENDA, QUANTIDADE, DT_CADASTRO)"
                + "VALUES (?, ?, ?, ?, ?, ?) ";
        long idProduto = 0;

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDescricao());
                stmt.setDouble(3, produto.getPrecoCompra());
                stmt.setDouble(4, produto.getPrecoVenda());
                stmt.setInt(5, produto.getQuantidade());
                Timestamp dataBD = new Timestamp(produto.getDataCadastro().getTime());
                stmt.setTimestamp(6, dataBD);
                stmt.executeUpdate();

                try (ResultSet chave = stmt.getGeneratedKeys()) {
                    if (chave.next()) {
                        idProduto = chave.getLong(1);
                    }
                }


                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
        return idProduto;
    }

    public static void incluirProdutoCat(Categoria categoria) throws ClassNotFoundException, SQLException {
        String queryCat = "INSERT INTO produto_categoria (ID_PRODUTO, ID_CATEGORIA) VALUES (?, ?)";

        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt2 = conn.prepareStatement(queryCat)) {
                stmt2.setLong(1, categoria.getIdProduto());
                stmt2.setInt(2, categoria.getId());
                stmt2.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }

}
