public class Dummy{
public List<MessageBean> getCCdMessages(long refID) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM message WHERE original_msg_id="+refID);
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}
