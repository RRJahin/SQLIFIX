

class Dummy{
    public int update(String names) throws Exception {
        Connection dbConnection = null;
        PrepearedStatement sqlStatement = null;
        dbConnection = IO.getDBConnection();
        sqlStatement = dbConnection.prepareStatement("update users set hitcount=hitcount+1 where name=?");
        sqlStatement.setObject(1,names);
        resultSet = sqlStatement.executeQuery();

        return resultSet;
    }}
    
    