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
                displayStaffMenu((StaffMember) user);
            } else if (user instanceof Manager) {
                System.out.println("Welcome, Manager!");
                // Manager menu can be implemented here
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private void displayStaffMenu(StaffMember staff) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Staff Member Menu ---");
            System.out.println("1. Add New Member");
            System.out.println("2. Verify Membership");
            System.out.println("3. Check Expired Memberships");
            System.out.println("4. Renew Membership");
            System.out.println("5. Remove User");
            System.out.println("6. Send Renewal Notices");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Privilege Level (1 for Staff, 2 for Manager): ");
                    int privilegeLevel = scanner.nextInt();
                    staff.addNewMember(userID, password, email, firstName, lastName, privilegeLevel);
                    break;
                case 2:
                    System.out.print("Enter User ID to verify: ");
                    userID = scanner.nextInt();
                    staff.verifyCustomerMembership(userID);
                    break;
                case 3:
                    System.out.print("Enter User ID to check expiration: ");
                    userID = scanner.nextInt();
                    staff.checkForExpiredMembership(userID);
                    break;
                case 4:
                    System.out.print("Enter User ID to renew: ");
                    userID = scanner.nextInt();
                    System.out.print("Enter duration in days: ");
                    int duration = scanner.nextInt();
                    staff.renewMembership(userID, duration);
                    break;
                case 5:
                    System.out.print("Enter User ID to remove: ");
                    userID = scanner.nextInt();
                    staff.removeUser(userID);
                    break;
                case 6:
                    staff.sendRenewalNotices();
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
