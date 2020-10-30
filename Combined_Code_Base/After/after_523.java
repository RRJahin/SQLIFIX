public class Dummy{
public int removePerson(PersonInfo person) {
    int no = 0;
    try {
        String sql = "DELETE FROM Person WHERE name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1, person.getName());
        no = ps.executeUpdate();
    } catch (Exception e) {
        System.out.println(e);
    }
    return no;
}}

