class Dummy {
    public void update(TaskBean _taskToUpdate, long _transactionId) throws DBBeanException {
        String METHOD = "update";
        String METHOD_FULL = ": M=public void " + METHOD + "(TaskBean _taskToUpdate, long _transactionId)";
        Connection connection = null;
        Statement pstmt = null;
        try {
            connection = getConnection(_transactionId);
            int updated = 0;
            if (_taskToUpdate.getUpdatedTask()) {
                updated = 1;
            }
            String SQL_UPDATE = "UPDATE " + TASKS + " SET " + TASK_RESPONSE + " ='" + _taskToUpdate.getResponse()
                    + "', " + TASK_RESPONSE_TYPE + " ='" + _taskToUpdate.getResponseType() + "', " + TASK_MODIFICATION
                    + " = NOW(), " + TASK_UPDATED + " ='" + updated + "' " + " WHERE " + TASK_ID + " ='"
                    + _taskToUpdate.getId() + "'";
            pstmt = connection.createStatement();
            pstmt.execute(SQL_UPDATE);
        } catch (SQLException e) {
            throw new DBBeanException(e.getMessage(), DBBeanException.ERR_UPDATE_SQL, ORIGINE + METHOD_FULL);
        } catch (Exception e) {
            throw new DBBeanException(e.getMessage(), DBBeanException.ERR_UPDATE_SQL, ORIGINE + METHOD_FULL);
        } finally {
            try {
                if (pstmt != null) {
                    this.closePreparedStatement(pstmt, INFOS_CLASSE, log, METHOD);
                }
            } catch (Exception e) {
                throw new DBBeanException(e.getMessage(), DBBeanException.ERR_FERMER_CONN, ORIGINE + METHOD_FULL);
            }
        }
    }
}
