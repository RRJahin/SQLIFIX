import java.sql.PreparedStatement;

public class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("CardOperationError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM credit_card WHERE cardnum = ?;");
            String cardNum = request.getParameter("cardNumber");
            statement.setObject(1, cardNum);
            statement.executeUpdate();
           
            request.getSession().setAttribute("CardOperationError", "Successfully removed the selected card.");
        } catch (SQLException exception) {
            throw new ServletException("Unable to remove credit card: " + exception.getMessage());
        } catch (ClassNotFoundException exception) {
            throw new ServletException("Unable to load database drivers!");
        }
    } catch (ServletException exception) {
        request.getSession().setAttribute("CardOperationError", "Unable to remove card: " + exception.getMessage());
    }
    response.sendRedirect(request.getHeader("referer"));
}}

