import java.time.*;

public static void main(String[] args) {
    ClubDatabase clubDatabase = new ClubDatabase();

    StaffMember staffMember = new StaffMember(clubDatabase);
    Manager manager = new Manager(clubDatabase)
    LoginPortal loginPortal = new LoginPortal(clubDatabase);

    staffMember.addNewMember(101, "password", "Yared@gmail.com", "Yared", "Leake");
    staffMember.addNewMember(102, "password2", "Red@gmail.com", "Red", "Dot");

    staffMember.verifyCustomerMembership(101);
    staffMember.verifyCustomerMembership(102);

    loginPortal.verfiyLogin(101, "password");
    loginPortal.verfiyLogin(102, "password2");

    manager.generateReport();
}
