public class Dummy{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    int count = 0;
    String v_agn = null;
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String dob = request.getParameter("dob");
    String emailid = request.getParameter("email_id");
    long phoneno = Long.parseLong(request.getParameter("phone_no"));
    String address = request.getParameter("add");
    String location = request.getParameter("loc");
    String password = request.getParameter("apwd");
    try {
        System.out.println("trying");
        ps = agreg.con.prepareStatement("select count(*) from agent_details where location=?");
        System.out.println("trying again");
        ps.setObject(1, location);
        rs = ps.executeQuery();
        if (rs.next()) {
            count = rs.getInt(1);
            rs.close();
            ps.close();
        }
        System.out.println("tried");
        if (count != 0) {
            out.println("<html><body><script>" + "window.alert('User Not Registered(already exist)');" + "</script></body></html>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            agreg.add_agn_details(name, gender, dob, emailid, phoneno, address, location, password);
            ps = agreg.con.prepareStatement("select agn_id from agent_details where email_id = ? and location=? and phone_no=?");
            ps.setObject(1, emailid);
            ps.setObject(2, location);
            ps.setObject(3, phoneno);
            rs = ps.executeQuery();
            if (rs.next()) {
                v_agn = rs.getString(1);
                rs.close();
                ps.close();
            }
            out.println("<html><body><script>" + "window.alert('Successfully registered. ID: " + v_agn + "');" + "</script></body></html>");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);
            pw.close();
        }
    } catch (Exception x) {
        out.println("<html><head><link rel='stylesheet' type='text/css' href='theme.css'></head>" + "<body><script>" + "window.alert('Failed to register');" + "</script></body></html>");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.include(request, response);
    }
}}

