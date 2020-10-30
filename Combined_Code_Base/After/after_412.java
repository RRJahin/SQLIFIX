public class Dummy{
public void insertRec() {
    String query = "insert into candidates (first_name,last_name,dob,phone,email) values (? ,? ,? ,? ,?)";
    try {
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setObject(1, "hina");
        pstmt.setObject(2, "nair");
        pstmt.setObject(3, "1993-02-09");
        pstmt.setObject(4, "1234567890");
        pstmt.setObject(5, "hine@gmail");
        pstmt.execute();
        con.close();
    } catch (Exception ex) {
        System.out.println(ex);
    }
}}

