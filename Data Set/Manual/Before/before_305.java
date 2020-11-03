public class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("CardOperationError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            Statement statement = connection.createStatement();
            StringBuffer statementBuilder = new StringBuffer();
            UserSession user = ((UserSession) request.getSession().getAttribute("USER"));
            if (user != null) {
                String cardNum = request.getParameter("cardNumber");
                String cardCSV = request.getParameter("cardCSV");
                statementBuilder.append("SELECT * FROM credit_card WHERE cardnum = '").append(cardNum).append("';");
                ResultSet results = statement.executeQuery(statementBuilder.toString());
                if (!results.next()) {
                    statementBuilder.delete(0, statementBuilder.length()).append("INSERT INTO credit_card VALUES ('").append(user.getUsername()).append("', '").append(cardNum).append("', '").append(cardCSV).append("');");
                    statement.executeUpdate(statementBuilder.toString());
                    request.getSession().setAttribute("CardOperationError", "New card \"" + cardNum + "\" added successfully.");
                } else {
                    throw new ServletException("The credit card is already present in the database.");
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
        request.getSession().setAttribute("CardOperationError", "Unable to add new credit card: " + exception.getMessage());
    }
    response.sendRedirect(request.getHeader("referer"));
}}

