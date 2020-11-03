class Dummy {
    @Override
    public Team getTeamByID(int i) {
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        String qry = "select LAST_NM from person where prsn_id = " + i;
        try {
            conn = this.dataSrc.getConnection();
            ps = conn.createStatement();
            rs = ps.executeQuery(qry);
            while (rs.next()) {
                Team t = new Team();
                t.setTeamID(i);
                t.setTeamName(rs.getString(1));
                return t;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
        return null;
    }
}
