import java.time.LocalDate;

public class StaffMember {
    private ClubDatabase clubDatabase;

    public StaffMember(ClubDatabase clubDatabase){
        this.clubDatabase = clubDatabase;
    }

    public void addNewMember(int userID, String password, String email, String firstName, String lastName, int privilegeLevel) {
        if (clubDatabase.users.containsKey(userID)) {
            System.out.println("User ID " + userID + " already exists. Cannot add duplicate member.");
            return;
        }
        ClubDatabase.Member newMember = new ClubDatabase.Member(userID, password, email, firstName, lastName, privilegeLevel);
        clubDatabase.users.put(userID, newMember);
        System.out.println("New member added: " + firstName + " " + lastName);
    }


    public void verifyCustomerMembership(int UserID){
        if(clubDatabase.users.containsKey(UserID)){
            ClubDatabase.Member member = clubDatabase.users.get(UserID);
            if(member.dateOfExpiration.isAfter(LocalDate.now())){
                System.out.println("Membership is valid for " + member.firstName);
            }
            else{
                System.out.println("Membership is expired for " + member.firstName);
            }
        }
        else{
            System.out.println("User ID not found or not a member.");
        }
    }


//    private int checkForExpiredMembership(int UserID){}
//    private int recordEntry(int UserID){}
//    private int renewMembership(int UserID, int duration){}
//    private int updateUserInfo(int UserID){}
//    private int updateFieldName(int UserID){}
//    private int updateUserInfo(int UserID){}



    
}