class Dummy{
public List<ItemBean> findByPrice(int lePrice) throws DAOException {
    if (con == null)
        ;
    getConnection();
    Statement st = null;
    ResultSet rs = null;
    try {
        String sql = "SELECT * FROM item WHERE price<="+lePrice;
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<ItemBean> list = new ArrayList<ItemBean>();
        while (rs.next()) {
            int code = rs.getInt("code");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            ItemBean bean = new ItemBean(code, name, price);
            list.add(bean);
        }
        return list;
    } catch (Exception e) {
        e.printStackTrace();
        throw new DAOException("--");
    } finally {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            close();
        } catch (Exception e) {
            throw new DAOException("--");
        }
    }
}}

