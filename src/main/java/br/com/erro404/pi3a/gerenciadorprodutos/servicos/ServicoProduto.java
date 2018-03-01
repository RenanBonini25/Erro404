package br.com.erro404.pi3a.gerenciadorprodutos.servicos;

import br.com.erro404.pi3a.gerenciadorprodutos.DAO.DAOProduto;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Categoria;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Produto;
import br.com.erro404.pi3a.gerenciadorprodutos.exceptions.DataSourceException;
import br.com.erro404.pi3a.gerenciadorprodutos.exceptions.ExceptionProduto;
import br.com.erro404.pi3a.gerenciadorprodutos.validadores.ValidadorProduto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class ServicoProduto {

    public static void cadastrarProduto(Produto produto, ArrayList<Categoria> categorias)
            throws ExceptionProduto, SQLException, ClassNotFoundException, DataSourceException {
        try {
            ValidadorProduto.validar(produto);
            long idProduto = DAOProduto.incluir(produto);
            for (int i = 0; i < categorias.size(); i++) {
                categorias.get(i).setIdProduto(idProduto);
                DAOProduto.incluirProdutoCat(categorias.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static void atualizarProduto(Produto produto)
            throws ExceptionProduto, DataSourceException {
        ValidadorProduto.validar(produto);
        try {
            DAOProduto.atualizarProduto(produto);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static ArrayList<Produto> procurarProduto(String valor) throws SQLException, ClassNotFoundException,
            ParseException, DataSourceException {
        try {
            if (valor == null) {
                return DAOProduto.listarProdutos();
            } else {
                return DAOProduto.procurarProduto(valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    public static Produto obterProduto(Integer id)
            throws ExceptionProduto, DataSourceException {
        try {
            return DAOProduto.obterProduto(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

}
