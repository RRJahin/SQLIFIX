class Dummy{
private static void connectToDatabase(String usrDB, String passwordDB, String conDB, String trainName, String testName) throws SQLException, FileNotFoundException {
    File trainingOutput = new File(trainName);
    PrintWriter trainingPw = new PrintWriter(trainingOutput);
    StringBuilder sb = new StringBuilder();
    File testingOutput = new File(testName);
    PrintWriter testingPw = new PrintWriter(testingOutput);
    sb.append("@relation databasetraining" + "\n" + "\n" + "@attribute barcode numeric" + "\n" + "@attribute area numeric" + "\n" + "@attribute perimeter numeric" + "\n" + "@attribute circularity numeric" + "\n" + "@attribute compactness numeric" + "\n" + "@attribute major numeric" + "\n" + "@attribute minor numeric" + "\n" + "@attribute eccentricity numeric" + "\n" + "@attribute hisgreypeak numeric" + "\n" + "@attribute q1grey numeric" + "\n" + "@attribute q2grey numeric" + "\n" + "@attribute q3grey numeric" + "\n" + "@attribute q1r numeric" + "\n" + "@attribute q2r numeric" + "\n" + "@attribute q3r numeric" + "\n" + "@attribute q1g numeric" + "\n" + "@attribute q2g numeric" + "\n" + "@attribute q3g numeric" + "\n" + "@attribute q1b numeric" + "\n" + "@attribute q2b numeric" + "\n" + "@attribute q3b numeric" + "\n" + "@attribute das numeric" + "\n" + "@attribute Stage {'Stage 1','Stage 2','Stage 3','Stage 4', 'Stage 5'}" + "\n" + "\n" + "@data" + "\n");
    trainingPw.write(sb.toString());
    testingPw.write(sb.toString());
    try {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(conDB, usrDB, passwordDB);
        String trainingSql = "SELECT s.barcode, o.area, " + "o.perimeter, o.circularity, o.compactness, " + "o.major, o.minor, o.eccentricity, o.hisgreypeak, " + "o.q1grey, o.q2grey, o.q3grey, " + "o.q1r, o.q2r, o.q3r, " + "o.q1g, o.q2g, o.q3g, " + "o.q1b, o.q2b, o.q3b, d.das, " + "CASE WHEN ( d.das <= 10 ) THEN 'Stage 1' " + "WHEN ( d.das > 10 AND d.das <= 20 ) THEN 'Stage 2' " + "WHEN ( d.das > 20 AND d.das <= 30 ) THEN 'Stage 3' " + "WHEN ( d.das > 30 AND d.das <= 40 ) THEN 'Stage 4' " + "WHEN ( d.das > 40 AND d.das <= 50 ) THEN 'Stage 5' " + "ELSE 'Stage 6' END Stage " + "FROM imageev AS i, imgobjectev AS o, soyidentification AS s, dasplusev AS d " + "WHERE i.assayid = o.assayid " + "AND i.imgid = o.imgid " + "AND s.barcode = ( CAST( i.barcode AS INTEGER ) ) " + "AND i.assayid = d.assayid AND i.fdate = d.fdate " + "AND i.set = d.set " + "AND s.line = 1 " + "AND i.camera = 'vis-side-1-0' " + "AND i.set = '3'";
        String testingSql = "SELECT s.barcode, o.area, " + "o.perimeter, o.circularity, o.compactness, " + "o.major, o.minor, o.eccentricity, o.hisgreypeak, " + "o.q1grey, o.q2grey, o.q3grey, " + "o.q1r, o.q2r, o.q3r, " + "o.q1g, o.q2g, o.q3g, " + "o.q1b, o.q2b, o.q3b, d.das, " + "CASE WHEN ( d.das <= 10 ) THEN 'Stage 1' " + "WHEN ( d.das > 10 AND d.das <= 20 ) THEN 'Stage 2' " + "WHEN ( d.das > 20 AND d.das <= 30 ) THEN 'Stage 3' " + "WHEN ( d.das > 30 AND d.das <= 40 ) THEN 'Stage 4' " + "WHEN ( d.das > 40 AND d.das <= 50 ) THEN 'Stage 5' " + "ELSE 'Stage 6' END Stage " + "FROM imageev AS i, imgobjectev AS o, soyidentification AS s, dasplusev AS d " + "WHERE i.assayid = o.assayid " + "AND i.imgid = o.imgid " + "AND s.barcode = ( CAST( i.barcode AS INTEGER ) ) " + "AND i.assayid = d.assayid " + "AND i.fdate = d.fdate " + "AND i.set = d.set " + "AND ( s.line = 1 OR s.line = 2 OR s.line = 3 ) " + "AND i.camera = 'vis-side-1-0' " + "AND i.set = '2' " + "UNION " + "SELECT s.barcode, o.area, o.perimeter, o.circularity, " + "o.compactness, o.major, o.minor, o.eccentricity, o.hisgreypeak, " + "o.q1grey, o.q2grey, o.q3grey, " + "o.q1r, o.q2r, o.q3r," + " o.q1g, o.q2g, o.q3g, " + "o.q1b, o.q2b, o.q3b, d.das, " + "CASE WHEN ( d.das <= 10 ) THEN 'Stage 1' " + "WHEN ( d.das > 10 AND d.das <= 20 ) THEN 'Stage 2' " + "WHEN ( d.das > 20 AND d.das <= 30 ) THEN 'Stage 3' " + "WHEN ( d.das > 30 AND d.das <= 40 ) THEN 'Stage 4' " + "WHEN ( d.das > 40 AND d.das <= 50 ) THEN 'Stage 5' " + "ELSE 'Stage 6' END Stage " + "FROM imageev AS i, imgobjectev AS o, soyidentification AS s, dasplusev AS d " + "WHERE i.assayid = o.assayid " + "AND i.imgid = o.imgid " + "AND s.barcode = ( CAST( i.barcode AS INTEGER ) ) " + "AND i.assayid = d.assayid " + "AND i.fdate = d.fdate " + "AND i.set = d.set " + "AND (s.line = 2 OR s.line = 3 ) " + "AND i.camera = 'vis-side-1-0' " + "AND i.set = '3' ";
        Statement trainingPs = conn.createStatement();
        ResultSet trainingSet = trainingPs.executeQuery(trainingSql);
        while (trainingSet.next()) {
            Double barcode = trainingSet.getDouble("barcode");
            Double area = trainingSet.getDouble("area");
            Double perimeter = trainingSet.getDouble("perimeter");
            Double circularity = trainingSet.getDouble("circularity");
            Double compactness = trainingSet.getDouble("compactness");
            Double major = trainingSet.getDouble("major");
            Double minor = trainingSet.getDouble("minor");
            Double eccentricity = trainingSet.getDouble("eccentricity");
            Double hisgreypeak = trainingSet.getDouble("hisgreypeak");
            Double q1grey = trainingSet.getDouble("q1grey");
            Double q2grey = trainingSet.getDouble("q2grey");
            Double q3grey = trainingSet.getDouble("q3grey");
            Double q1r = trainingSet.getDouble("q1r");
            Double q2r = trainingSet.getDouble("q2r");
            Double q3r = trainingSet.getDouble("q3r");
            Double q1g = trainingSet.getDouble("q1g");
            Double q2g = trainingSet.getDouble("q2g");
            Double q3g = trainingSet.getDouble("q3g");
            Double q1b = trainingSet.getDouble("q1b");
            Double q2b = trainingSet.getDouble("q2b");
            Double q3b = trainingSet.getDouble("q3b");
            Double das = trainingSet.getDouble("das");
            String stage = trainingSet.getString("Stage");
            trainingPw.write(barcode + "," + area + ", " + perimeter + ", " + circularity + ", " + compactness + ", " + major + ", " + minor + ", " + eccentricity + ", " + hisgreypeak + ", " + q1grey + ", " + q2grey + ", " + q3grey + ", " + q1r + ", " + q2r + ", " + q3r + ", " + q1g + ", " + q2g + ", " + q3g + ", " + q1b + ", " + q2b + ", " + q3b + "," + das + "," + "'" + stage + "'" + "\n");
        }
        trainingSet.close();
        trainingPw.close();
        Statement testingPs = conn.createStatement();
        ResultSet testingSet = testingPs.executeQuery(testingSql);
        while (testingSet.next()) {
            Double barcode = testingSet.getDouble("barcode");
            Double area = testingSet.getDouble("area");
            Double perimeter = testingSet.getDouble("perimeter");
            Double circularity = testingSet.getDouble("circularity");
            Double compactness = testingSet.getDouble("compactness");
            Double major = testingSet.getDouble("major");
            Double minor = testingSet.getDouble("minor");
            Double eccentricity = testingSet.getDouble("eccentricity");
            Double hisgreypeak = testingSet.getDouble("hisgreypeak");
            Double q1grey = testingSet.getDouble("q1grey");
            Double q2grey = testingSet.getDouble("q2grey");
            Double q3grey = testingSet.getDouble("q3grey");
            Double q1r = testingSet.getDouble("q1r");
            Double q2r = testingSet.getDouble("q2r");
            Double q3r = testingSet.getDouble("q3r");
            Double q1g = testingSet.getDouble("q1g");
            Double q2g = testingSet.getDouble("q2g");
            Double q3g = testingSet.getDouble("q3g");
            Double q1b = testingSet.getDouble("q1b");
            Double q2b = testingSet.getDouble("q2b");
            Double q3b = testingSet.getDouble("q3b");
            Double das = testingSet.getDouble("das");
            String stage = testingSet.getString("Stage");
            testingPw.write(barcode + "," + area + ", " + perimeter + ", " + circularity + ", " + compactness + ", " + major + ", " + minor + ", " + eccentricity + ", " + hisgreypeak + ", " + q1grey + ", " + q2grey + ", " + q3grey + ", " + q1r + ", " + q2r + ", " + q3r + ", " + q1g + ", " + q2g + ", " + q3g + ", " + q1b + ", " + q2b + ", " + q3b + "," + das + "," + "'" + stage + "'" + "\n");
        }
        testingSet.close();
        testingPw.close();
        conn.close();
    } catch (ClassNotFoundException e) {
        System.out.println("Improper database connection set-up.");
        e.printStackTrace();
    }
}}

