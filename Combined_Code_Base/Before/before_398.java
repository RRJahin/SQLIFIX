public class Dummy{
public static boolean insertParagraphsInBIBBDB(Connection outputConnection, List<ClassifyUnit> results, int jahrgang, int zeilennummer) throws SQLException {
    boolean[] classIDs;
    int txtTblID;
    try {
        outputConnection.setAutoCommit(false);
        Statement stmt = outputConnection.createStatement();
        Statement prepTxtTbl = outputConnection.createStatement("INSERT INTO ClassifiedParaTexts (ParaID,jahrgang,ZEILENNR,STELLENBESCHREIBUNG) VALUES(?,?,?,?)");
        Statement prepClfyOrig = outputConnection.createStatement("INSERT INTO Classes_Original (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR) VALUES(?,?,?,?,?)");
        Statement prepClfyCorbl = outputConnection.createStatement("INSERT INTO Classes_Correctable (TxtID,ClassONE,ClassTWO,ClassTHREE,ClassFOUR, UseForTraining) VALUES(?,?,?,?,?,?)");
        for (ClassifyUnit cu : results) {
            prepTxtTbl.setString(1, cu.getID().toString());
            prepTxtTbl.setInt(2, jahrgang);
            prepTxtTbl.setInt(3, zeilennummer);
            prepTxtTbl.setString(4, cu.getContent());
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

