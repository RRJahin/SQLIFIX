public class Dummy{
public void updateRead(MessageBean mBean) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("UPDATE message SET been_read=1 WHERE message_id="+mBean.getMessageId());
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

