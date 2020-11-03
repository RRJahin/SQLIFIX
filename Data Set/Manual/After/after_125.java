public class Dummy{
public List<MessageBean> getMessagesFromNameDescending(long mid) throws SQLException, DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = (mid >= 999999999) ? conn.prepareStatement("SELECT message.* FROM message, patients WHERE message.to_id=patients.mid AND message.from_id=? ORDER BY patients.lastName DESC, patients.firstName DESC, message.sent_date DESC") : conn.prepareStatement("SELECT message.* FROM message, personnel WHERE message.to_id=personnel.mid AND message.from_id=? ORDER BY personnel.lastName DESC, personnel.firstName DESC, message.sent_date DESC")) {
        stmt.setObject(1, mid);
        ResultSet rs = stmt.executeQuery();
        List<MessageBean> messageList = this.mbLoader.loadList(rs);
        rs.close();
        return messageList;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

