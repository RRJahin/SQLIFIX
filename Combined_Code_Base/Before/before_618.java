class Dummy{
@Override
public void delete(Emp emp) {
    Connection conn = DBHelper.getInstance().getConnection();
    String sql = "DELETE FROM tbl_emp WHERE empno = "+emp.getEmpno();
    Statement ps = null;
    int result = 0;
    try {
        ps = conn.createStatement();
        result = ps.executeUpdate(sql);
        LOGGER.debug(sql);
        LOGGER.debug("删除{}条记录", result);
    } catch (SQLException e) {
        LOGGER.catching(e);
    } finally {
        DBHelper.closeStatement(ps);
    }
}}

