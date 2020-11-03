class Dummy{
public ArrayList<Account> getResponse(long userId, String choise, ArrayList<String> jcustomerDetails) {
    System.out.println("hello");
    ArrayList<Account> account = new ArrayList<>();
    String response = "decline";
    System.out.println("Press 1 to Accept\n" + "or" + "\nPress 2 to Decline.");
    response = input.next();
    if (response.equals("1")) {
        Account acc = new Account();
        response = acc.createAccount(userId, choise, jcustomerDetails);
        Connection con = ConnectionConfiguration.getConnection();
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select accounts.* ,fName, lName from users inner join account_holders as ah on ah.user_id = users.id inner join accounts on accounts.id = ah.a where account.id =" + response);
            while (rs.next()) {
                int accId = rs.getInt("id");
                String account_No = rs.getString("account_no");
                String account_type = rs.getString("account_type");
                double balance = rs.getDouble("balance");
                Timestamp date = rs.getTimestamp("open_date");
                String holderFname = rs.getString("fName");
                String holderLname = rs.getString("lName");
                System.out.println(account_No + ", " + holderFname + ", " + holderLname + ", " + account_type + ", " + balance + ", " + date);
                account.add(new Account(account_No, holderFname, date, balance));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return account;
}}

