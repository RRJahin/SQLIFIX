import java.sql.PreparedStatement;

public class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("CardOperationError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            
            StringBuffer statementBuilder = new StringBuffer();
            UserSession user = ((UserSession) request.getSession().getAttribute("USER"));
            if (user != null) {
                String cardNum = request.getParameter("cardNumber");
                String cardCSV = request.getParameter("cardCSV");
                statementBuilder.append("SELECT * FROM credit_card WHERE cardnum = '").append("?").append("';");
                PreparedStatement statement = connection.prepareStatement(statementBuilder.toString());
                statement.setObject(1, cardNum);
                ResultSet results = statement.executeQuery();
                if (!results.next()) {
                    statementBuilder.delete(0, statementBuilder.length()).append("INSERT INTO credit_card VALUES ('").append("?").append("', '").append("?").append("', '").append("?").append("');");
                    statement = connection.prepareStatement(statementBuilder.toString());
                    statement.setObject(1, user.getUsername());
                    statement.setObject(2, cardNum);
                    statement.setObject(3, cardCSV);
                    statement.executeUpdate();
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

