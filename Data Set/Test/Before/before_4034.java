class Dummy {
    public void addStud(String name, String lname, String patro, Date dob, int group) {
        String sql = "INSERT INTO STUDENTS (NAME," + " LASTNAME, PATRONYMIC, DATE_OF_BIRTH,GROUP_ID )VALUES (" + name
                + ", " + lname + ", " + patro + ", " + dob + ", " + "(SELECT ID FROM GROUPS WHERE NUMBER = " + group
                + ")";
        Connection con = ConnectionSingleton.getInstance();
        try {
            Statement ps = con.createStatement();
            ps.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
