class Dummy{
@Override
public void handle(ActionEvent event) {
    if (rb1.isSelected()) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Customer DB");
        dialog.setHeaderText("Please fill the relavant fields");
        Label label4 = new Label("Customer Number");
        Label label1 = new Label("First Name");
        Label label2 = new Label("Last Name");
        Label label3 = new Label("Address");
        Label label5 = new Label("Phone Number");
        TextField text1 = new TextField();
        String str1 = text1.getText();
        TextField text2 = new TextField();
        String str2 = text2.getText();
        TextField text3 = new TextField();
        String str3 = text3.getText();
        TextField text4 = new TextField();
        String str4 = text4.getText();
        TextField text5 = new TextField();
        String str5 = text5.getText();
        GridPane grid = new GridPane();
        grid.add(label4, 1, 1);
        grid.add(text4, 2, 1);
        grid.add(label1, 1, 2);
        grid.add(text1, 2, 2);
        grid.add(label2, 1, 3);
        grid.add(text2, 2, 3);
        grid.add(label3, 1, 4);
        grid.add(text3, 2, 4);
        grid.add(label5, 1, 5);
        grid.add(text5, 2, 5);
        dialog.getDialogPane().setContent(grid);
        Button confirm = new Button("Confirm");
        confirm.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    Statement st = con.createStatement();
                    st.executeQuery("Insert into Customers(CustomerNo,fname,lname,Address,PhoneNo) values('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "')");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.showAndWait();
    }
    if (rb2.isSelected()) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("Fuel Type DB");
        dialog.setHeaderText("Please fill the relavant fields");
        Label label4 = new Label("Fuel Type ID");
        Label label1 = new Label("Fuel Name");
        Label label2 = new Label("Fuel Description");
        Label label3 = new Label("Buy Price Per Litre");
        Label label5 = new Label("Sell Price Per Litre");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();
        TextField text4 = new TextField();
        TextField text5 = new TextField();
        GridPane grid = new GridPane();
        grid.add(label4, 1, 1);
        grid.add(text4, 2, 1);
        grid.add(label1, 1, 2);
        grid.add(text1, 2, 2);
        grid.add(label2, 1, 3);
        grid.add(text2, 2, 3);
        grid.add(label3, 1, 4);
        grid.add(text3, 2, 4);
        grid.add(label5, 1, 5);
        grid.add(text5, 2, 5);
        dialog.getDialogPane().setContent(grid);
        Button confirm = new Button("Confirm");
        confirm.setOnAction(event1 -> {
        });
        dialog.showAndWait();
    }
}}

