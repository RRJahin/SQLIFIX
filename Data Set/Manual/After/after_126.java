public class Dummy{
public void updateRead(MessageBean mBean) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE message SET been_read=1 WHERE message_id=?")) {
        stmt.setObject(1, mBean.getMessageId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

