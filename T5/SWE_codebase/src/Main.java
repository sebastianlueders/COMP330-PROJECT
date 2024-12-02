


public class Main {

public static void main(String args[]) {
    
    ClubDatabase database = new ClubDatabase();

    LoginPortal login = new LoginPortal(database);

    LoginPortal.login();
}

}