class Dummy{
private void printTypeMatchInfo(Class entityClass) throws SQLException {
    String tableName = getTableName(entityClass);
    Connection connection = sessionFactory.getCurrentSession().connection();
PreparedStatement statment = connection.prepareStatement("select * from ? where 1<>1");
statment.setObject(1,tableName);
    ResultSet result = statment.executeQuery();
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

