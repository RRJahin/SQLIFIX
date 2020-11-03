class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("AddressOperationError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            Statement statement = connection.createStatement();
            StringBuilder statementBuilder = new StringBuilder();
            String addressLn1 = request.getParameter("addressLine1");
            String addressLn2 = request.getParameter("addressLine2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");
            int id = Integer.parseInt(request.getParameter("id"));
            boolean includeLine2Information = !addressLn2.isEmpty();
            statementBuilder.append("UPDATE address SET street_ln1 = '").append(addressLn1).append("' WHERE id = ").append(id).append("; ");
            if (includeLine2Information) {
                statementBuilder.append("UPDATE address SET street_ln2 = '").append(addressLn2).append("' WHERE id = ").append(id).append("; ");
            } else {
                statementBuilder.append("UPDATE address SET street_ln2 = NULL WHERE id = ").append(id).append("; ");
            }
            statementBuilder.append("UPDATE address SET city = '").append(city).append("' WHERE id = ").append(id).append("; ");
            statementBuilder.append("UPDATE address SET state_code = '").append(state).append("' WHERE id = ").append(id).append("; ");
            statementBuilder.append("UPDATE address SET zip_code = '").append(zip).append("' WHERE id = ").append(id).append("; ");
            statement.execute(statementBuilder.toString());
            request.getSession().setAttribute("AddressOperationError", "Address update succeeded!");
        } catch (NumberFormatException nfe) {
            throw new ServletException("The address ID was incorrectly formatted.  Unfortuately, the address cannot be updated.");
        } catch (ClassCastException exc) {
            throw new ServletException("User was invalid!");
        } catch (SQLException sql) {
            throw new ServletException(sql.getMessage());
        } catch (ClassNotFoundException classNotFound) {
            throw new ServletException("Could not load required database drivers!");
        }
    } catch (ServletException exception) {
        request.getSession().setAttribute("AddressOperationError", "Unable to update address: " + exception.getMessage());
    }
    response.sendRedirect(request.getHeader("referer"));
}}

