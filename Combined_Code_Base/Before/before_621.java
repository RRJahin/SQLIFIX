class Dummy{
public static void main(String[] args) {
    try {
        Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter Employee Id:");
        int empId = Integer.parseInt(br.readLine());
        String query = "delete from Employee where EMPID = "+empId+" ";
        Statement ps = con.createStatement();
        ps.execute(query);
        System.out.println("Success");
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

