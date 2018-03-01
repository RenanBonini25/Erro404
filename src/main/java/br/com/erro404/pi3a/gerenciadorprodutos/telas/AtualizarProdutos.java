/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erro404.pi3a.gerenciadorprodutos.telas;

import br.com.erro404.pi3a.gerenciadorprodutos.classes.Categoria;
import br.com.erro404.pi3a.gerenciadorprodutos.classes.Produto;
import br.com.erro404.pi3a.gerenciadorprodutos.servicos.ServicoProduto;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class AtualizarProdutos extends javax.swing.JInternalFrame {

    private Produto produto = new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public AtualizarProdutos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textPrecoVenda = new javax.swing.JTextField();
        textPrecoCompra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        checkUm = new javax.swing.JCheckBox();
        checkDois = new javax.swing.JCheckBox();
        checkTres = new javax.swing.JCheckBox();
        checkQuatro = new javax.swing.JCheckBox();
        checkCinco = new javax.swing.JCheckBox();
        textNome = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Atualizar Produtos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jLabel1.setText("Nome");

        jLabel2.setText("Quantidade");

        jLabel4.setText("Preço de compra");

        jLabel5.setText("Preço de venda");

        jLabel6.setText("Descriçao");

        textQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textQuantidadeKeyTyped(evt);
            }
        });

        jLabel7.setText("R$");

        jLabel8.setText("R$");

        textPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPrecoVendaKeyTyped(evt);
            }
        });

        textPrecoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textPrecoCompraKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));

        checkUm.setText("UM");

        checkDois.setText("DOIS");
        checkDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDoisActionPerformed(evt);
            }
        });

        checkTres.setText("TRES");

        checkQuatro.setText("QUATRO");

        checkCinco.setText("CINCO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkUm)
                        .addGap(18, 18, 18)
                        .addComponent(checkDois)
                        .addGap(18, 18, 18)
                        .addComponent(checkTres))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(checkQuatro)
                        .addGap(18, 18, 18)
                        .addComponent(checkCinco)))
                .addGap(129, 129, 129))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkUm)
                    .addComponent(checkTres)
                    .addComponent(checkDois))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkQuatro)
                    .addComponent(checkCinco)))
        );

        textNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNomeKeyTyped(evt);
            }
        });

        textDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDescricaoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textDescricao, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(textPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(textPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))))
        );

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoSalvar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDoisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDoisActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            textNome.setText(produto.getNome());
            textDescricao.setText(produto.getDescricao());
            textPrecoCompra.setText(String.valueOf(produto.getPrecoCompra()));
            textPrecoVenda.setText(String.valueOf(produto.getPrecoVenda()));

            textQuantidade.setText(String.valueOf(produto.getQuantidade()));
            ArrayList<Categoria> categorias = produto.getCategorias();
            for (int i = 0; i < categorias.size(); i++) {
                int num = categorias.get(i).getId();
                checkCategoria(num);
            }
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void textPrecoCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPrecoCompraKeyTyped
        String caracteres = "0987654321.,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textPrecoCompraKeyTyped

    private void textPrecoVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textPrecoVendaKeyTyped
        String caracteres = "0987654321.,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_textPrecoVendaKeyTyped

    private void textQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textQuantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
        if (textQuantidade.getText().length() > 2) {
            textQuantidade.setText(textQuantidade.getText().substring(0, 3));
        }
    }//GEN-LAST:event_textQuantidadeKeyTyped

    private void textNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomeKeyTyped
        if (textNome.getText().length() > 99) {
            textNome.setText(textNome.getText().substring(0, 99));
        }
    }//GEN-LAST:event_textNomeKeyTyped

    private void textDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDescricaoKeyTyped
        if (textDescricao.getText().length() > 99) {
            textDescricao.setText(textDescricao.getText().substring(0, 99));
        }
    }//GEN-LAST:event_textDescricaoKeyTyped

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        try {
            produto.setNome(textNome.getText());
            produto.setDescricao(textDescricao.getText());
            String precoCompra = textPrecoCompra.getText().replaceAll(",", ".");
            String precoVenda = textPrecoVenda.getText().replaceAll(",", ".");
            produto.setPrecoCompra(Double.parseDouble(precoCompra));
            produto.setPrecoVenda(Double.parseDouble(precoVenda));
            produto.setQuantidade(Integer.parseInt(textQuantidade.getText()));
            ArrayList<Categoria> categorias = selecionarCategorias(produto);
            produto.setCategorias(categorias);
        } catch (Exception e) {

        }

        try {
            ServicoProduto.atualizarProduto(produto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(rootPane, "Produto atualizado com sucesso!",
                "Atualização efetuada!", JOptionPane.INFORMATION_MESSAGE);

        /*try {
            if (this.getDesktopPane().getTopLevelAncestor() instanceof TelaPrincipal) {
                TelaPrincipal principal = (TelaPrincipal) this.
                        getDesktopPane().getTopLevelAncestor();
                if (principal != null) {
                    principal.getConsultarProdutos().atualizarLista();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        this.dispose();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    public void definirCategorias(JCheckBox checkCat, int i, ArrayList<Categoria> categorias) {
        if (checkCat.isSelected()) {
            Categoria categoria = new Categoria();
            categoria.setId(i);
            categorias.add(categoria);
        }
    }

    public ArrayList<Categoria> selecionarCategorias(Produto produto) {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        definirCategorias(checkUm, 1, categorias);
        definirCategorias(checkDois, 2, categorias);
        definirCategorias(checkTres, 3, categorias);
        definirCategorias(checkQuatro, 4, categorias);
        definirCategorias(checkCinco, 5, categorias);
        return categorias;
    }

    public void checkCategoria(int num) {
        switch (num) {
            case 1:
                checkUm.setSelected(true);
                break;
            case 2:
                checkDois.setSelected(true);
                break;
            case 3:
                checkTres.setSelected(true);
                break;
            case 4:
                checkQuatro.setSelected(true);
                break;
            case 5:
                checkCinco.setSelected(true);
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JCheckBox checkCinco;
    private javax.swing.JCheckBox checkDois;
    private javax.swing.JCheckBox checkQuatro;
    private javax.swing.JCheckBox checkTres;
    private javax.swing.JCheckBox checkUm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textPrecoCompra;
    private javax.swing.JTextField textPrecoVenda;
    private javax.swing.JTextField textQuantidade;
    // End of variables declaration//GEN-END:variables

}
