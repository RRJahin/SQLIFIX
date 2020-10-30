class Dummy{
private void printTypeMatchInfo(Class entityClass) throws SQLException {
    String tableName = getTableName(entityClass);
    Connection connection = sessionFactory.getCurrentSession().connection();
    Statement statment = connection.createStatement();
    ResultSet result = statment.executeQuery("select * from " + tableName + " where 1<>1");
    ResultSetMetaData resultMetaData = result.getMetaData();
    Field[] fields = entityClass.getDeclaredFields();
    for (Field field : fields) {
        if (isEntityField(field)) {
            String columnName = getColumnName(field);
            System.out.println(StringUtils.rightPad("FieldName:" + field.getName(), 30) + StringUtils.rightPad("FieldType:" + field.getType(), 50) + "ColumnType:" + getColumnTypeName(resultMetaData, columnName));
        }
    }
    result.close();
    statment.close();
    connection.close();
}}

