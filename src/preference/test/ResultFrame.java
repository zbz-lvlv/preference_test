/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preference.test;

/**
 *
 * @author Zbz
 */
public class ResultFrame extends javax.swing.JFrame {

    /**
     * Creates new form ResultFrame
     */
    public ResultFrame() {
        initComponents();
    }
    
    public void displayNames(String namePreferred, String nameNotPreferred){
        
        LabelNamePreferred.setText(namePreferred);
        LabelNameNotPreferred.setText("over " + nameNotPreferred);
        
    }
    
    //time0 - Avg. time taken to associate preferred name positively
    //time1 - Avg. time taken to associate preferred name negatively
    //time2 - Avg. time taken to associate not preferred name positively       
    //time3 - Avg. time taken to associate not preferred name negatively
    public void displayTimings(String namePreferred, String nameNotPreferred, int time0, int time1, int time2, int time3){
        
        LabelName0Positive.setText("Avg. time taken to associate " + namePreferred + " positively");
        LabelName0Negative.setText("Avg. time taken to associate " + namePreferred + " negatively");
        LabelName1Positive.setText("Avg. time taken to associate " + nameNotPreferred + " positively");
        LabelName1Negative.setText("Avg. time taken to associate " + nameNotPreferred + " negatively");
        
        LabelName0PositiveValue.setText(time0 + " ms");
        LabelName0NegativeValue.setText(time1 + " ms");
        LabelName1PositiveValue.setText(time2 + " ms");
        LabelName1NegativeValue.setText(time3 + " ms");
        
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
        LabelNamePreferred = new javax.swing.JLabel();
        LabelNameNotPreferred = new javax.swing.JLabel();
        LabelName0Positive = new javax.swing.JLabel();
        LabelName0PositiveValue = new javax.swing.JLabel();
        LabelName0Negative = new javax.swing.JLabel();
        LabelName0NegativeValue = new javax.swing.JLabel();
        LabelName1Positive = new javax.swing.JLabel();
        LabelName1PositiveValue = new javax.swing.JLabel();
        LabelName1Negative = new javax.swing.JLabel();
        LabelName1NegativeValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("You have shown an automatic preference for");

        LabelNamePreferred.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LabelNamePreferred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNamePreferred.setText("[name]");

        LabelNameNotPreferred.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNameNotPreferred.setText("over [name]");

        LabelName0Positive.setText("Avg. time taken to associate [name] positively");

        LabelName0PositiveValue.setText("jLabel4");

        LabelName0Negative.setText("Avg. time taken to associate [name] negatively");

        LabelName0NegativeValue.setText("jLabel4");

        LabelName1Positive.setText("Avg. time taken to associate [name] positively");

        LabelName1PositiveValue.setText("jLabel4");

        LabelName1Negative.setText("Avg. time taken to associate [name] negatively");

        LabelName1NegativeValue.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelNamePreferred, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(LabelNameNotPreferred, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelName0Positive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelName0PositiveValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelName0Negative)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelName0NegativeValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelName1Positive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelName1PositiveValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelName1Negative)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelName1NegativeValue)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNamePreferred, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelNameNotPreferred)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName0Positive)
                    .addComponent(LabelName0PositiveValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName0Negative)
                    .addComponent(LabelName0NegativeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName1Positive)
                    .addComponent(LabelName1PositiveValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelName1Negative)
                    .addComponent(LabelName1NegativeValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelName0Negative;
    private javax.swing.JLabel LabelName0NegativeValue;
    private javax.swing.JLabel LabelName0Positive;
    private javax.swing.JLabel LabelName0PositiveValue;
    private javax.swing.JLabel LabelName1Negative;
    private javax.swing.JLabel LabelName1NegativeValue;
    private javax.swing.JLabel LabelName1Positive;
    private javax.swing.JLabel LabelName1PositiveValue;
    private javax.swing.JLabel LabelNameNotPreferred;
    private javax.swing.JLabel LabelNamePreferred;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}