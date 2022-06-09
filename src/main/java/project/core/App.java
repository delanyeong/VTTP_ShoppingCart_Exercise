// package project.core;

// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.ObjectOutputStream;
// import java.io.FileInputStream;
// import java.io.ObjectInputStream;
// import java.util.LinkedList;
// import java.io.*;
// import java.util.List;
// import java.lang.*;

// import java.util.Scanner;

// /**
//  * Hello world!
//  *
//  */
// public class App {
//     public static void main(String[] args) {

//         // deserializer
//         try {

//             FileInputStream fileStream = new FileInputStream("fred.cart");

//             ObjectInputStream is = new ObjectInputStream(fileStream);

//             Cart fredCart = (Cart) is.readObject();

//             is.close();

//             // Scanner
//             // Scanner myObj = new Scanner(System.in);
//             // System.out.println("There are 10 carts in shoppingcart directory");

//             // String user = myObj.nextLine();
//             // System.out.println("load " + user);

//             Cart fredCart = new Cart("fred", new LinkedList<String>());

//             Console cons = System.console();
//             String input;
//             int delIndex;
//             boolean stop = false;

//             // Add test data
//             fredCart.getCart().add("apple");
//             fredCart.getCart().add("orange");
//             fredCart.getCart().add("pear");

//             // main loop
//             while (!stop) {
//                 input = cons.readLine("> ");

//                 System.out.printf("READ: %s\n", input);
//                 // list <list of space separated items>
//                 // del <idx>
//                 // end
//                 String[] terms = input.split(" ");
//                 String cmd = terms[0];

//                 switch (cmd) {
//                     case "add":
//                         for (int i = 1; i < terms.length; i++) {
//                             boolean found = false;
//                             for (int j = 0; j < fredCart.getCart().size(); j++) {
//                                 if (terms[i].equals(fredCart.getCart().get(j))) {
//                                     found = true;
//                                     break;
//                                 }
//                             }
//                             if (!found) {
//                                 fredCart.getCart().add(terms[i]);
//                                 System.out.printf("Added %s to cart\n", terms[i]);
//                             }
//                         }
//                         break;

//                     case "list":
//                         if (fredCart.getCart().size() > 0) {
//                             for (int i = 0; i < fredCart.getCart().size(); i++) {
//                                 System.out.printf("%d. %s\n", (i + 1), fredCart.getCart().get(i));
//                             }
//                         } else {
//                             System.out.println("Your cart is empty");
//                         }
//                         break;

//                     case "del":
//                         if (terms.length < 2) {
//                             System.err.println("Please provide an index to delete");
//                         } else {
//                             delIndex = Integer.parseInt(terms[1]) - 1;
//                             if (delIndex < fredCart.getCart().size()) {
//                                 System.out.printf("Deleted %s from cart\n", fredCart.getCart().get(delIndex));
//                                 fredCart.getCart().remove(delIndex);
//                             } else {
//                                 System.err.println("No such item");
//                             }
//                         }
//                         break;

//                     case "end":
//                         stop = true;
//                         break;

//                     default:
//                 }

//                 // serializer
//                 FileOutputStream outStream = new FileOutputStream("fred.cart");
//                 ObjectOutputStream os = new ObjectOutputStream(outStream);

//                 os.writeObject(fredCart);

//                 os.close();
//             }
//         } catch (Exception ex) {
//             ex.printStackTrace();
//         }

//         // deserializer
//         try {
//             FileOutputStream fileStream = new FileOutputStream("fred.cart");
//             ObjectOutputStream os = new ObjectOutputStream(fileStream);

//             os.writeObject(fredCart);

//             os.close();
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }
// }
