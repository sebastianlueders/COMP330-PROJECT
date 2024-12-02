import java.time.*;
import java.util.*;

public class ClubDatabase {

    static class Member {

    int userID;
    String password;
    String email;
    String firstName;
    String lastName;

    LocalDate() dateOfLastEntry;

    LocalDate() dateOfExpiration;

    int totalVisits;
    int privilegeLevel;



    public Member(int userID, String password, String email, String firstName, String lastName) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfLastEntry = LocalDate.now();
        this.dateOfExpiration = LocalDate.now().plusDays(365);
        this.totalVisits = 0;
        this.privilegeLevel = 0;
    }

    Map<Integer, Member> users = new HashMap<>();

    public users getUser(int userID, String password) {
        Person user = users.get(userID);
        if (user != null && (password.isEmpty() || user.getPassword().equals(password))) {
            return user;
        }
        return null;
    }

    public void addUser(Member user) {
        users.put(user.getUserID(), user);
    }
}