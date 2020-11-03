class Dummy{
public void deleteById(Class<?> classk, Object id) {
    DbMasterOrSlaveHolder.initMaster();
    Connection conn = null;
    PreparedStatement prest = null;
    String tableName = AnnoationUtil.getTablename(classk);
    String sql = "delete from ? where id=?" ;
    Session session = sessionFactory.getSession();
    try {
        long start2 = System.currentTimeMillis();
        conn = session.getConnection();
        conn.setAutoCommit(false);
        prest = conn.prepareStatement(sql);
        prest.setObject(1,tableName);
        prest.setObject(2,id);
        prest.executeUpdate();
        if (!conn.getAutoCommit()) {
            conn.commit();
        }
        long end2 = System.currentTimeMillis();
        logger.info("执行sql:{} use:{}ms,connection use:{}ms", sql, (end2 - start2), session.getCreateUseTime());
    } catch (SQLException e) {
        logger.error("deleteById error", e);
    } finally {
        sessionFactory.closeObject(prest);
        sessionFactory.closeObject(conn);
        sessionFactory.closeObject(session);
    }
}}

