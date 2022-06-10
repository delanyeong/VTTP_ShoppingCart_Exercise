package project.core;

import java.net.*;
import java.io.*;


public class ClientMain {
    public static void main(String[] args) throws IOException {
        
        //CLIENT SOCKET
        Socket s = new Socket ("localhost", 3000);


        // 1a CLIENT - 
        //PRINTER INTO THE OUTPUTSTREAM
        //to write
        PrintWriter pr = new PrintWriter (s.getOutputStream());
        pr.println("is it working");
        pr.flush();

        //2b SERVER - 
        //INPUTSTREAM READER FOR THE INPUTSTREAM THEN BUFFERREADER
        //to read
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server :" + str);
    }
}
