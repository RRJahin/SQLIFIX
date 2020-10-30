public class Dummy{
public void insertRec() {
    String query = "insert into candidates (first_name,last_name,dob,phone,email) values (hina ,nair ,1993-02-09 ,1234567890 ,hine@gmail)";
    try {
        Statement pstmt = con.createStatement();
        pstmt.execute(query);
        con.close();
    } catch (Exception ex) {
        System.out.println(ex);
    }
}}

