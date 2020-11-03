public class Dummy{
public List<MessageBean> getMessagesFromNameAscending(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = (mid >= 999999999) ? stmt.executeQuery("SELECT message.* FROM message, patients WHERE message.to_id=patients.mid AND message.from_id="+mid+" ORDER BY patients.lastName ASC, patients.firstName ASC, message.sent_date ASC") : stmt.executeQuery("SELECT message.* FROM message, personnel WHERE message.to_id=personnel.mid AND message.from_id="+mid+" ORDER BY personnel.lastName ASC, personnel.firstName ASC, message.sent_date ASC");
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

