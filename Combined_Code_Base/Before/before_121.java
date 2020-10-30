public class Dummy{
public List<MessageBean> getMessagesNameDescending(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.setLong(1, mid);
        ResultSet rs = (mid >= 999999999) ? stmt.executeQuery("SELECT message.* FROM message, patients WHERE message.from_id=patients.mid AND message.to_id="+mid+" ORDER BY patients.lastName DESC, patients.firstName DESC, message.sent_date DESC"):stmt.executeQuery("SELECT message.* FROM message, personnel WHERE message.from_id=personnel.mid AND message.to_id="+mid+" ORDER BY personnel.lastName DESC, personnel.firstName DESC, message.sent_date DESC");
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

