package project.core;

import java.util.List;
import java.util.LinkedList;
import java.io.*;
import java.util.*;
import java.io.Serializable;

public class Cart implements Serializable {

    // Properties
    // Properties of a cart; what does it need?
    // 1. name of the customer
    String custName;
    // 2. list
    List<String> cartList = new LinkedList<String>();

    // Constructor
    // to bundle up everything in properties when initializing in main
    public Cart(String custName, List<String> cartList) {
        this.custName = custName;
        this.cartList = cartList;
    }

    // Methods - getters and setters
    // Methods - get and set your INSTANCE VARIABLES, NOT your input commands!

    List<String> getCart() {
        return cartList;
    }

    void setCart(List<String> updCart) {
        cartList = updCart;
    }

    String getCustName() {
        return custName;
    }

    public void setCustName(String updCustName) {
        custName = updCustName;
    }

    // try
    public void addCart(String addCartItem) {
        this.cartList.add(addCartItem);
    }

    // load

    // save

}
