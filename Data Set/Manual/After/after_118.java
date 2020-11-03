public class Dummy{
public List<MessageBean> getMessagesForMID(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM message WHERE to_id = ? ORDER BY sent_date DESC")) {
        stmt.setObject(1, mid);
        ResultSet rs = stmt.executeQuery();
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

