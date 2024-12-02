import java.time.LocalDate;

public class StaffMember {
    private ClubDatabase clubDatabase;

    public staffMember(ClubDatabase clubDatabase){
        this.clubDatabase = clubDatabase;
    }

    public int addNewMember(int UserID, String password, String email, String firstName, String LastName){
        Member newMember = new Member(UserID, password, email, firstName, LastName);
        clubDatabase.addUser(newMember);
        System.out.println("New member added: " + firstName + " " + lastName);
    }


    public int verifyCustomerMembership(int UserID){
        if(clubDatabase.members.containkey(UserID)){
            Clubdatabase.Member member = clubDatabase.members.get(UserID);
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