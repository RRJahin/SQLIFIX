class Dummy{
@Override
public void handle(ActionEvent event) {
    try {
        Statement st = con.createStatement();
        st.executeQuery("Insert into Customers(CustomerNo,fname,lname,Address,PhoneNo) values('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "')");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

