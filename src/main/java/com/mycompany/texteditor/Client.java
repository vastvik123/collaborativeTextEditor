package com.mycompany.texteditor;

import static com.mycompany.texteditor.textEditorGUI.allStrings;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Client {
    public Socket socket;
    
    Client(){
        try{
            socket = IO.socket("https://shared-text-editor.herokuapp.com/");
            socket.connect();
            System.out.println("connected to server!");
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getStrings(){
        //Asking server to send all the shareStrings which are currently in use
            sendStrings();
            
             //allStrings event from server which provides all the shareStrings currently in use
            socket.on("allStrings", new Emitter.Listener() {
                @Override
                public void call(Object... arg0) {
                    try{
                        System.out.println("Caught allStrings Event");
                        System.out.println("cleared allStrings array.");
                        allStrings.clear();
                        
                        JSONObject data =  (JSONObject) arg0[0];
                        String strData = data.getString("string");
                       
                        JSONArray arr = new JSONArray(strData);
                        System.out.println(strData);
                        for(int i=0;i<arr.length(); i++){
                            System.out.println("adding");
                            allStrings.add(arr.getString(i));
                        }
                        System.out.println("After adding size: " + allStrings.size());
                        for(int i=0; i<allStrings.size(); i++){
                            System.out.println(allStrings.get(i));
                        }
                      
                    } catch(Exception e){
                        System.out.println(e);
                    }
                }
            });
       
    }
    
    public void initialize(String s){
        try{
            
            //SEND client's shareString to the SERVER
            sendShareString(s);
            
            //Message event from the server
            socket.on("message" , new Emitter.Listener() {
                
                @Override
                public void call(Object... arg0) {
                    
                    try{
                        System.out.println("Getting message");
                        JSONObject data = (JSONObject) arg0[0];
                        String message = data.getString("msg").toString();
                        System.out.println(message);
                    } catch(Exception e){
                        System.out.println(e);
                    }
                }
            });
                       
            
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public void sendShareString(String s){
        JSONObject data = null;
        try{
            data = new JSONObject();
            data.put("shareString", s);
 
        } catch(Exception e){
            e.printStackTrace();
        }
        socket.emit("shareString", data);
    }
    
    public void sendStrings(){
        System.out.println("Asked server for allStrings!");
        socket.emit("sendStrings", "");
    }
    
    public void sendData(String s){
        JSONObject data = null;
        try{
            data = new JSONObject();
            data.put("text", s);
 
        } catch(Exception e){
            e.printStackTrace();
        }
        socket.emit("data", data);
    }
    
    public void destroy(){
        socket.disconnect();
    }
}
