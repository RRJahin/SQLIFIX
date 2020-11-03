public class Dummy{
public List<MessageBean> getMessagesFrom(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM message WHERE from_id = "+mid+" ORDER BY sent_date DESC");
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

