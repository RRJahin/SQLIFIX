public class Dummy{
public static boolean insertParagraphsInTestDB(Connection outputConnection, List<ClassifyUnit> results, int jobAdId) throws SQLException {
    boolean[] classIDs;
    int txtTblID;
    try {
        outputConnection.setAutoCommit(false);
    PreparedStatement stmt = outputConnection.prepareStatement("SELECT last_insert_rowid()");
        PreparedStatement prepTxtTbl = outputConnection.prepareStatement("INSERT OR REPLACE INTO ClassifiedParaTexts (ParaID,AdID,Text) VALUES(?,?,?)");
        PreparedStatement prepClfyOrig = outputConnection.prepareStatement("INSERT OR REPLACE INTO Classes_Original (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR) VALUES(?,?,?,?,?)");
        PreparedStatement prepClfyCorbl = outputConnection.prepareStatement("INSERT OR REPLACE INTO Classes_Correctable (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR, UseForTraining) VALUES(?,?,?,?,?,?)");
        for (ClassifyUnit cu : results) {
            prepTxtTbl.setObject(1, cu.getID().toString());
            prepTxtTbl.setObject(2, jobAdId);
            prepTxtTbl.setObject(3, cu.getContent());
            prepTxtTbl.executeUpdate();
            ResultSet rs = stmt.executeQuery();
            rs.next();
            txtTblID = rs.getInt(1);
            int booleanRpl;
            classIDs = ((ZoneClassifyUnit) cu).getClassIDs();
            prepClfyOrig.setObject(1, txtTblID);
            for (int classID = 0; classID <= 3; classID++) {
                if (classIDs[classID]) {
                    booleanRpl = 1;
                } else {
                    booleanRpl = 0;
                }
                prepClfyOrig.setObject(2 + classID, booleanRpl);
            }
            prepClfyOrig.executeUpdate();
            prepClfyCorbl.setObject(1, txtTblID);
            for (int classID = 0; classID <= 3; classID++) {
                if (classIDs[classID]) {
                    booleanRpl = 1;
                } else {
                    booleanRpl = 0;
                }
                prepClfyCorbl.setObject(2 + classID, booleanRpl);
            }
            prepClfyCorbl.setObject(6, 0);
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

