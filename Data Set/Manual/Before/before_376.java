public class Dummy{
public static boolean insertCompetences(Connection connection, List<Competence> toAdd) throws SQLException {
    connection.setAutoCommit(false);
    Statement prepComp = connection.createStatement("INSERT OR REPLACE INTO ClassifiedCompetences (CompetenceText, Quality, Importance, Type, AdID) VALUES(?,?,?,?,?)");
    for (Competence competence : toAdd) {
        prepComp.setString(1, competence.getCompetence());
        prepComp.setString(2, competence.getQuality());
        prepComp.setString(3, competence.getImportance());
        if (competence.getType() != null) {
            prepComp.setString(4, competence.getType().toString());
        }
        prepComp.setInt(5, competence.getJobAdID());
        prepComp.executeUpdate();
        System.out.println("insert: " + competence);
    }
    if (prepComp != null)
        prepComp.close();
    connection.commit();
    return true;
}}

