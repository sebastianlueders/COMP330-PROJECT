static public main {
    ClubDatabase clubDatabase = new ClubDatabase();
    new LoginPortal(clubDatabase);
    LoginPage loginPage = new LoginPage(clubDatabase);
}