class Dummy{
private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
    idJadwal = jComboBox5.getSelectedItem().toString();
    if (jComboBox2.getItemCount() > 1) {
        for (int i = jComboBox2.getItemCount() - 1; i > 0; i--) {
            jComboBox2.removeItemAt(i);
        }
    }
    try {
        res = stat.executeQuery("select ts.nama_studio as nama_studio from tb_studio ts, tb_jadwal tj\n" + "where ts.id_studio=tj.id_studio and\n" + "tj.id_jadwal=" + "'" + idJadwal + "';");
        while (res.next()) {
            jComboBox2.addItem(res.getString("nama_studio"));
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}}

