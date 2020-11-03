public class Dummy{
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        int userid = Integer.parseInt(request.getParameter("uid"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://122.123.124.127:3306/myclouddrive", "root", "");
            Statement ps = con.createStatement();
            int ans = ps.executeUpdate("delete from user where id = " + userid);
            if (ans > 0) {
                JOptionPane.showMessageDialog(null, "user successfully deleted : " + ans);
            }
            request.getRequestDispatcher("adminpanel.jsp").forward(request, response);
        } catch (Exception e) {
            out.println("error caughr while deleting user : " + e);
        }
    }
}}

