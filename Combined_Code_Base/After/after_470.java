public class Dummy{
private void flipAdmin() {
    int curAdmin = selInstr.getAdmin();
    curAdmin ^= 1;
    String flipAdminQuery = "UPDATE instructor SET admin = ? WHERE idinstructor = ?;";
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
        PreparedStatement ps = connection.prepareStatement(flipAdminQuery);
        ps.setObject(1, curAdmin);
        ps.setObject(2, selInstr.getInstrId());
        ps.executeUpdate();
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

