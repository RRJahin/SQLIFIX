public class Dummy{
public List<MessageBean> getMessagesTimeAscending(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM message WHERE to_id = "+mid+" ORDER BY sent_date ASC");
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

