/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preference.test;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Zbz
 */
public class DockFrame extends javax.swing.JFrame {
    
    Dock dock;
    
    public DockFrame(Dock dock) {
        initComponents();
        ListItem.setModel(new DefaultListModel());
         
        this.dock = dock;
    }
    
    public void displayItems(String item){
        
        DefaultListModel listItemModel  = (DefaultListModel) ListItem.getModel();
        listItemModel.addElement(item);
 
    }
    
    public String getSelectedItem(){
        
        if(ListItem.getSelectedValue() == null){
            
            JOptionPane.showMessageDialog(this,
                "Please select an item in the list view",
                "No item selected",
                JOptionPane.ERROR_MESSAGE);
        
            return "error";
            
        }
        
        return ListItem.getSelectedValue().toString();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ListItem = new javax.swing.JList<>();
        ButtonLoad = new javax.swing.JButton();
        ButtonStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextFieldItem0 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextFieldItem1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dock");

        jScrollPane1.setViewportView(ListItem);
        ListItem.getAccessibleContext().setAccessibleName("");

        ButtonLoad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonLoad.setText("Load");
        ButtonLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLoadMouseClicked(evt);
            }
        });

        ButtonStart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonStart.setText("Start");
        ButtonStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonStartMouseClicked(evt);
            }
        });

        jLabel1.setText("Item 1");

        jLabel2.setText("Item 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(ButtonStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldItem0))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldItem1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextFieldItem0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextFieldItem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLoadMouseClicked
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text Files", "txt");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            dock.load(chooser.getSelectedFile().getPath(), chooser.getSelectedFile().getName());
        }
        
    }//GEN-LAST:event_ButtonLoadMouseClicked

    private void ButtonStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonStartMouseClicked

        dock.start(TextFieldItem0.getText(), TextFieldItem1.getText());
        
    }//GEN-LAST:event_ButtonStartMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLoad;
    private javax.swing.JButton ButtonStart;
    private javax.swing.JList<String> ListItem;
    private javax.swing.JTextField TextFieldItem0;
    private javax.swing.JTextField TextFieldItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}