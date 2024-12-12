package services;

import users.User;
import users.Owner;
import users.Staff;
import users.Customer;

import java.util.HashMap;
import java.util.Map;

public class Login {

    private static Login instance;
    private Map<String, String> credentials;

    public Login() {
        credentials = new HashMap<>();
        loadCredentials();
    }

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    private void loadCredentials() {
        credentials.put("owner1", "ownerpass");
        credentials.put("staff1", "staffpass");
        credentials.put("customer1", "customerpass");
    }

    public User authenticate(String username, String password) {
        if (Validation.isValidUsername(username) && Validation.isValidPassword(password)) {
            if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                if (username.startsWith("owner")) {
                    return new Owner(username, password);
                } else if (username.startsWith("staff")) {
                    return new Staff(username, password);
                } else if (username.startsWith("customer")) {
                    return new Customer(username, password);
                }
            }
        }
        return null;
    }
}
