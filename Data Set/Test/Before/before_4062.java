class Dummy {
    public void delete(ActionEvent event) {
        deletebut.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("delete?");
            alert.setHeaderText(null);
            alert.setContentText("deleted");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                try {
                    Connection conn = dbConnection.getConnection();
                    String delquery = "delete from block where ID=" + tid.getText();
                    Statement pr = conn.createStatement();
                    pr.executeUpdate(delquery);
                    pr.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
