class Dummy{
public int update(int data) throws Exception {
    Connection dbConnection = null;
    Statement sqlStatement = null;
    dbConnection = IO.getDBConnection();
    sqlStatement = dbConnection.createStatement();
    resultSet = sqlStatement.executeQuery("select * from users where name='"+data+"'");
    return resultSet;
}}

