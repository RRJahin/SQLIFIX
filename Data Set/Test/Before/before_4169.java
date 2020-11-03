class Dummy{
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    request.getSession().setAttribute("CARDS", null);
    request.getSession().setAttribute("ADDRESSES", null);
    request.getSession().setAttribute("AddressOperationError", "");
    request.getSession().setAttribute("CardOperationError", "");
    try {
        Object sessionObject = request.getSession().getAttribute("USER");
        if (sessionObject != null) {
            if (sessionObject instanceof UserSession) {
                UserSession userSession = (UserSession) sessionObject;
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "");
                Statement statement = connection.createStatement();
                StringBuilder statementBuilder = new StringBuilder();
                List<CreditCard> cardList = new ArrayList<CreditCard>();
                List<Address> addressList = new ArrayList<Address>();
                statementBuilder.append("SELECT * FROM credit_card WHERE credit_card.email = '").append(userSession.getUsername()).append("';");
                ResultSet results = statement.executeQuery(statementBuilder.toString());
                while (results.next()) {
                    CreditCard card = new CreditCard();
                    card.setCardCSV(results.getString("csvnum"));
                    card.setCardNumber(results.getString("cardnum"));
                    cardList.add(card);
                }
                statementBuilder.delete(0, statementBuilder.length());
                statementBuilder.append("SELECT * FROM address WHERE address.email = '").append(userSession.getUsername()).append("' ORDER BY id;");
statement = connection.createStatement();
                results = statement.executeQuery(statementBuilder.toString());
                while (results.next()) {
                    Address address = new Address();
                    address.setAddressId(results.getInt("id"));
                    address.setAddressLine1(results.getString("street_ln1"));
                    address.setAddressLine2(results.getString("street_ln2"));
                    address.setCity(results.getString("city"));
                    address.setState(results.getString("state_code"));
                    address.setZipCode(results.getString("zip_code"));
                    addressList.add(address);
                }
                request.getSession().setAttribute("CARDS", cardList);
                request.getSession().setAttribute("ADDRESSES", addressList);
                response.sendRedirect("/maskreybe/jsp/checkout.jsp");
            } else
                throw new ServletException("Invalid user!");
        } else
            throw new ServletException("Null user!");
    } catch (ClassNotFoundException | SQLException e) {
        throw new ServletException(e);
    }
}}

