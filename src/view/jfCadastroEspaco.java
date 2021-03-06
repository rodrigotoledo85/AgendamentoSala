/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import model.bean.Espaco;
import model.dao.EspacoDAO;

/**
 *
 * @author rodrigo
 */
public class jfCadastroEspaco extends javax.swing.JFrame {

    Espaco objEspaco = new Espaco();
    EspacoDAO DAO = new EspacoDAO();

    /**
     * Creates new form jfCadastroEspaco
     */
    public jfCadastroEspaco() {
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

        jLabel1 = new javax.swing.JLabel();
        jtDescricaoEspaco = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jbAjuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de novo espaco");
        setResizable(false);

        jLabel1.setText("Descricao do novo espaco: ");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jbAjuda.setText("Ajuda");
        jbAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAjudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(jtDescricaoEspaco, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAjuda)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtDescricaoEspaco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbSair)
                    .addComponent(jbAjuda))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (validarCampos()) {
                if (preencherCampos()) {
                    if (DAO.salvar(objEspaco)) {
                        JOptionPane.showMessageDialog(this, "Novo espaco cadastrado com sucesso!");
                        MDIHome telaPrincipal = new MDIHome();
                        telaPrincipal.setVisible(true);
                        this.dispose();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjudaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ajuda tela de - Cadastro de Novo Espaço.\n"
                + "Para cadastrar um novo espaço basta preencher o campo - Descricao do novo espaco - com o nome deste espaço e clicar em - Salvar.\n"
                + "Após salvar o novo espaço o mesmo estara disponível para proximos agendamentos.");
    }//GEN-LAST:event_jbAjudaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfCadastroEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfCadastroEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfCadastroEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfCadastroEspaco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfCadastroEspaco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbAjuda;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtDescricaoEspaco;
    // End of variables declaration//GEN-END:variables

    public boolean validarCampos() {
        if (jtDescricaoEspaco.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha o campo da descricao do novo espaco!");
            jtDescricaoEspaco.requestFocus();
            return false;
        }

        return true;
    }

    public void limparCampos() {
        jtDescricaoEspaco.setText("");
    }

    public boolean preencherCampos() {
        objEspaco.setDesEspaco(jtDescricaoEspaco.getText());
        return true;
    }
}
