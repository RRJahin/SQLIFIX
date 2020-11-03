class Dummy{
public Pet getPetById(long aPetId) {
    Pet found = null;
    try {
        DbService dbService = new DbService();
        Connection con = dbService.getConnection();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM helloworld.pets where pet_id= " + aPetId);
        while (rs.next()) {
            found = getPet(rs);
        }
    } catch (Throwable t) {
        t.printStackTrace();
    }
    return found;
}}

