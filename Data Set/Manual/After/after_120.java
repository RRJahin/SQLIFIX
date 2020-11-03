public class Dummy{
public List<MessageBean> getMessagesNameAscending(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = (mid >= 999999999) ? conn.prepareStatement("SELECT message.* FROM message, patients WHERE message.from_id=patients.mid AND message.to_id=? ORDER BY patients.lastName ASC, patients.firstName ASC, message.sent_date ASC") : conn.prepareStatement("SELECT message.* FROM message, personnel WHERE message.from_id=personnel.mid AND message.to_id=? ORDER BY personnel.lastName ASC, personnel.firstName ASC, message.sent_date ASC")) {
        stmt.setObject(1, mid);
        ResultSet rs = stmt.executeQuery();
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

