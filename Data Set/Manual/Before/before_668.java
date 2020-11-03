

class Dummy{
    public int update(String names) throws Exception {
        Connection dbConnection = null;
        Statement sqlStatement = null;
        dbConnection = IO.getDBConnection();
        sqlStatement = dbConnection.createStatement();
        resultSet = sqlStatement.executeQuery("update users set hitcount=hitcount+1 where name='" + names + "'");
        return resultSet;
    }}
    
    