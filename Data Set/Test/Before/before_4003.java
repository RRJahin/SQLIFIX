class Dummy {
    static void read(String name) {
        Connection connection = null;
        Statement pStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("�������ݿ�����ʧ��");
        }
        String sql = "select userid,username,userage from user where username=" + name;
        try {
            pStatement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("�������ݿ����ʧ��");
        }
        try {
            resultSet = pStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ִ�����ʧ��");
        }
        try {
            while (resultSet.next()) {
                System.out.print(resultSet.getObject(1) + "   ");
                System.out.print(resultSet.getObject(2) + "   ");
                System.out.println(resultSet.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("������ʧ��");
        } finally {
            JdbcUtils.freeResource(resultSet, pStatement, connection);
        }
    }
}
