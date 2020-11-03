public class Dummy{
private void flipAdmin() {
    int curAdmin = selInstr.getAdmin();
    curAdmin ^= 1;
    String flipAdminQuery = "UPDATE instructor SET admin = "+curAdmin+" WHERE idinstructor"+" = "+selInstr.getInstrId()+";";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        Statement ps = connection.createStatement();
        ps.executeUpdate(flipAdminQuery);
        ps.close();
        connection.close();
    } catch (SQLException e) {
        Alert sqlAlert = new Alert(Alert.AlertType.ERROR);
        sqlAlert.setTitle("Error changing admin privileges");
        sqlAlert.setHeaderText(null);
        sqlAlert.setContentText("The program encountered an error and couldn't change admin privileges, check your connection and please try again");
        sqlAlert.showAndWait();
        throw new IllegalStateException("Cannot connect the database!", e);
    }
    reloadInstructors();
}}

