class Dummy{
public String get_new_password() {
    try {
        c = ShopNow.openDB();
        stmt = c.createStatement();
        String sql = "SELECT PASSWORD FROM CUSTOMER WHERE EMAIL = '" + Login.sendUsername() + "'";
        ResultSet rs = stmt.executeQuery(sql);
        String newPassword = rs.getString(1);
        ShopNow.closeDB();
        newPassword = Security.decrypt(newPassword);
        return newPassword;
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
    return null;
}}

