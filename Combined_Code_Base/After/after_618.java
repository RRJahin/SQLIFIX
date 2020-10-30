class Dummy{
@Override
public void delete(Emp emp) {
    Connection conn = DBHelper.getInstance().getConnection();
    String sql = "DELETE FROM tbl_emp WHERE empno = ?";
    PreparedStatement ps = null;
    int result = 0;
    try {
        ps = conn.prepareStatement(sql);
        ps.setObject(1, emp.getEmpno());
        result = ps.executeUpdate();
        LOGGER.debug(sql);
        LOGGER.debug("删除{}条记录", result);
    } catch (SQLException e) {
        LOGGER.catching(e);
    } finally {
        DBHelper.closeStatement(ps);
    }
}}

