class Dummy{
public static void main(String[] args) {
    try {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter Employee Id:");
        int empId = Integer.parseInt(br.readLine());
        Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        String query = "select * from Employee where EMPID = "+empId;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
        rs.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

