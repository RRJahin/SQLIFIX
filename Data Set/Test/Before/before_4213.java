class Dummy{
public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:65534/jdbc?useSSL=false", "user1", "pass1");
        stmt = con.createStatement();
        int result = stmt.executeUpdate("delete from 商品マスタ where 商品ID = 'F-006';");
        System.out.println("削除したレコード件数：" + result);
    } catch (ClassNotFoundException e) {
        System.out.println("JDBCドライバが見つかりません。");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("DBアクセス時にエラーが発生しました。");
        e.printStackTrace();
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("DBアクセス時にエラーが発生しました。");
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("DBアクセス時にエラーが発生しました。");
            e.printStackTrace();
        }
    }
}}

