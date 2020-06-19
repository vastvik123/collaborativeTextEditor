package com.mycompany.texteditor;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TextEditor{
        
    public void windowClosing(WindowEvent e){
          int result = JOptionPane.showConfirmDialog(null, "Are you sure?","confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

          if(result == JOptionPane.YES_OPTION){
                  System.exit(0);
          }else{
                  //Do nothing
          }
    }

    public static void main(String[] args) {
        
        textEditorGUI obj = new textEditorGUI();
        obj.setBounds(0,0,700,700);
        obj.setTitle("Shared Editor");
        obj.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        obj.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent){
                if(obj.canExit()){
                    if(obj.shared){
                        obj.client.destroy();
                    }
                    System.exit(0);
                }
                else{
                    obj.showDialogBox();
                }
            }
        });
   
    }
    
}

