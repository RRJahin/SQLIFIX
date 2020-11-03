public class Dummy{
public static boolean insertParagraphsInTestDB(Connection outputConnection, List<ClassifyUnit> results, int jobAdId) throws SQLException {
    boolean[] classIDs;
    int txtTblID;
    try {
        outputConnection.setAutoCommit(false);
        Statement stmt = outputConnection.createStatement();
        Statement prepTxtTbl = outputConnection.createStatement("INSERT OR REPLACE INTO ClassifiedParaTexts (ParaID,AdID,Text) VALUES(?,?,?)");
        Statement prepClfyOrig = outputConnection.createStatement("INSERT OR REPLACE INTO Classes_Original (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR) VALUES(?,?,?,?,?)");
        Statement prepClfyCorbl = outputConnection.createStatement("INSERT OR REPLACE INTO Classes_Correctable (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR, UseForTraining) VALUES(?,?,?,?,?,?)");
        for (ClassifyUnit cu : results) {
            prepTxtTbl.setString(1, cu.getID().toString());
            prepTxtTbl.setInt(2, jobAdId);
            prepTxtTbl.setString(3, cu.getContent());
            prepTxtTbl.executeUpdate();
            ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()");
            rs.next();
            txtTblID = rs.getInt(1);
            int booleanRpl;
            classIDs = ((ZoneClassifyUnit) cu).getClassIDs();
            prepClfyOrig.setInt(1, txtTblID);
            for (int classID = 0; classID <= 3; classID++) {
                if (classIDs[classID]) {
                    booleanRpl = 1;
                } else {
                    booleanRpl = 0;
                }
                prepClfyOrig.setInt(2 + classID, booleanRpl);
            }
            prepClfyOrig.executeUpdate();
            prepClfyCorbl.setInt(1, txtTblID);
            for (int classID = 0; classID <= 3; classID++) {
                if (classIDs[classID]) {
                    booleanRpl = 1;
                } else {
                    booleanRpl = 0;
                }
                prepClfyCorbl.setInt(2 + classID, booleanRpl);
            }
            prepClfyCorbl.setInt(6, 0);
            prepClfyCorbl.executeUpdate();
        }
        if (prepTxtTbl != null)
            prepTxtTbl.close();
        if (prepClfyOrig != null)
            prepClfyOrig.close();
        if (prepClfyCorbl != null)
            prepClfyCorbl.close();
        if (stmt != null)
            stmt.close();
        outputConnection.commit();
        return true;
    } catch (SQLException e) {
        outputConnection.rollback();
        e.printStackTrace();
        return false;
    }
}}

