public class Dummy{
public static boolean verifyLogin() throws Exception {
    boolean Validation = false;
    try {
        username = adminLogin.sendUsername();
        password = adminLogin.sendPassword();
        c = ShopNow.openDB();
        stmt = c.prepareStatement("SELECT PASSWORD FROM ADMIN WHERE EMAIL LIKE ?;");
        stmt.setObject(1,username);
        ResultSet rs1 = stmt.executeQuery();
        while (rs1.next()) {
            String encryptedPassword = rs1.getString("password");
            String decryptedPassword = Security.decrypt(encryptedPassword);
            if (decryptedPassword.equals(password)) {
                Validation = true;
            }
        }
        rs1.close();
        stmt.close();
        ShopNow.closeDB();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return Validation;
}}

