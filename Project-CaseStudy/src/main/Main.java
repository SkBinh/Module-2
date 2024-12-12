package main;

import menu.CustomerMenu;
import menu.OwnerMenu;
import menu.StaffMenu;
import services.CartManager;
import services.Login;
import services.ProductManager;
import users.Customer;
import users.Owner;
import users.Staff;
import users.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login login = Login.getInstance();
        ProductManager productManager = ProductManager.getInstance();
        CartManager cartManager = CartManager.getInstance();

        Scanner scanner = new Scanner(System.in);

        User user = null;
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        user = login.authenticate(username, password);
        
        while (user == null) {
            System.out.println("Wrong username or password");
            System.out.println("Enter username: ");
            username = scanner.nextLine();
            System.out.println("Enter password: ");
            password = scanner.nextLine();
            user = login.authenticate(username, password);
        }

        System.out.println("Login successful!");

        switch (user) {
            case Owner owner -> {
                OwnerMenu ownerMenu = new OwnerMenu(productManager);
                ownerMenu.showMenu();
            }
            case Staff staff -> {
                StaffMenu staffMenu = new StaffMenu(productManager);
                staffMenu.showMenu();
            }
            case Customer customer -> {
                CustomerMenu customerMenu = new CustomerMenu(productManager, cartManager);
                customerMenu.showMenu();
            }
            default -> throw new IllegalStateException("Unexpected value: " + user);
        }
    }
}

