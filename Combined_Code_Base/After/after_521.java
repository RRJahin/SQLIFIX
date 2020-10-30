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
        String queryD = "delete from fuel_types where id=?";
        try {
            preparedStatement = con.prepareStatement(queryD);
            preparedStatement.setObject(1, delInt);
            preparedStatement.executeUpdate();
            System.out.println("delete from test where id=" + delInt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

