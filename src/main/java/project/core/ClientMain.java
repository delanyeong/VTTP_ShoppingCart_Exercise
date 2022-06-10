package project.core;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;


        try {

            socket = new Socket("localhost", 3000);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);


            while (true) {

                String msgToSend = scanner.nextLine();
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("Server: " + bufferedReader.readLine());


                if (msgToSend.trim().equals("BYE"))
                break;

            }

            scanner.close();








        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (socket != null)
                socket.close();
                if (inputStreamReader != null)
                inputStreamReader.close();
                if (outputStreamWriter != null)
                outputStreamWriter.close();
                if (bufferedReader != null)
                bufferedReader.close();
                if (bufferedWriter != null)
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
