public class Dummy{
@Override
public void handle(ActionEvent event) {
    if (list.getSelectionModel().getSelectedItem() != null) {
        int lR = list.getSelectionModel().getSelectedIndex();
        String choice = list.getSelectionModel().getSelectedItem();
        for (int i = 0; i < ids.size(); i++) {
            if (choice.contains(ids.get(i).toString())) {
                delInt = ids.get(i);
                list.getItems().remove(lR);
            }
        }
        String queryD = "delete from customers where customerNo="+delInt;
        try {
            preparedStatement = con.createStatement();
            preparedStatement.executeUpdate(queryD);
            System.out.println("delete from test where id=" + delInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

