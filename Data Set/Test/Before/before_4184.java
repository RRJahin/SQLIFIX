class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().setAttribute("AddressOperationError", "");
    try {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
            Statement statement = connection.createStatement();
            int id = Integer.parseInt(request.getParameter("id"));
            statement.executeUpdate("DELETE FROM address WHERE id = " + id + ";");
            request.getSession().setAttribute("AddressOperationError", "Successfully removed the address.");
        } catch (SQLException exception) {
            throw new ServletException("Unable to remove address: " + exception.getMessage());
        } catch (ClassNotFoundException exception) {
            throw new ServletException("Unable to load database drivers!");
        } catch (NumberFormatException exception) {
            throw new ServletException("Supplied address ID was incorrectly formatted. Unable to remove address.");
        }
    } catch (ServletException exception) {
        request.getSession().setAttribute("AddressOperationError", "Unable to remove address: " + exception.getMessage());
    }
    response.sendRedirect(request.getHeader("referer"));
}}

