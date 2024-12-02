

public class Manager extends StaffMember {
// Call the parent class (StaffMember) constructor
    public Manager() {
        
    }

    public void generateReport(int reportType) {
        switch (reportType) {
            case 1:
                System.out.println("Report generated: List of all members.");
                break;
            case 2:
                System.out.println("Report generated: List of expired memberships.");
                break;
            case 3:
                System.out.println("Report generated: Total visits by all members.");
                break;
            default:
                System.out.println("Invalid report type. Please select a valid option.");
        }
    }

}