package AMANAR_ChatApp;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.UIManager;

/**
 *
 * @author AbdeAMNR
 */
public class ClientSide extends javax.swing.JFrame {

    /**
     * Creates new form ServeurMain
     */
    public ClientSide() {
        initComponents();
    }

    static int portNum = 1002;
    static String ipNum = "127.0.0.1";
    static Socket sktClient = null;
    static DataOutputStream outputToServer ;
    static DataInputStream inputFromServer;
    static String msgClient, msgServer;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtConversationC = new javax.swing.JTextArea();
        cmdSendC = new javax.swing.JButton();
        lblClient = new javax.swing.JLabel();
        txtMsgC = new javax.swing.JTextField();
        lblAide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtConversationC.setEditable(false);
        txtConversationC.setColumns(20);
        txtConversationC.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtConversationC.setRows(5);
        jScrollPane1.setViewportView(txtConversationC);

        cmdSendC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myFiles/send_icone.png"))); // NOI18N
        cmdSendC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendCActionPerformed(evt);
            }
        });

        lblClient.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblClient.setForeground(new java.awt.Color(255, 94, 0));
        lblClient.setText("Client");

        txtMsgC.setFont(new java.awt.Font("Helvetica-Normal", 2, 18)); // NOI18N

        lblAide.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAide.setText("©2017 Designed and Developed by Abderrahim AMANAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAide)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtMsgC)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmdSendC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClient)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClient, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdSendC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMsgC))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblAide)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    public static void client() {
        try {

            sktClient = new Socket(ipNum, portNum);
            inputFromServer = new DataInputStream(sktClient.getInputStream());
            outputToServer = new DataOutputStream(sktClient.getOutputStream());

            while (true) {
                String readMsgServer = inputFromServer.readUTF();
              //  txtConversationC.setForeground(Color.BLUE);
                txtConversationC.append("Serveur : " + readMsgServer + "\n");
            }
        } catch (IOException ex) {
            txtConversationC.append("Erreur : " + ex + "\n");
        }
    }


    private void cmdSendCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendCActionPerformed

        try {
            outputToServer.writeUTF(txtMsgC.getText());
            // txtConversationC.setForeground(Color.BLACK);
            txtConversationC.append("Client (Moi): " + txtMsgC.getText() + "\n");
            txtMsgC.setText("");
        } catch (IOException ex) {
            txtConversationC.append("Erreur : " + ex + "\n");
        }
    }//GEN-LAST:event_cmdSendCActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClientSide().setVisible(true);
        });

        client();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSendC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAide;
    private javax.swing.JLabel lblClient;
    private static javax.swing.JTextArea txtConversationC;
    private javax.swing.JTextField txtMsgC;
    // End of variables declaration//GEN-END:variables
}
