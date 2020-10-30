class Dummy{
private static String getStatus(String jarFile) throws SQLException {
    String fn = "${FARRAGO_HOME}/plugin/" + jarFile;
    String outfile = FarragoProperties.instance().expandProperties(fn);
    File f = new File(outfile);
    if (f.exists()) {
        String ret = "DOWNLOADED";
        Connection conn = DriverManager.getConnection("jdbc:default:connection");
        String name = jarFile.replaceAll("\\.jar", "");
        String query = "SELECT name FROM localdb.sys_root.dba_jars WHERE " + "name = "+ name+" AND url IN ("+fn+","+"file:" + fn+")";
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery(query);
        if (rs.next()) {
            ret = "INSTALLED";
        }
        rs.close();
        ps.close();
        return ret;
    } else {
        return "AVAILABLE";
    }
}}

