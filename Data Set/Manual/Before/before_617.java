class Dummy{
@Override
public void save(Emp emp) {
    Connection conn = DBHelper.getInstance().getConnection();
    String sql = "INSERT INTO tbl_emp(empno, ename, job, hiredate, sal) VALUES("+emp.getEmpno()+", "+emp.getEname()+
    ", "+emp.getJob()+", "+emp.getHiredate()+" ,"+emp.getSal()+")";
    Statement ps = null;
    int result = 0;
    try {
        ps = conn.createStatement();
        result = ps.executeUpdate(sql);
        LOGGER.debug(sql);
        LOGGER.debug("添加了", result);
    } catch (SQLException e) {
        LOGGER.catching(e);
    } finally {
        DBHelper.closeStatement(ps);
    }
}}

