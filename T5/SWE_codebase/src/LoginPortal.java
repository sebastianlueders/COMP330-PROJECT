import java.util.Scanner;

public class LoginPortal {

    private ClubDatabase clubDatabase;


    public LoginPortal(ClubDatabase clubDatabase) {
        this.clubDatabase = clubDatabase;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Club Login Portal ===");
        System.out.print("Enter your User ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Object user = clubDatabase.getUser(userID, password);
        if (user != null) {
            System.out.println("Login successful for User ID: " + userID);
            if (user instanceof StaffMember) {
                System.out.println("Welcome, Staff Member!");
            } else if (user instanceof Manager) {
                System.out.println("Welcome, Manager!");
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
        


    
}