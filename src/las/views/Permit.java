/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Permit;

/**
 *
 * @author Uer
 */
public class Permit extends javax.swing.JInternalFrame {

    /**
     * Creates new form Permit
     */
    public Permit() {
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

        Permit = new javax.swing.JTabbedPane();
        AllotPermit = new javax.swing.JPanel();

        javax.swing.GroupLayout AllotPermitLayout = new javax.swing.GroupLayout(AllotPermit);
        AllotPermit.setLayout(AllotPermitLayout);
        AllotPermitLayout.setHorizontalGroup(
            AllotPermitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        AllotPermitLayout.setVerticalGroup(
            AllotPermitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        Permit.addTab("Allot New Permit", AllotPermit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Permit, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Permit, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AllotPermit;
    private javax.swing.JTabbedPane Permit;
    // End of variables declaration//GEN-END:variables
}
