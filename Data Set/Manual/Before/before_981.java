public class Dummy{
void insertreview(int docno, String revtitle, String revcontent, String pname, String pros, String cons, String rlink, String revstar, String starword, String table) {
    try {
        stmt2 = connection.createStatement("insert into " + table + "(docno,productname,reviewtitle,reviewcontent,pros,cons,reviewlink,reviewstar,reviewstarword) values(?,?,?,?,?,?,?,?,?)");
        stmt2.setLong(1, docno);
        stmt2.setString(2, pname);
        stmt2.setString(3, revtitle);
        stmt2.setString(4, revcontent);
        stmt2.setString(5, pros);
        stmt2.setString(6, cons);
        stmt2.setString(7, rlink);
        stmt2.setString(8, revstar);
        stmt2.setString(9, starword);
        stmt2.executeUpdate();
        stmt2.close();
    } catch (Exception e) {
        System.out.println("Error while inserting reviews..." + e);
    }
}}

