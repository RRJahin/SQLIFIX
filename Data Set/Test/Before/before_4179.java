class Dummy{
private List<TableMetadata> reflectTables(Connection conn) throws SQLException {
    String query = "SELECT table_schema, table_name " + "FROM information_schema.tables " + "WHERE table_schema NOT IN ('information_schema', 'pg_catalog')";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    List<TableMetadata> tableMetadataList = new ArrayList<>();
    while (rs.next()) {
        tableMetadataList.add(new TableMetadata(rs.getString("table_schema"), rs.getString("table_name")));
    }
    rs.close();
    stmt.close();
    conn.close();
    return tableMetadataList;
}}

