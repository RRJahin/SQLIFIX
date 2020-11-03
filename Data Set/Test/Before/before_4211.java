class Dummy{
public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:65534/jdbc?useSSL=false", "user1", "pass1");
        stmt = con.createStatement();
        int result = stmt.executeUpdate("insert into 商品マスタ values('F-006','ピンクグレープフルーツ',1400)");
        System.out.println("挿入したレコード件数：" + result);
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

