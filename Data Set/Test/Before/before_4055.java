class Dummy {
    public static InputStream getTenantConfig(Properties PropertiesFile, String tenantName) throws Exception {
        InputStream tenantConfig;
        Connection connection = null;
        final String dbUrl = PropertiesFile.getProperty("databaseUrl");
        final String jdbcDriver = PropertiesFile.getProperty("jdbcDriver");
        final String username = PropertiesFile.getProperty("username");
        final String password = PropertiesFile.getProperty("password");
        Class.forName(jdbcDriver);
        connection = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = connection.createStatement();
        String sql = "select * from CS_TENANT where TENANT_NAME='" + tenantName + "';";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        tenantConfig = rs.getBlob("TENANT_CONFIG").getBinaryStream();
        return tenantConfig;
    }
}
