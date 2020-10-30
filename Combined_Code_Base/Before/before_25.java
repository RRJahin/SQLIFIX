public class Dummy{
public static boolean insert(String PASSWORD, String EMAIL, String FIRST_NAME, String LAST_NAME, String PHONE) throws Exception {
    PASSWORD = Security.encrypt(PASSWORD);
    boolean result = false;
    int maxid = 0;
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(ID) as id FROM ADMIN");
        while (rs.next()) {
            maxid = rs.getInt("id") + 1;
        }
        rs.close();
        stmt.close();
        String sql = "INSERT INTO ADMIN (ID,PASSWORD,EMAIL,FIRST_NAME,LAST_NAME,PHONE)" + "VALUES (" + maxid + ", '" + PASSWORD + "','" + EMAIL + "','" + FIRST_NAME + "','" + LAST_NAME + "','" + PHONE + "');";
        System.out.println("New administrator has bee added to the Admin table.");
        System.out.println();
        stmt.executeUpdate(sql);
        stmt.close();
        ShopNow.closeDB();
        result = true;
    } catch (SQLException ex) {
        Logger.getLogger(Login_Class.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}}

