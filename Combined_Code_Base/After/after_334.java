public class Dummy{
public void setSecurityQuestionAnswer(final String question, final String answer, final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE users SET sQuestion = ?, sAnswer = ? WHERE MID = ?")) {
        stmt.setObject(1, question);
        stmt.setObject(2, answer);
        stmt.setObject(3, mid);
        stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

