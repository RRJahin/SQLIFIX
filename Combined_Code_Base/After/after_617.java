class Dummy{
@Override
public void save(Emp emp) {
    Connection conn = DBHelper.getInstance().getConnection();
    String sql = "INSERT INTO tbl_emp(empno, ename, job, hiredate, sal) VALUES(?, ?, ?, ? ,?)";
    PreparedStatement ps = null;
    int result = 0;
    try {
        ps = conn.prepareStatement(sql);
        ps.setObject(1, emp.getEmpno());
        ps.setObject(2, emp.getEname());
        ps.setObject(3, emp.getJob());
        ps.setDate(4, emp.getHiredate());
        ps.setObject(5, emp.getSal());
        result = ps.executeUpdate();
        LOGGER.debug(sql);
        LOGGER.debug("添加了", result);
    } catch (SQLException e) {
        LOGGER.catching(e);
    } finally {
        DBHelper.closeStatement(ps);
    }
}}

