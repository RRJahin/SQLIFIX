class Dummy{
    public int update(int data) throws Exception {
        Connection dbConnection = null;
        PreparedStatement sqlStatement = null;
        dbConnection = IO.getDBConnection();
        sqlStatement = dbConnection.prepareStatement("select * from users where name=?");
        sqlStatement.setObject(1,data);
        resultSet = sqlStatement.executeQuery();
        return resultSet;
    }}
    
    