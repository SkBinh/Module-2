package users;

public class Owner extends User {
    public Owner(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        System.out.println("Owner Menu:");
    }
}
