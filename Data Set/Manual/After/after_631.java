class Dummy{
public static BasisInfo getInfo(BasisInfo bi) throws SQLException {
    List<PropertyInfo> columns = new ArrayList<PropertyInfo>();
    Connection con = null;
    PreparedStatement pstemt = null;
    String sql = "select column_name,data_type,column_comment from information_schema.columns where table_schema='?' and table_name='?'";
    try {
        con = DriverManager.getConnection(bi.getDbUrl(), bi.getDbName(), bi.getDbPassword());
        pstemt = con.prepareStatement(sql);
        pstemt.setObject(1,bi.getDatabase());
        pstemt.setObject(2,bi.getTable());
        ResultSet executeQuery = pstemt.executeQuery();
        while (executeQuery.next()) {
            String column = executeQuery.getString(1);
            String jdbcType = executeQuery.getString(2);
            String comment = executeQuery.getString(3);
            PropertyInfo ci = new PropertyInfo();
            ci.setColumn(column);
            if (jdbcType.equalsIgnoreCase("int")) {
                ci.setJdbcType("Integer");
            } else if (jdbcType.equalsIgnoreCase("datetime")) {
                ci.setJdbcType("timestamp");
            } else {
                ci.setJdbcType(jdbcType);
            }
            ci.setComment(comment);
            ci.setProperty(MySqlToJavaUtil.changeToJavaFiled(column));
            ci.setJavaType(MySqlToJavaUtil.jdbcTypeToJavaType(jdbcType));
            if (column.equalsIgnoreCase("id")) {
                bi.setIdType(ci.getJavaType());
                bi.setIdJdbcType(ci.getJdbcType());
            }
            columns.add(ci);
        }
        bi.setCis(columns);
        return bi;
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("自动生成实体类错误：" + e.getMessage());
    } finally {
        pstemt.close();
        con.close();
    }
}}

