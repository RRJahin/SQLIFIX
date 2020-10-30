public class Dummy{
public int removePerson(PersonInfo person) {
    int no = 0;
    try {
        String sql = "DELETE FROM Person WHERE name = "+person.getName();
        Statement ps = con.createStatement();
        no = ps.executeUpdate(sql);
    } catch (Exception e) {
        System.out.println(e);
    }
    return no;
}}

