class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("AddressOperationError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            Statement statement = connection.createStatement();
            StringBuffer statementBuilder = new StringBuffer();
            UserSession user = ((UserSession) request.getSession().getAttribute("USER"));
            if (user != null) {
                String addressLn1 = request.getParameter("addressLine1");
                String addressLn2 = request.getParameter("addressLine2");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");
                boolean includeLine2Information = !addressLn2.isEmpty();
                statementBuilder.append("SELECT * FROM address WHERE street_ln1 = '").append(addressLn1).append("' AND ");
                if (includeLine2Information) {
                    statementBuilder.append("street_ln2 = '").append(addressLn2).append("' AND ");
                }
                statementBuilder.append("city = '").append(city).append("' AND zip_code = '").append(zip).append("' AND state_code = '").append(state).append("' AND email = '").append(user.getUsername()).append("';");
                ResultSet results = statement.executeQuery(statementBuilder.toString());
                if (!results.next()) {
                    statementBuilder.delete(0, statementBuilder.length()).append("INSERT INTO address ( street_ln1, ");
                    if (includeLine2Information) {
                        statementBuilder.append("street_ln2, ");
                    }
                    statementBuilder.append("city, zip_code, state_code, email) VALUES ('").append(addressLn1).append("', '");
                    if (includeLine2Information) {
                        statementBuilder.append(addressLn2).append("', '");
                    }
                    statementBuilder.append(city).append("', '").append(zip).append("', '").append(state).append("', '").append(user.getUsername()).append("');");
statement = connection.createStatement();
                    statement.executeUpdate(statementBuilder.toString());
                    request.getSession().setAttribute("AddressOperationError", "New address \"" + addressLn1 + "\" added successfully.");
                } else {
                    throw new ServletException("The address is already present in the database.");
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
    } catch (ServletException exception) {
        request.getSession().setAttribute("AddressOperationError", "Unable to add new address: " + exception.getMessage());
    }
    response.sendRedirect(request.getHeader("referer"));
}}

