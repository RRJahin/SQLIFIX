class Dummy{
@Override
public void update(Emp emp) {
    Connection conn = DBHelper.getInstance().getConnection();
    String sql = "UPDATE tbl_emp SET job = "+emp.getJob()+" WHERE empno = "+emp.getEmpno();
    Statement ps = null;
    int result = 0;
    try {
        ps = conn.createStatement();
        result = ps.executeUpdate(sql);
        LOGGER.debug(sql);
        LOGGER.debug("修改了{}条记录", result);
    } catch (SQLException e) {
        LOGGER.catching(e);
    } finally {
        DBHelper.closeStatement(ps);
    }
}}

