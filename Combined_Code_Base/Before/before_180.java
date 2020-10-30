public class Dummy {
    @Override
    public List<Guitar> searchGuitar(String type) {
        Connection Conn = MySqlDBUtil.open();
        String sql = "select * from guitar where type= " + type;
        List<Guitar> listguitar = new ArrayList<Guitar>();
        try {
            Statement pstmt = Conn.createStatement();
            ResultSet rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                Guitar guitar = new Guitar();
                guitar.setSerialNumber(rs.getString(1));
                guitar.setPrice(rs.getString(2));
                guitar.setBuilder(rs.getString(3));
                guitar.setType(type);
                guitar.setBackWood(rs.getString(5));
                guitar.setTopWood(rs.getString(6));
                listguitar.add(guitar);
            }
            return listguitar;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlDBUtil.close(Conn);
        }
        return null;
    }
}
