class Dummy{
@Override
public void update(Emp emp) {
    Connection conn = DBHelper.getInstance().getConnection();
    String sql = "UPDATE tbl_emp SET job = ? WHERE empno = ?";
    PreparedStatement ps = null;
    int result = 0;
    try {
        ps = conn.prepareStatement(sql);
        ps.setObject(1, emp.getJob());
        ps.setObject(2, emp.getEmpno());
        result = ps.executeUpdate();
        LOGGER.debug(sql);
        LOGGER.debug("修改了{}条记录", result);
    } catch (SQLException e) {
        LOGGER.catching(e);
    } finally {
        DBHelper.closeStatement(ps);
    }
}}

