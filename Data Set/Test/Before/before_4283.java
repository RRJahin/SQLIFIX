class Dummy{
public int addItem(String name, int price) throws DAOException {
    if (con == null)
        getConnection();
    Statement st = null;
    try {
        String sql = "INSERT INTO item(name,price)VALUES("+name+","+price+")";
        st = con.createStatement();
        int rows = st.executeUpdate(sql);
        return rows;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (st != null)
                st.close();
            close();
        } catch (Exception e) {
            throw new DAOException("__");
        }
    }
}}

