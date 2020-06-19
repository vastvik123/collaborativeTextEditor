package com.mycompany.texteditor;

import java.awt.FileDialog;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import org.json.JSONObject;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.util.ArrayList;

public class textEditorGUI extends javax.swing.JFrame {
    
    private String fileName = "";
    private String originalText = "";
    private String dontSave = "";
    private String shareString = "";
    private char undoOrRedo;
    public boolean shared = false;
    public Client client;
    public static ArrayList<String> allStrings;
    
    Clipboard clipboard = getToolkit().getSystemClipboard();
    UndoManager manager = new UndoManager();
   
    public textEditorGUI() {
        initComponents();
        allStrings = new ArrayList<String>();
        client = new Client();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        Undo = new javax.swing.JMenuItem();
        Redo = new javax.swing.JMenuItem();
        Cut = new javax.swing.JMenuItem();
        Copy = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        Tools = new javax.swing.JMenu();
        Share = new javax.swing.JMenuItem();
        Join = new javax.swing.JMenuItem();
        CloseConnection = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(3, 54, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.setMaximumSize(new java.awt.Dimension(150, 32769));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 35));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(64, 35));

        File.setText("File");
        File.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        File.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        New.setText("New");
        New.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        File.add(New);

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Open");
        Open.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        File.add(Save);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        Exit.setText("Exit");
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Edit.setText("Edit");
        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        Undo.setText("Undo");
        Undo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        Edit.add(Undo);

        Redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Redo.setText("Redo");
        Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoActionPerformed(evt);
            }
        });
        Edit.add(Redo);

        Cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        Cut.setText("Cut");
        Cut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutActionPerformed(evt);
            }
        });
        Edit.add(Cut);

        Copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Copy.setText("Copy");
        Copy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
        Edit.add(Copy);

        Paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        Paste.setText("Paste");
        Paste.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteActionPerformed(evt);
            }
        });
        Edit.add(Paste);

        jMenuBar1.add(Edit);

        Tools.setText("Tools");
        Tools.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Tools.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Share.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        Share.setText("Share");
        Share.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Share.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShareActionPerformed(evt);
            }
        });
        Tools.add(Share);

        Join.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        Join.setText("Join");
        Join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinActionPerformed(evt);
            }
        });
        Tools.add(Join);

        CloseConnection.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        CloseConnection.setText("CloseConnection");
        CloseConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseConnectionActionPerformed(evt);
            }
        });
        Tools.add(CloseConnection);

        jMenuBar1.add(Tools);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
        // TODO add your handling code here:
        try{
            Transferable pasteText = clipboard.getContents(textEditorGUI.this);
            String sel = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(sel,textArea.getSelectionStart(),textArea.getSelectionEnd());
        }catch(Exception e){
            System.out.println("Paste Not Working");
        }
    }//GEN-LAST:event_PasteActionPerformed

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        // TODO add your handling code here:

        String copyText = textArea.getSelectedText();
        StringSelection copySelection = new StringSelection(copyText);
        clipboard.setContents(copySelection, copySelection);

    }//GEN-LAST:event_CopyActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        // TODO add your handling code here:
        String cutString  = textArea.getSelectedText();
        StringSelection cutSelection = new StringSelection(cutString);

        clipboard.setContents(cutSelection,cutSelection);
        textArea.replaceRange("",textArea.getSelectionStart(),textArea.getSelectionEnd());

    }//GEN-LAST:event_CutActionPerformed

    private void RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoActionPerformed
        // TODO add your handling code here:
        undoOrRedo = 'R';
        performUndoAndRedo();
    }//GEN-LAST:event_RedoActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        // TODO add your handling code here:
        undoOrRedo = 'U';
        performUndoAndRedo();
    }//GEN-LAST:event_UndoActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        dontSave = "exit";
        onExit();
    }//GEN-LAST:event_ExitActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        onSave();
    }//GEN-LAST:event_SaveActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
        dontSave = "open";
        onOpen();
    }//GEN-LAST:event_OpenActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        // TODO add your handling code here:
        dontSave = "new";
        onNew();
    }//GEN-LAST:event_NewActionPerformed

    private void ShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShareActionPerformed
        // TODO add your handling code here:
        if(shareString.equals("")){
            client.getStrings();
            StringBuilder builder = new StringBuilder();
            while(true){
                String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                
                int count = 5;
                builder.setLength(0);
                while (count-- != 0) {
                    int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
                    builder.append(ALPHA_NUMERIC_STRING.charAt(character));
                }
                System.out.println(builder.toString());
                System.out.println("size: " + allStrings.size());
                if(!allStrings.isEmpty()){
                    int check = 1;
                    for(int i=0; i<allStrings.size(); i++){
                        if(allStrings.get(i).equals(builder.toString())){
                            check = 0;
                            break;
                        }
                    }
                    if(check == 1)
                    break;
                    
                }
                else break;
               
            }

            shareString = builder.toString();
            client.initialize(shareString);            
            shared = true;
            recieveData();
            
        }
        JOptionPane.showMessageDialog(new JFrame(), "Share this code ' " + shareString + " ' with your friends.");
        
    }//GEN-LAST:event_ShareActionPerformed

    private void JoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoinActionPerformed
        // TODO add your handling code here:
        if(shareString.equals("")){
            client.getStrings();
            try{
                String input = JOptionPane.showInputDialog("Enter Valid Code");
                System.out.println("input: " + input);
                if(!input.equals("null")){
                    shareString = input;
                    boolean present = false;
                    System.out.println("size: " + allStrings.size());
                    for(int i=0; i<allStrings.size(); i++){
                        if(allStrings.get(i).equals(shareString)){
                            present = true;
                            break;
                        }
                    }
                    if(present){
                        client.initialize(shareString);
                        shared = true;
                        recieveData();
                    }
                    else{
                        shareString = "";
                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Code. Please try again.");
                    }
                    
                }
              
                //System.out.println(shareString);
            } catch(Exception e){
                System.out.println(e);
            }       
        }
        
        else{
            JOptionPane.showMessageDialog(new JFrame(), "This file is currently being shared! Close the editor and try again.");
        }
    }//GEN-LAST:event_JoinActionPerformed

    private void CloseConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseConnectionActionPerformed
        // TODO add your handling code here:
        if(client != null){
            shareString = "";
            shared = false;
            client.destroy();
            
        }
        
    }//GEN-LAST:event_CloseConnectionActionPerformed
    
    public void showDialogBox(){
        
        Object[] options = { "Save","Don't Save", "Cancel"};
                     
        int choice = JOptionPane.showOptionDialog(new JFrame(),null,
                "Do you want to save following Changes?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        
        if(choice == JOptionPane.YES_OPTION){
           onSave();
        }
        else if(choice == JOptionPane.NO_OPTION){
            textArea.setText(originalText);
            
            if(dontSave.equals("new")){
                onNew();
            }
            else if(dontSave.equals("open")){
                onOpen();
            }
            else if(dontSave.equals("exit")){
                onExit();
                if(shared){
                    client.destroy();
                }
            }
            else{
                System.exit(0);
                if(shared){
                    client.destroy();
                }
            }
        }
        
    }
    
    public void onSave(){
        if(fileName.equals("")){
            FileDialog fileDialog = new FileDialog(textEditorGUI.this, "Save File ", FileDialog.SAVE);
            fileDialog.setVisible(true);
            
            if(fileDialog.getFile() != null){
               
                fileName = fileDialog.getDirectory() + fileDialog.getFile();
                setTitle(fileName);
            }     
        }
        
        try{
           
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(textArea.getText());
            originalText = textArea.getText();
            setTitle(fileName);
            fileWriter.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        if(shared){
            client.sendData(textArea.getText());
        }
    }
    
    private void onNew(){
        
        if(originalText.equals(textArea.getText())){
            
           textArea.setText("");
           setTitle("untitled");
           fileName = "";
           originalText = "";  
           dontSave = "";
           shareString = "";
           shared = false;
           if(client != null)
           client.destroy();
        }
        else{
            dontSave = "new";
            showDialogBox();
        }
    }
    
    private void onOpen(){
        
        if(originalText.equals(textArea.getText())){
           
            FileDialog fileDialog = new FileDialog(textEditorGUI.this, "Open File", FileDialog.LOAD);
            fileDialog.setVisible(true);

            if(fileDialog.getFile() != null){
                fileName = fileDialog.getDirectory() + fileDialog.getFile();
                setTitle(fileName);
            }

            try{

                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                StringBuilder sb = new StringBuilder();
                String line = null;

                while( (line = reader.readLine() ) != null){
                    sb.append(line + '\n');
                    textArea.setText(sb.toString());
                }
                reader.close();
                originalText = textArea.getText();
                dontSave = "";
                shareString = "";
                shared = false;
                if(client != null)
                client.destroy();

            }catch(Exception e){
                System.out.println("File not found!");
            }
           
        }
        else{
            dontSave = "open";
            showDialogBox();
        }
        
    }
    
    private void onExit(){
        
        if(originalText.equals(textArea.getText()) ){
            if(client != null)
            client.destroy();
            
            System.exit(0);
        }
        else{
            showDialogBox();
        }
    }
    
    private void performUndoAndRedo(){
        
        if(undoOrRedo == 'U'){
            Undo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(manager.canUndo()){
                        manager.undo();
                    }
                }
            });
        }
        
        else{
            Redo.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(manager.canRedo()){
                        manager.redo();
                    }
                }
            });
        }
        
    }
    
    private void recieveData(){
        client.socket.on("data", new Emitter.Listener(){
            @Override
            public void call(Object... arg0) {
                    
                try{
                    System.out.println("Getting message");
                    JSONObject data = (JSONObject) arg0[0];
                    String message = data.getString("text");
                    textArea.setText(message);
                } catch(Exception e){
                    System.out.println(e);
                }
                
            }
        });
    }
    
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
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new textEditorGUI().setVisible(true);
            }
        });
        
        
    }
    
    public boolean canExit(){
        if(originalText.equals(textArea.getText()))
        return true;
        else
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CloseConnection;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Join;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JMenuItem Redo;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem Share;
    private javax.swing.JMenu Tools;
    private javax.swing.JMenuItem Undo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
