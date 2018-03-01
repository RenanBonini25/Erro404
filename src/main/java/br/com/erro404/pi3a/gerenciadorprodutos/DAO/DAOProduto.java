package br.com.erro404.pi3a.gerenciadorprodutos.DAO;

import br.com.erro404.pi3a.gerenciadorprodutos.classes.Categoria;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Produto;
import br.com.erro404.pi3a.gerenciadorprodutos.servicos.ServicoProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try (PreparedStatement stmt = conn.prepareStatement(queryCat)) {
                stmt.setLong(1, categoria.getIdProduto());
                stmt.setInt(2, categoria.getId());
                stmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        }
    }

    public static ArrayList<Produto> listarProdutos() throws SQLException, ClassNotFoundException, ParseException {
        String query = "SELECT * FROM Produto";
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        Produto produto = new Produto();
                        produto.setId(resultados.getInt("ID"));
                        produto.setNome(resultados.getString("NOME"));
                        produto.setDescricao(resultados.getString("DESCRICAO"));
                        produto.setPrecoCompra(resultados.getDouble("PRECO_COMPRA"));
                        produto.setPrecoVenda(resultados.getDouble("PRECO_VENDA"));
                        produto.setQuantidade(resultados.getInt("QUANTIDADE"));
                        Timestamp t = resultados.getTimestamp("DT_CADASTRO");
                        String data = formatador.format(t);
                        Date dataCadastro = formatador.parse(data);
                        produto.setDataCadastro(dataCadastro);
                        listaProdutos.add(produto);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
        return listaProdutos;
    }

    public static ArrayList<Produto> procurarProduto(String valor) throws SQLException, ClassNotFoundException, ParseException {
        String query = "SELECT * FROM Produto WHERE Nome LIKE ?";
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, "%" + valor + "%");
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        Produto produto = new Produto();
                        produto.setId(resultados.getInt("ID"));
                        produto.setNome(resultados.getString("NOME"));
                        produto.setDescricao(resultados.getString("DESCRICAO"));
                        produto.setPrecoCompra(resultados.getDouble("PRECO_COMPRA"));
                        produto.setPrecoVenda(resultados.getDouble("PRECO_VENDA"));
                        produto.setQuantidade(resultados.getInt("QUANTIDADE"));
                        Timestamp t = resultados.getTimestamp("DT_CADASTRO");
                        String data = formatador.format(t);
                        Date dataVenda = formatador.parse(data);
                        produto.setDataCadastro(dataVenda);
                        listaProdutos.add(produto);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
        return listaProdutos;
    }

    public static Produto obterProduto(Integer id) throws ClassNotFoundException, ParseException {
        String query = "SELECT * FROM Produto WHERE ID = ?";
        String query2 = "SELECT distinct CATEGORIA.ID FROM CATEGORIA\n"
                + "INNER JOIN PRODUTO_CATEGORIA ON CATEGORIA.ID = PRODUTO_CATEGORIA.ID_CATEGORIA\n"
                + "INNER JOIN PRODUTO ON ? = PRODUTO_CATEGORIA.ID_PRODUTO;";
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                try (ResultSet resultados = stmt.executeQuery()) {
                    while (resultados.next()) {
                        Produto produto = new Produto();
                        produto.setId(resultados.getInt("ID"));
                        produto.setNome(resultados.getString("NOME"));
                        produto.setDescricao(resultados.getString("DESCRICAO"));
                        produto.setPrecoCompra(resultados.getDouble("PRECO_COMPRA"));
                        produto.setPrecoVenda(resultados.getDouble("PRECO_VENDA"));
                        produto.setQuantidade(resultados.getInt("QUANTIDADE"));
                        Timestamp t = resultados.getTimestamp("DT_CADASTRO");
                        String data = formatador.format(t);
                        Date dataVenda = formatador.parse(data);
                        produto.setDataCadastro(dataVenda);
                        ArrayList<Integer> categorias = new ArrayList<Integer>();
                        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
                        try (PreparedStatement stmt2 = conn.prepareStatement(query2)) {
                            stmt2.setInt(1, id);
                            try (ResultSet resultados2 = stmt2.executeQuery()) {
                                while (resultados2.next()) {
                                    Categoria categoria = new Categoria();
                                    categoria.setId(resultados2.getInt("CATEGORIA.ID"));
                                    categoria.setIdProduto(produto.getId());
                                    listaCategorias.add(categoria);
                                    //categorias.add((resultados2.getInt("CATEGORIA.ID")));
                                }
                                produto.setCategorias(listaCategorias);
                            }
                        }
                        return produto;
                    }
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void atualizarProduto(Produto produto) throws ClassNotFoundException {
        String query = "UPDATE Produto SET NOME = ?, DESCRICAO = ?, PRECO_COMPRA = ?, PRECO_VENDA = ?, "
                + "QUANTIDADE = ? WHERE (ID = ?)";
        String query2 = "DELETE FROM PRODUTO_CATEGORIA WHERE ID_PRODUTO = ?";
        String queryCat = "INSERT INTO produto_categoria (ID_PRODUTO, ID_CATEGORIA) VALUES (?, ?)";
        try (Connection conn = obterConexao()) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(6, produto.getId());
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDescricao());
                stmt.setDouble(3, produto.getPrecoCompra());
                stmt.setDouble(4, produto.getPrecoVenda());
                stmt.setInt(5, produto.getQuantidade());
                stmt.executeUpdate();

                try (PreparedStatement stmt2 = conn.prepareStatement(query2)) {
                    stmt2.setInt(1, produto.getId());
                    stmt2.executeUpdate();
                }
//                try (PreparedStatement stmt3 = conn.prepareStatement(queryCat)) {
//                stmt3.setLong(1, categoria.getIdProduto());
//                stmt3.setInt(2, categoria.getId());
//                stmt3.executeUpdate();
//                conn.commit();
//            } catch (SQLException e) {
//                conn.rollback();
//                throw e;
//            }
                conn.commit();
                ServicoProduto.atualizarCategoria(produto);

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
