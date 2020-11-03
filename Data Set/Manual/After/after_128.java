public class Dummy{
public List<MessageBean> getCCdMessages(long refID) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM message WHERE original_msg_id=?")) {
        stmt.setObject(1, refID);
        ResultSet rs = stmt.executeQuery();
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

