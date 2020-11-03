class Dummy{
public void actionPerformed(ActionEvent e) {
    String ad = JOptionPane.showInputDialog("Calisanin adini giriniz: ");
    String soyad = JOptionPane.showInputDialog("Calisanin soyadini giriniz: ");
    String ssn = JOptionPane.showInputDialog("Calisanin no'sunu giriniz: ");
    String dTarihi = JOptionPane.showInputDialog("Calisanin dogum tarihini giriniz: ");
    String cinsiyet = JOptionPane.showInputDialog("Calisanin cinsiyetini giriniz: ");
    String maas = JOptionPane.showInputDialog("Calisanin maas bilgisini giriniz: ");
    String dNo = JOptionPane.showInputDialog("Calisanin departman bilgisini giriniz: ");
    Statement st;
    ResultSet rs;
    String sql = "SELECT dept_no FROM departments WHERE dept_no ='" + dNo + "'";
    try {
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        if (!rs.next()) {
            JOptionPane.showMessageDialog(sPanel, "Girilen departman geÃ¯Â¿Â½ersiz !");
        } else {
            String sql2 = "INSERT into employees (first_name,last_name,emp_no,birth_date,gender) VALUES ('" + ad + "','" + soyad + "','" + ssn + "','" + dTarihi + "','" + cinsiyet + "')";
            String sql3 = "INSERT into salaries (emp_no,salary) VALUES ('" + ssn + "','" + maas + "')";
            String sql4 = "INSERT into dept_emp (emp_no,dept_no) VALUES ('" + ssn + "','" + dNo + "')";
            st = conn.createStatement();
            st.executeUpdate(sql2);
st = conn.createStatement();
            st.executeUpdate(sql3);
st = conn.createStatement();
            st.executeUpdate(sql4);
        }
        rs.close();
        st.close();
    } catch (SQLException e1) {
        JOptionPane.showMessageDialog(sPanel, e1);
        e1.printStackTrace();
    }
}}

