class Dummy{
private String getPrimaryKey(Connection conn, String tableName) {
    String sql = "select k.column_name FROM information_schema.table_constraints t\n" + "JOIN information_schema.key_column_usage k\n" + "USING (constraint_name,table_name)\n" + "WHERE t.constraint_type='PRIMARY KEY'\n" + "  AND t.table_name='" + tableName + "'";
    String result = "";
    try {
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            result = res.getString(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}}

