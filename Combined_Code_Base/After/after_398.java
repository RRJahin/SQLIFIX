public class Dummy{
public static boolean insertParagraphsInBIBBDB(Connection outputConnection, List<ClassifyUnit> results, int jahrgang, int zeilennummer) throws SQLException {
    boolean[] classIDs;
    int txtTblID;
    try {
        outputConnection.setAutoCommit(false);
    PreparedStatement stmt = outputConnection.prepareStatement("SELECT last_insert_rowid()");
        PreparedStatement prepTxtTbl = outputConnection.prepareStatement("INSERT INTO ClassifiedParaTexts (ParaID,jahrgang,ZEILENNR,STELLENBESCHREIBUNG) VALUES(?,?,?,?)");
        PreparedStatement prepClfyOrig = outputConnection.prepareStatement("INSERT INTO Classes_Original (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR) VALUES(?,?,?,?,?)");
        PreparedStatement prepClfyCorbl = outputConnection.prepareStatement("INSERT INTO Classes_Correctable (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR, UseForTraining) VALUES(?,?,?,?,?,?)");
        for (ClassifyUnit cu : results) {
            prepTxtTbl.setObject(1, cu.getID().toString());
            prepTxtTbl.setObject(2, jahrgang);
            prepTxtTbl.setObject(3, zeilennummer);
            prepTxtTbl.setObject(4, cu.getContent());
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
        prepTxtTbl.close();
        prepClfyOrig.close();
        prepClfyCorbl.close();
        stmt.close();
        outputConnection.commit();
        return true;
    } catch (SQLException e) {
        outputConnection.rollback();
        e.printStackTrace();
        return false;
    }
}}

