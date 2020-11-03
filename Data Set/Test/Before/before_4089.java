class Dummy {
    public Map<String, TaskBean> loadAllUpdatedTasksForOneUser(String _idUser) throws DBBeanException {
        String METHOD = "loadAllUpdatedTasksForOneUser";
        String METHOD_FULL = ": M=public Map<String, TaskBean> " + METHOD + "(String _idUser)";
        Map<String, TaskBean> tasksToReturn = new HashMap<String, TaskBean>();
        Connection connection = null;
        Statement pstmt = null;
        ResultSet rs = null;
        try {
            connection = this.getConnection(0);
            String SQL_LOAD_ALL_TASKS_FOR_ONE_USER = "SELECT * FROM " + TASKS + " WHERE " + TASK_USER + "='" + _idUser
                    + " AND " + TASK_UPDATED + "='1' " + "' ORDER BY " + TASK_CREATION + " DESC";
            pstmt = connection.createStatement();
            rs = pstmt.executeQuery(SQL_LOAD_ALL_TASKS_FOR_ONE_USER);
            {
                if (rs != null)
                    while (rs.next()) {
                        TaskBean task = new TaskBean();
                        task = setTaskBean(rs, ORIGINE + METHOD_FULL, false, false);
                        tasksToReturn.put(task.getId(), task);
                    }
            }
        } catch (SQLException exception) {
            log.info("\n" + ORIGINE + " : " + METHOD + " : SQLException : " + exception.getLocalizedMessage());
            throw new DBBeanException(exception.getMessage(), DBBeanException.ERR_LOAD_SQL, ORIGINE + METHOD_FULL);
        } finally {
            try {
                this.closeConnexion(connection, 0);
                if (pstmt != null) {
                    this.closePreparedStatement(pstmt, INFOS_CLASSE, log, METHOD_FULL);
                }
                if (rs != null) {
                    this.closeResultSet(rs, INFOS_CLASSE, log, METHOD_FULL);
                }
            } catch (Exception exception) {
                log.info("\n" + ORIGINE + " : " + METHOD + " : Exception : " + exception.getLocalizedMessage());
                throw new DBBeanException(exception.getMessage(), DBBeanException.ERR_FERMER_CONN,
                        ORIGINE + METHOD_FULL);
            }
        }
        return tasksToReturn;
    }
}
