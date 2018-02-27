package br.com.erro404.pi3a.gerenciadorprodutos.servicos;

import br.com.erro404.pi3a.gerenciadorprodutos.DAO.DAOProduto;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Categoria;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Produto;
import br.com.erro404.pi3a.gerenciadorprodutos.exceptions.ExceptionProduto;
import br.com.erro404.pi3a.gerenciadorprodutos.validadores.ValidadorProduto;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoProduto {

    public static void cadastrarProduto(Produto produto, ArrayList<Categoria> categorias)
            throws ExceptionProduto, SQLException, ClassNotFoundException {
        try {
            ValidadorProduto.validar(produto);
            long idProduto = DAOProduto.incluir(produto);
            for (int i = 0; i < categorias.size(); i++) {
                categorias.get(i).setIdProduto(idProduto);
                DAOProduto.incluirProdutoCat(categorias.get(i));
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

}
