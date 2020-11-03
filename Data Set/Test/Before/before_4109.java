class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("UpdateError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            Statement statement = connection.createStatement();
            StringBuilder statementBuilder = new StringBuilder();
            String currentPass = request.getParameter("currentpass");
            String password = request.getParameter("pass");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String initials = request.getParameter("minits");
            String title = request.getParameter("title");
            UserSession user = ((UserSession) request.getSession().getAttribute("USER"));
            if (user != null) {
                ResultSet results = statement.executeQuery("SELECT * FROM member WHERE email = '" + user.getUsername() + "' AND password = '" + currentPass + "';");
                if (results.next()) {
                    if (!firstName.isEmpty()) {
                        statementBuilder.append("UPDATE member SET fname = '").append(firstName).append("' WHERE email = '").append(user.getUsername()).append("';\n");
                    }
                    if (!lastName.isEmpty()) {
                        statementBuilder.append("UPDATE member SET lname = '").append(lastName).append("' WHERE email = '").append(user.getUsername()).append("';\n");
                    }
                    if (!initials.isEmpty()) {
                        statementBuilder.append("UPDATE member SET minits = '").append(initials).append("' WHERE email = '").append(user.getUsername()).append("';\n");
                    }
                    if (!title.isEmpty()) {
                        statementBuilder.append("UPDATE member SET title = '").append(title).append("' WHERE email = '").append(user.getUsername()).append("';\n");
                    }
                    if (!password.isEmpty()) {
                        statementBuilder.append("UPDATE member SET password = '").append(password).append("' WHERE email = '").append(user.getUsername()).append("';\n");
                    }
statement = connection.createStatement();
                    statement.execute(statementBuilder.toString());
                    request.getSession().setAttribute("UpdateError", "Information updated successfully!");
                } else {
                    throw new ServletException("Current password was incorrect!");
                }
            } else {
                throw new ServletException("No user is logged in to update!");
            }
        } catch (ClassCastException exc) {
            throw new ServletException("User was invalid!");
        } catch (SQLException sql) {
            throw new ServletException(sql.getMessage());
        } catch (ClassNotFoundException classNotFound) {
            throw new ServletException("Could not load required database drivers!");
        }
    } catch (ServletException servlet) {
        request.getSession().setAttribute("UpdateError", "Unable to update information: " + servlet.getMessage());
    }
    response.sendRedirect(request.getHeader("referer"));
}}

