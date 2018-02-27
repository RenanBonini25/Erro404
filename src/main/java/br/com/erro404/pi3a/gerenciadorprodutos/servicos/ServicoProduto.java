package br.com.erro404.pi3a.gerenciadorprodutos.servicos;

import br.com.erro404.pi3a.gerenciadorprodutos.DAO.DAOProduto;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Produto;
import br.com.erro404.pi3a.gerenciadorprodutos.exceptions.ExceptionProduto;
import br.com.erro404.pi3a.gerenciadorprodutos.validadores.ValidadorProduto;
import java.sql.SQLException;

public class ServicoProduto {

    public static void cadastrarProduto(Produto produto)
            throws ExceptionProduto, SQLException, ClassNotFoundException {
        ValidadorProduto.validar(produto);
        try {

            DAOProduto.incluir(produto);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
