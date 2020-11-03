class Dummy {
    public long getStudIdForUpd(String name, String lname, String patro, Date dob, int groupNum) {
        String sql = "SELECT ID FROM STUDENTS WHERE NAME = " + name + " AND PATRONYMIC =  " + patro
                + "AND DATE_OF_BIRTH = " + dob + " AND GROUP_ID = (SELECT ID FROM GROUPS WHERE NUMBER = " + groupNum
                + ")";
        Connection con = ConnectionSingleton.getInstance();
        long result = 0;
        ResultSet rs = null;
        try {
            Statement ps = con.createStatement();
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                result = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
