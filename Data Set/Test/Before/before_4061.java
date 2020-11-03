class Dummy {
    public void update(ActionEvent event) {
        tableblock.setOnMouseClicked(e -> {
            try {
                TableRecords tableRecords = (TableRecords) tableblock.getSelectionModel().getSelectedItem();
                String query = "SELECT * FROM block where ID = " + tableRecords.getID();
                Connection conn = dbConnection.getConnection();
                Statement pst = conn.createStatement();
                ResultSet resultSet = pst.executeQuery(query);
                while (resultSet.next()) {
                    this.tid.setText(resultSet.getString(1));
                    this.tyear.setText(resultSet.getString(2));
                    this.tref.setText(resultSet.getString(3));
                    this.tward.setText(resultSet.getString(5));
                    this.tmtaa.setText(resultSet.getString(6));
                    this.tindivfn.setText(resultSet.getString(18));
                    this.tindivmn.setText(resultSet.getString(19));
                    this.tindivln.setText(resultSet.getString(20));
                    this.transdate.setText(resultSet.getString(43));
                    ((TextField) transactiondate.getEditor()).setText(resultSet.getString(43));
                    if (resultSet.getString(40) != null) {
                        tenurelease.setSelected(false);
                        tenureres.setSelected(false);
                        tenurereslic.setSelected(false);
                        tenureuntitled.setSelected(false);
                        System.out.println(resultSet.getString(40));
                        String tenureString = resultSet.getString(40).replace("[", "]").replace("]", "");
                        System.out.println(tenureString);
                        List<String> tenuList = Arrays.asList(tenureString.split("\\s*,\\s*"));
                        System.out.println(tenuList);
                        for (String tlist : tenuList) {
                            switch (tlist) {
                                case "tenureuntitled":
                                    tenureuntitled.setSelected(true);
                                    break;
                                case "tenurereslic":
                                    tenurereslic.setSelected(true);
                                    break;
                                case "tenureres":
                                    tenureres.setSelected(true);
                                    break;
                                case "tenurelease":
                                    tenurelease.setSelected(true);
                                    break;
                                default:
                                    tenurelease.setSelected(false);
                                    tenureres.setSelected(false);
                                    tenurereslic.setSelected(false);
                                    tenureuntitled.setSelected(false);
                            }
                        }
                    } else {
                        tenurelease.setSelected(false);
                        tenureres.setSelected(false);
                        tenurereslic.setSelected(false);
                        tenureuntitled.setSelected(false);
                    }
                    if (resultSet.getString(41) != null) {
                        landcomm.setSelected(false);
                        landcomres.setSelected(false);
                        landindustrial.setSelected(false);
                        landinsti.setSelected(false);
                        landother.setSelected(false);
                        landres.setSelected(false);
                        System.out.println(resultSet.getString(41));
                        String tenureString = resultSet.getString(41).replace("[", "]").replace("]", "");
                        System.out.println(tenureString);
                        List<String> tenuList = Arrays.asList(tenureString.split("\\s*,\\s*"));
                        System.out.println(tenuList);
                        for (String tlist : tenuList) {
                            switch (tlist) {
                                case "landres":
                                    landres.setSelected(true);
                                    break;
                                case "landother":
                                    landother.setSelected(true);
                                    break;
                                case "landinsti":
                                    landinsti.setSelected(true);
                                    break;
                                case "landindustrial":
                                    landindustrial.setSelected(true);
                                    break;
                                case "landcomres":
                                    landcomres.setSelected(true);
                                    break;
                                case "landcomm":
                                    landcomm.setSelected(true);
                                    break;
                                default:
                                    landcomm.setSelected(false);
                                    landcomres.setSelected(false);
                                    landindustrial.setSelected(false);
                                    landinsti.setSelected(false);
                                    landother.setSelected(false);
                                    landres.setSelected(false);
                            }
                        }
                    } else {
                        landcomm.setSelected(false);
                        landcomres.setSelected(false);
                        landindustrial.setSelected(false);
                        landinsti.setSelected(false);
                        landother.setSelected(false);
                        landres.setSelected(false);
                    }
                    if (resultSet.getString(44) != null) {
                        soibank.setSelected(false);
                        soibroker.setSelected(false);
                        soibuyer.setSelected(false);
                        soigovt.setSelected(false);
                        soinotary.setSelected(false);
                        soiother.setSelected(false);
                        soivaluer.setSelected(false);
                        System.out.println(resultSet.getString(44));
                        String tenureString = resultSet.getString(44).replace("[", "]").replace("]", "");
                        System.out.println(tenureString);
                        List<String> tenuList = Arrays.asList(tenureString.split("\\s*,\\s*"));
                        System.out.println(tenuList);
                        for (String tlist : tenuList) {
                            switch (tlist) {
                                case "soivaluer":
                                    soivaluer.setSelected(true);
                                    break;
                                case "soiother":
                                    soiother.setSelected(true);
                                    break;
                                case "soinotary":
                                    soinotary.setSelected(true);
                                    break;
                                case "soigovt":
                                    soigovt.setSelected(true);
                                    break;
                                case "soibuyer":
                                    soibuyer.setSelected(true);
                                    break;
                                case "soibroker":
                                    soibroker.setSelected(true);
                                    break;
                                case "soibank":
                                    soibank.setSelected(true);
                                    break;
                                default:
                                    soibank.setSelected(false);
                                    soibroker.setSelected(false);
                                    soibuyer.setSelected(false);
                                    soigovt.setSelected(false);
                                    soinotary.setSelected(false);
                                    soiother.setSelected(false);
                                    soivaluer.setSelected(false);
                            }
                        }
                    } else {
                        soibank.setSelected(false);
                        soibroker.setSelected(false);
                        soibuyer.setSelected(false);
                        soigovt.setSelected(false);
                        soinotary.setSelected(false);
                        soiother.setSelected(false);
                        soivaluer.setSelected(false);
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
    }
}
