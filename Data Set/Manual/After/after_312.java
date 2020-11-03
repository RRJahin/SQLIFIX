public class Dummy{
void insertreview(int docno, String revtitle, String revcontent, String pname, String pros, String cons, String rlink, String revstar, String starword, String table) {
    try {
        stmt2 = connection.prepareStatement("insert into " + table + "(docno,productname,reviewtitle,reviewcontent,pros,cons,reviewlink,reviewstar,reviewstarword) values(?,?,?,?,?,?,?,?,?)");
        stmt2.setObject(1, docno);
        stmt2.setObject(2, pname);
        stmt2.setObject(3, revtitle);
        stmt2.setObject(4, revcontent);
        stmt2.setObject(5, pros);
        stmt2.setObject(6, cons);
        stmt2.setObject(7, rlink);
        stmt2.setObject(8, revstar);
        stmt2.setObject(9, starword);
        stmt2.executeUpdate();
        stmt2.close();
    } catch (Exception e) {
        System.out.println("Error while inserting reviews..." + e);
    }
}}

