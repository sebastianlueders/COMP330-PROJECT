import java.time.*;
import java.util.*;

public class ClubDatabase {

    Map<Integer, Member> users = new HashMap<>();

    static class Member {

        int userID;
        String password;
        String email;
        String firstName;
        String lastName;

        LocalDate dateOfLastEntry;

        LocalDate dateOfExpiration;

        int totalVisits;
        int privilegeLevel;



        public Member(int userID, String password, String email, String firstName, String lastName) {
            this.userID = userID;
            this.password = password;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfLastEntry = LocalDate.now();
            this.dateOfExpiration = LocalDate.now().plusDays(90);
            this.totalVisits = 0;
            this.privilegeLevel = 0;
        }






    }

    // Retrieve user info from database
    public users getUser(int userID, String password) {
        Member user = users.get(userID);
        if (user != null && user.password.equals(password)) {
            if(user.privilegeLevel == 1) {
                return new StaffMember();
            } else if (user.privilegeLevel == 2) {
                return new Manager();
            };
        }
        return null;
    }

    // Initializing database with smart userIDs
    public ClubDatabase() {
        
        users.put(101, new Member(101, "password", "Yared@gmail.com", "Yared", "Leake", 1));
        users.put(102, new Member(102, "password2", "Red@gmail.com", "Red", "Dot", 2));

    }

}