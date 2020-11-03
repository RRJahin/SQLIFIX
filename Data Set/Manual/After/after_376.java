public class Dummy{
public static boolean insertCompetences(Connection connection, List<Competence> toAdd) throws SQLException {
    connection.setAutoCommit(false);
    PreparedStatement prepComp = connection.prepareStatement("INSERT OR REPLACE INTO ClassifiedCompetences (CompetenceText, Quality, Importance, Type, AdID) VALUES(?,?,?,?,?)");
    for (Competence competence : toAdd) {
        prepComp.setObject(1, competence.getCompetence());
        prepComp.setObject(2, competence.getQuality());
        prepComp.setObject(3, competence.getImportance());
        if (competence.getType() != null) {
            prepComp.setObject(4, competence.getType().toString());
        }
        prepComp.setObject(5, competence.getJobAdID());
        prepComp.executeUpdate();
        System.out.println("insert: " + competence);
    }
    if (prepComp != null)
        prepComp.close();
    connection.commit();
    return true;
}}

