import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;

public class ClubDatabase {
    private HashMap<Integer, Person> users;

    public ClubDatabase() {
        users = new HashMap<>();
        addUser(new Member(100, "", "reddd@gmail.com", "reddd", "Leake"));
        addUser(new Member(101, "", "Jared@gmail.com", "Jared", "Da Coolest"));
        addUser(new Staff(102, "staff", "RED@gmail.com", "Red", "Dot"));
        addUser(new Manager(103, "manager", "YaredLeake@gmail.com", "Yared", "Leake"));
    }

    public void addUser(Person user) {
        users.put(user.getUserID(), user);
    }

    public Person getUser(int userID, String password) {
        Person user = users.get(userID);
        if (user != null && (password.isEmpty() || user.getPassword().equals(password))) {
            return user;
        }
        return null;
    }

    public List<Person> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}

