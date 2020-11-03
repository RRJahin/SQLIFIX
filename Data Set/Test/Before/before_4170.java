class Dummy{
@Override
public void actionPerformed(ActionEvent e) {
    if (textFieldID.getText().equals("") & textFieldName.getText().equals("") & textFieldsex.getText().equals("")) {
        java.sql.Connection conn = null;
        Statement stm = null;
        String str = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, psd);
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from stu");
            while (rs.next()) {
                str += "ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(1) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(2) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ±ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(3) + "\n";
            }
            textAreaShow.setText(str);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    if ((!textFieldID.getText().equals("")) & textFieldName.getText().equals("") & textFieldsex.getText().equals("")) {
        if (!(Pattern.matches("(\\d{10})", textFieldID.getText()))) {
            JOptionPane.showMessageDialog(null, "ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ·ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½10ÃÂÃÂ»ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½");
            return;
        }
        java.sql.Connection conn1 = null;
        PreparedStatement pstm1 = null;
        ResultSet rs = null;
        String str1 = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection(url, user, psd);
            pstm1 = conn1.prepareStatement("select * from stu where sID=? ");
            pstm1.setString(1, textFieldID.getText());
pstm1 = conn.createStatement();
            rs = pstm1.executeQuery();
            if (rs.next()) {
                rs.previous();
                while (rs.next()) {
                    str1 += "ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(1) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(2) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ±ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(3) + "\n";
                    textAreaShow.setText(str1);
                }
            } else {
                textAreaShow.setText("ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¯ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¢ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¡ÃÂ¯ÃÂ¿ÃÂ½");
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (pstm1 != null) {
                    pstm1.close();
                }
                if (conn1 != null) {
                    conn1.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    if ((textFieldID.getText().equals("")) & !textFieldName.getText().equals("") & textFieldsex.getText().equals("")) {
        if (!(Pattern.matches("([\u4e00-\u9fa5]{2,128})", textFieldName.getText()))) {
            JOptionPane.showMessageDialog(null, "ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ·ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½");
            return;
        }
        java.sql.Connection conn1 = null;
        PreparedStatement pstm1 = null;
        ResultSet rs = null;
        String str1 = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection(url, user, psd);
            pstm1 = conn1.prepareStatement("select * from stu where sName=? ");
            pstm1.setString(1, textFieldName.getText());
pstm1 = conn.createStatement();
            rs = pstm1.executeQuery();
            if (rs.next()) {
                rs.previous();
                while (rs.next()) {
                    str1 += "ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(1) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(2) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ±ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(3) + "\n";
                    textAreaShow.setText(str1);
                }
            } else {
                textAreaShow.setText("ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¯ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¢ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¡ÃÂ¯ÃÂ¿ÃÂ½");
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (pstm1 != null) {
                    pstm1.close();
                }
                if (conn1 != null) {
                    conn1.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    if ((textFieldID.getText().equals("")) & textFieldName.getText().equals("") & !textFieldsex.getText().equals("")) {
        if (!(textFieldsex.getText().equals("ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½")) & !(textFieldsex.getText().equals("ÃÂÃÂ®"))) {
            JOptionPane.showMessageDialog(null, "ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ·ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ±ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ»ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ®ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ ");
            return;
        }
        java.sql.Connection conn1 = null;
        PreparedStatement pstm1 = null;
        String str1 = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn1 = DriverManager.getConnection(url, user, psd);
            pstm1 = conn1.prepareStatement("select * from stu where sSex=? ");
            pstm1.setString(1, textFieldsex.getText());
pstm1 = conn.createStatement();
            ResultSet rs = pstm1.executeQuery();
            if (rs.next()) {
                rs.previous();
                while (rs.next()) {
                    str1 += "ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(1) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(2) + "  ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ±ÃÂ¯ÃÂ¿ÃÂ½" + rs.getString(3) + "\n";
                    textAreaShow.setText(str1);
                }
            } else {
                textAreaShow.setText("ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¯ÃÂÃÂ§ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ£ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¢ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂ¯ÃÂ¿ÃÂ½ÃÂÃÂ¡ÃÂ¯ÃÂ¿ÃÂ½");
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (pstm1 != null) {
                    pstm1.close();
                }
                if (conn1 != null) {
                    conn1.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}}

