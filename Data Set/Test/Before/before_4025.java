class Dummy {
    public void updStud(String name, String lname, String patro, Date dob, int group, long id) {
        String sql = "UPDATE STUDENTS SET NAME = " + name + ", PATRONYMIC = " + patro + ", " + "DATE_OF_BIRTH = " + dob
                + ", GROUP_ID = (SELECT ID FROM GROUPS WHERE NUMBER = " + group + ") WHERE ID = " + id;
        Connection con = ConnectionSingleton.getInstance();
        try {
            Statement ps = con.createStatement();
            ps.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
