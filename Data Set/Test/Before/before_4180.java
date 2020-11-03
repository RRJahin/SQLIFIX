class Dummy{
private List<ColumnMetadata> reflectColumns(TableMetadata tbl, Connection conn) throws SQLException {
    String query = "SELECT column_name, data_type " + "FROM information_schema.columns " + "WHERE table_name = '" + tbl.getTableName() + "'" + "AND table_schema = '" + tbl.getSchemaName() + "'";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    List<ColumnMetadata> columnMetadataList = new ArrayList<>();
    while (rs.next()) {
        columnMetadataList.add(new ColumnMetadata(tbl, rs.getString("column_name"), rs.getString("data_type")));
    }
    return columnMetadataList;
}}

