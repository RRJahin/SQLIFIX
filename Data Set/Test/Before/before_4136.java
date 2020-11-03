class Dummy{
public List<ClassifyUnit> getCategorizedASCIIParagraphsFromDB(Connection inputConnection, boolean executeAtBIBB) throws ClassNotFoundException, SQLException {
    List<ClassifyUnit> toReturn = new ArrayList<ClassifyUnit>();
    Statement stmt = inputConnection.createStatement();
    String sql = "SELECT txtID, ClassONE, ClassTWO, ClassTHREE, ClassFOUR  FROM Classes_Correctable WHERE UseForTraining = 1";
    ResultSet result = stmt.executeQuery(sql);
    ClassifyUnit cu;
    while (result.next()) {
        int txtID = result.getInt(1);
        if (executeAtBIBB) {
            sql = "SELECT STELLENBESCHREIBUNG FROM ClassifiedParaTexts WHERE ID = " + txtID + ";";
        } else {
            sql = "SELECT Text FROM ClassifiedParaTexts WHERE ID = " + txtID + ";";
        }
        Statement stmt2 = inputConnection.createStatement();
        ResultSet paraText = stmt2.executeQuery(sql);
        String content = paraText.getString(1);
        int parentID = -1;
        boolean[] classIDs = new boolean[stmc.getNumberOfCategories()];
        for (int i = 0; i < stmc.getNumberOfCategories(); i++) {
            classIDs[i] = parseIntToBool(result.getInt(2 + i));
        }
        int actualClassID = getActualClassID(classIDs);
        ZoneClassifyUnit.setNumberOfCategories(stmc.getNumberOfCategories(), stmc.getNumberOfClasses(), stmc.getTranslations());
        cu = new JASCClassifyUnit(EncodingProblemTreatment.normalizeEncoding(content), parentID);
        ((ZoneClassifyUnit) cu).setActualClassID(actualClassID);
        toReturn.add(cu);
    }
    return toReturn;
}}

