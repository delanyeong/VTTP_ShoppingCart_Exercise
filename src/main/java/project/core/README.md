package project.core;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

//server stuff 
import java.io.*;
import java.net.*;

public class ShoppingCart {

    public static void main(String[] args) throws IOException {

        // SET UP SERVER SOCKET
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

        System.out.println("client connected");

        // 1B SERVER -
        // INPUTSTREAM READER FOR THE INPUTSTREAM THEN BUFFERREADER
        // TO READ
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        
        // // TO WRITE
        // PrintWriter pr = new PrintWriter(s.getOutputStream());
        // pr.println("hello");
        //pr.flush();
        // pr.close();

        // String str = bf.readLine();
        // System.out.println("client :" + str);

        // THIS IS WHERE TASK 1 STARTS
        // ====================================================

        File directory = new File("./src/main/java/project/core/shoppingcart");
        int fileCount = directory.list().length;

        // SCANNER
        // Scanner open = new Scanner(System.in);

        // THERE ARE N CARTS IN SHOPPINGCART DIRECTORY
        // System.out.printf("There are %d carts in shoppingcart directory\n",
        // fileCount);
        System.out.printf("There are %d carts in shoppingcart directory\n", fileCount);

        // THIS IS WHERE YOU TYPE LOAD NAME
        // String input = open.readLine();
        String input = bf.readLine();
        System.out.println("this is input:" + input); // to check

        String[] firstline = input.split(" ");
        String fname = firstline[1];

        // try {
            
            
        //     // TO WRITE
        //     PrintWriter pr = new PrintWriter(s.getOutputStream());
        //     pr.println("hello");

        //     pr.close();

        // } catch(IOException ex){
        //     ex.printStackTrace();
        // }

        if (firstline[0].equals("load")) {


            // System.out.println(fname + " shopping cart loaded");
            // pr.println(fname + " shopping cart loaded");

            try {

                FileInputStream fileStream = new FileInputStream(
                        "./src/main/java/project/core/shoppingcart/" + fname + ".cart");

                ObjectInputStream is = new ObjectInputStream(fileStream);

                Cart fredCart = (Cart) is.readObject();

                is.close();

                System.out.println(fredCart);

                int delIndex;
                boolean stop = false;

                while (!stop) {
                    // Console cons = System.console();
                    String input2 = bf.readLine();

                    String[] terms = input2.split(" ");
                    String cmd = terms[0];
                    switch (cmd) {
                        case "add":
                            for (int i = 1; i < terms.length; i++) {
                                boolean found = false;
                                for (int j = 0; j < fredCart.getCart().size(); j++) {
                                    if (terms[i].equals(fredCart.getCart().get(j))) {
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    fredCart.getCart().add(terms[i]);
                                    // System.out.printf("Added %s to cart\n", terms[i]);
                                    pr.printf("Added %s to cart\n", terms[i]);
                                }
                            }
                            break;

                        case "list":
                            if (fredCart.getCart().size() > 0) {
                                for (int i = 0; i < fredCart.getCart().size(); i++) {
                                    // System.out.printf("%d. %s\n", (i + 1), fredCart.getCart().get(i));
                                    pr.printf("%d. %s\n", (i + 1), fredCart.getCart().get(i));
                                }
                            } else {
                                // System.out.println("Your cart is empty");
                                pr.println("Your cart is empty");
                            }
                            break;

                        case "del":
                            if (terms.length < 2) {
                                // System.err.println("Please provide an index to delete");
                                pr.println("Please provide an index to delete");
                            } else {
                                delIndex = Integer.parseInt(terms[1]) - 1;
                                if (delIndex < fredCart.getCart().size()) {
                                    // System.out.printf("Deleted %s from cart\n",
                                    // fredCart.getCart().get(delIndex));
                                    pr.printf("Deleted %s from cart\n", fredCart.getCart().get(delIndex));
                                    fredCart.getCart().remove(delIndex);
                                } else {
                                    // System.err.println("No such item");
                                    pr.println("No such item");
                                }
                            }
                            break;

                        case "end":
                            stop = true;
                            pr.println("exited");
                            break;

                        default:
                    }
                }

                FileOutputStream outStream = new FileOutputStream("fred.cart");
                ObjectOutputStream os = new ObjectOutputStream(outStream);

                os.writeObject(fredCart);

                os.close();

                // s.close();

                // open.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("try again");
        }
    }
}
