public class Dummy{
public static boolean insert(String PASSWORD, String EMAIL, String FIRST_NAME, String LAST_NAME, String PHONE) throws Exception {
    PASSWORD = Security.encrypt(PASSWORD);
    boolean result = false;
    int maxid = 0;
    try {
        c = ShopNow.openDB();
        stmt = c.prepareStatement("SELECT MAX(ID) as id FROM ADMIN");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            maxid = rs.getInt("id") + 1;
        }
        rs.close();
        stmt.close();
        String sql = "INSERT INTO ADMIN (ID,PASSWORD,EMAIL,FIRST_NAME,LAST_NAME,PHONE)" + "VALUES (?,?,?,?,?,?);";
        System.out.println("New administrator has bee added to the Admin table.");
        System.out.println();
        stmt = c.prepareStatement(sql);
        stmt.setObject(1,maxid);
        stmt.setObject(2,PASSWORD);
        stmt.setObject(3,EMAIL);
        stmt.setObject(4,FIRST_NAME);
        stmt.setObject(5,LAST_NAME);
        stmt.setObject(6,PHONE);
        stmt.executeUpdate();
        stmt.close();
        ShopNow.closeDB();
        result = true;
    } catch (SQLException ex) {
        Logger.getLogger(Login_Class.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}}

