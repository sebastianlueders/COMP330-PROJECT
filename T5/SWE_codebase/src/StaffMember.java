import java.time.LocalDate;

public class StaffMember {
    private ClubDatabase clubDatabase;

    public StaffMember(ClubDatabase clubDatabase) {
        this.clubDatabase = clubDatabase;
    }

    // Existing methods
    public void addNewMember(int userID, String password, String email, String firstName, String lastName, int privilegeLevel) {
        if (clubDatabase.users.containsKey(userID)) {
            System.out.println("User ID " + userID + " already exists. Cannot add duplicate member.");
            return;
        }
        ClubDatabase.Member newMember = new ClubDatabase.Member(userID, password, email, firstName, lastName, privilegeLevel);
        clubDatabase.users.put(userID, newMember);
        System.out.println("New member added: " + firstName + " " + lastName);
    }

    public void verifyCustomerMembership(int userID) {
        if (clubDatabase.users.containsKey(userID)) {
            ClubDatabase.Member member = clubDatabase.users.get(userID);
            if (member.dateOfExpiration.isAfter(LocalDate.now())) {
                System.out.println("Membership is valid for " + member.firstName);
            } else {
                System.out.println("Membership is expired for " + member.firstName);
            }
        } else {
            System.out.println("User ID not found or not a member.");
        }
    }

    // New methods based on UML
    public void checkForExpiredMembership(int userID) {
        if (clubDatabase.users.containsKey(userID)) {
            ClubDatabase.Member member = clubDatabase.users.get(userID);
            if (member.dateOfExpiration.isBefore(LocalDate.now())) {
                System.out.println("Membership for " + member.firstName + " " + member.lastName + " has expired.");
            } else {
                System.out.println("Membership for " + member.firstName + " " + member.lastName + " is active.");
            }
        } else {
            System.out.println("User ID not found.");
        }
    }

    public void renewMembership(int userID, int duration) {
        if (clubDatabase.users.containsKey(userID)) {
            ClubDatabase.Member member = clubDatabase.users.get(userID);
            member.dateOfExpiration = member.dateOfExpiration.plusDays(duration);
            System.out.println("Membership for " + member.firstName + " " + member.lastName + " has been renewed for " + duration + " days.");
        } else {
            System.out.println("User ID not found. Cannot renew membership.");
        }
    }

    public void removeUser(int userID) {
        if (clubDatabase.users.containsKey(userID)) {
            clubDatabase.users.remove(userID);
            System.out.println("User with ID " + userID + " has been removed.");
        } else {
            System.out.println("User ID not found.");
        }
    }

    public void sendRenewalNotices() {
        System.out.println("=== Renewal Notices ===");
        for (ClubDatabase.Member member : clubDatabase.users.values()) {
            if (member.dateOfExpiration.isBefore(LocalDate.now().plusDays(7)) && member.dateOfExpiration.isAfter(LocalDate.now())) {
                System.out.println("Reminder: Membership for " + member.firstName + " " + member.lastName + " is expiring on " + member.dateOfExpiration + ".");
            }
        }
    }
}
