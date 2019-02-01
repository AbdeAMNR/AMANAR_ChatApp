package AMANAR_ChatApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/**
 *
 * @author AbdeAMNR
 */
public class ServeurSide extends javax.swing.JFrame {

    /**
     * Creates new form ServeurMain
     */
    public ServeurSide() {
        initComponents();
    }

    static ServerSocket sktServeur;
    static Socket sktServiceClient;
    static DataOutputStream outputToServer;
    static DataInputStream inputFromServer;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdSendS = new javax.swing.JButton();
        lblServerS = new javax.swing.JLabel();
        txtMsgS = new javax.swing.JTextField();
        lblAideS = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlConverServer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        cmdSendS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myFiles/send_icone.png"))); // NOI18N
        cmdSendS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendSActionPerformed(evt);
            }
        });

        lblServerS.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lblServerS.setForeground(new java.awt.Color(255, 94, 0));
        lblServerS.setText("Serveur");

        txtMsgS.setFont(new java.awt.Font("Helvetica-Normal", 2, 18)); // NOI18N

        lblAideS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAideS.setText("©2017 Designed and Developed by Abderrahim AMANAR");

        pnlConverServer.setLayout(new javax.swing.BoxLayout(pnlConverServer, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(pnlConverServer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtMsgS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSendS, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblAideS)
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblServerS)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServerS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdSendS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMsgS, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblAideS)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void serveur() {
        try {
            sktServeur = new ServerSocket(1002);
            sktServiceClient = sktServeur.accept();
            inputFromServer = new DataInputStream(sktServiceClient.getInputStream());
            outputToServer = new DataOutputStream(sktServiceClient.getOutputStream());
            while (true) {
                String messageClientLire = inputFromServer.readUTF();
                String inText = "Client : " + messageClientLire;
                addTextToPnl(inText, Color.MAGENTA);
            }
        } catch (IOException ex) {
            addTextToPnl("Erreur : " + ex + "\n", Color.red);
        }

    }

    public static void addTextToPnl(String txt, Color txtAreaColor) {
        JTextArea msgText = new JTextArea();
        msgText.setLineWrap(true);
        String myText = txt;
        msgText.setText(myText);
        msgText.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        //     msgText.setForeground(Color.BLACK);
        msgText.setBackground(txtAreaColor);
      //  msgText.setSize(new Dimension(150, 40));

        //   JScrollPane scrollArea = new JScrollPane(msgText);
        pnlConverServer.add(msgText);
        pnlConverServer.add(Box.createRigidArea(new Dimension(0, 15)));
        pnlConverServer.revalidate();
    }
    private void cmdSendSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendSActionPerformed
        try {
            outputToServer.writeUTF(txtMsgS.getText().trim());
            addTextToPnl("Serveur (Moi): " + txtMsgS.getText().trim(), Color.WHITE);
            txtMsgS.setText("");
        } catch (IOException ex) {
            addTextToPnl("Erreur : " + ex + "\n", Color.red);
        }
    }//GEN-LAST:event_cmdSendSActionPerformed

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
            java.util.logging.Logger.getLogger(ServeurSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServeurSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServeurSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServeurSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServeurSide().setVisible(true);
            }
        });
        serveur();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSendS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAideS;
    private javax.swing.JLabel lblServerS;
    private static javax.swing.JPanel pnlConverServer;
    private javax.swing.JTextField txtMsgS;
    // End of variables declaration//GEN-END:variables
}
