class Dummy{
public static void main(String... args) throws Exception {
DeleteDbFiles = connection.createStatement();
    DeleteDbFiles.execute("~", "test", true);
    Class.forName("org.h2.Driver");
    Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
    Statement stat = conn.createStatement();
    stat.execute("create table test_data(" + "id int, user varchar, data varchar, primary key(id, user))");
stat = conn.createStatement();
    stat.execute("create index on test_data(id, user)");
stat = conn.createStatement();
    stat.execute("create view test as select id, data " + "from test_data where user = user()");
stat = conn.createStatement();
    stat.execute("create trigger t_test instead of " + "insert, update, delete on test for each row " + "call \"" + RowAccessRights.class.getName() + "\"");
stat = conn.createStatement();
    stat.execute("create user a password 'a'");
stat = conn.createStatement();
    stat.execute("create user b password 'b'");
stat = conn.createStatement();
    stat.execute("grant all on test to a");
stat = conn.createStatement();
    stat.execute("grant all on test to b");
    ResultSet rs;
    Connection connA = DriverManager.getConnection("jdbc:h2:~/test", "a", "a");
    Statement statA = connA.createStatement();
    statA.execute("insert into test values(1, 'Hello'), (2, 'World')");
statA = connA.createStatement();
    statA.execute("update test set data = 'Hello!' where id = 1");
statA = connA.createStatement();
    statA.execute("delete from test where id = 2");
    Connection connB = DriverManager.getConnection("jdbc:h2:~/test", "b", "b");
    Statement statB = connB.createStatement();
    statB.execute("insert into test values(1, 'Hallo'), (2, 'Welt')");
statB = connB.createStatement();
    statB.execute("update test set data = 'Hallo!' where id = 1");
statB = connB.createStatement();
    statB.execute("delete from test where id = 2");
statA = connB.createStatement();
    rs = statA.executeQuery("select * from test");
    while (rs.next()) {
        System.out.println("a: " + rs.getInt(1) + "/" + rs.getString(2));
    }
statB = connB.createStatement();
    rs = statB.executeQuery("select * from test");
    while (rs.next()) {
        System.out.println("b: " + rs.getInt(1) + "/" + rs.getString(2));
    }
    connA.close();
    connB.close();
stat = connB.createStatement();
    rs = stat.executeQuery("select * from test_data");
    while (rs.next()) {
        System.out.println(rs.getInt(1) + "/" + rs.getString(2) + "/" + rs.getString(3));
    }
    conn.close();
}}

