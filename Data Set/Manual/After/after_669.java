

class Dummy{
    public int update(String names) throws Exception {
        Connection dbConnection = null;
        PreparedStatement sqlStatement = null;
        dbConnection = IO.getDBConnection();
        sqlStatement = dbConnection.prepareStatement("select name from users where id=0");
        resultSet = sqlStatement.executeQuery();
        return resultSet;
    }}
