public class Dummy{
public void setSecurityQuestionAnswer(final String question, final String answer, final long mid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        stmt.executeUpdate("UPDATE users SET sQuestion = "+question+", sAnswer = "+answer+" WHERE MID = "+mid);
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

