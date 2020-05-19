/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.bean.Cargo;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author rodrigo
 */
public class jfCadastroUsuario extends javax.swing.JFrame {

    Vector<Cargo> cargos;
    Usuario objUsuario;
    UsuarioDAO DAO;
    Cargo objCargo;

    public jfCadastroUsuario() {
        initComponents();
        try {
            DAO = new UsuarioDAO();
            objUsuario = new Usuario();
            objCargo = new Cargo();

            cargos = DAO.listarCargos();
            verificarCargos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlNomeUsuario = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlLogin = new javax.swing.JLabel();
        jlSenha = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jlCargo = new javax.swing.JLabel();
        jtNomUsuario = new javax.swing.JTextField();
        jtDesEmail = new javax.swing.JTextField();
        jtDesLogin = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jbAjuda = new javax.swing.JButton();
        jpSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de novo usuario");
        setResizable(false);

        jlNomeUsuario.setText("Nome:");

        jlEmail.setText("E-mail:");

        jlLogin.setText("Login:");

        jlSenha.setText("Senha:");

        jlCargo.setText("Cargo: ");

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
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAjuda))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jlNomeUsuario)
                                .addComponent(jlEmail)
                                .addComponent(jlLogin)
                                .addComponent(jlSenha))
                            .addComponent(jlCargo))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDesEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtDesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(jtDesEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLogin)
                    .addComponent(jtDesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCargo)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbSair)
                    .addComponent(jbAjuda))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjudaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ajuda para criar novo usuario do sistema.\nNo campo Nome: usuario informara o seu nome completo\n"
                + "No campo E-mail: usuario informara uma conta de e-mail pessoal para recuperar sua senha.\n"
                + "No campo Login: usuario informara um nome para login.\nEX: 'nome.sobrenome'\n"
                + "No campo Senha: usuario informara uma senha contendo letras maiusculas, minusculas e numerais, nao sera aceito caracteres especiais!\n"
                + "No campo Repetir senha: usuario informara a senha novamente para ser realizado a verificacao de senhas iguais.\n"
                + "No campo Cargo: usuario selecionara o cargo que ele exerce, caso nao tenho o cargo o usuario solicitara ao adminstrador do sistema para incluir o seu cargo.\n");
    }//GEN-LAST:event_jbAjudaActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (validarCampos()) {
                if (preencherCampos()) {
                    if (DAO.salvarUsuario(objUsuario)) {
                        JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!");
                        new jfLogin().setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Não foi possivel cadastrar o usuário!");
                        limparCampos();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        new jfLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbSairActionPerformed

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
            java.util.logging.Logger.getLogger(jfCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfCadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbCargo;
    private javax.swing.JButton jbAjuda;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlCargo;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JLabel jlNomeUsuario;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtDesEmail;
    private javax.swing.JTextField jtDesLogin;
    private javax.swing.JTextField jtNomUsuario;
    // End of variables declaration//GEN-END:variables

    public boolean validarCampos() {
        if (jtNomUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite o nome do usuário.");
            jtNomUsuario.requestFocus();
            return false;
        }
        if (jtDesEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite o e-mail do usuário.");
            jtDesEmail.requestFocus();
            return false;
        }
        if (jtDesLogin.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite o login do usuário.");
            jtDesLogin.requestFocus();
            return false;
        }
        if (jpSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Digite uma senha para o usuário.");
            jpSenha.requestFocus();
            return false;
        }
        //verificar se ja existe usuario cadastrado - fazer
        if (jtDesLogin.getText().equals("admin")) {
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado!\nFavor entrar com outro login!");
            jtDesLogin.setText("");
            jtDesLogin.requestFocus();
            return false;
        }
        return true;
    }

    public void limparCampos() {
        jtNomUsuario.setText("");
        jtDesEmail.setText("");
        jtDesLogin.setText("");
        jpSenha.setText("");
    }

    public void verificarCargos() {
        try {
            if (cargos.size() == 0) {
                Vector msg = new Vector();
                msg.add("Não a cargos cadastrados!");
                cbCargo.setEnabled(false);
                cbCargo.setModel(new DefaultComboBoxModel(msg));
            } else {
                cbCargo.setModel(new DefaultComboBoxModel(cargos));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    public boolean preencherCampos() {
        objUsuario.setNomUsuario(jtNomUsuario.getText());
        objUsuario.setDesEmail(jtDesEmail.getText());
        objUsuario.setDesLogin(jtDesLogin.getText());
        objUsuario.setDesSenha(jpSenha.getText());
        objUsuario.setCargo(cargos.get(cbCargo.getSelectedIndex()));
        return true;
    }
}
