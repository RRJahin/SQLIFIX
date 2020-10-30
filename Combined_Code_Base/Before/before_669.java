

class Dummy{
    public int update(String names) throws Exception {
        Connection dbConnection = null;
        Statement sqlStatement = null;
        dbConnection = IO.getDBConnection();
        sqlStatement = dbConnection.createStatement();
        resultSet = sqlStatement.executeQuery("select name from users where id=0");
        return resultSet;
    }}

