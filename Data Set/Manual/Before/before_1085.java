public class Dummy{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String Name = request.getParameter("firstname");
    String Specialization = request.getParameter("sp");
    String City_name = request.getParameter("city");
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        System.out.println(con3);
        String query3 = "insert into AdvanceSearch(name,sp,city) values(?,?,?)";
        Statement ps3 = con3.createStatement(query3);
        ps3.setString(1, Name);
        ps3.setString(2, Specialization);
        ps3.setString(3, City_name);
        ps3.executeUpdate();
        System.out.println("successfuly inserted");
        ps3.close();
        con3.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    RequestDispatcher rd = request.getRequestDispatcher("doctor.jsp");
    rd.forward(request, response);
}}

