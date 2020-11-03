class Dummy {
    public void modify(TaskBean _taskToModify, long _transactionId) throws DBBeanException {
        String METHOD = "modify";
        String METHOD_FULL = ": M=public void " + METHOD + "(TaskBean _taskToModify, long _transactionId)";
        Connection connection = null;
        Statement pstmt = null;
        try {
            connection = getConnection(_transactionId);
            int updated = 0;
            if (_taskToModify.getUpdatedTask()) {
                updated = 1;
            }
            String SQL_UPDATE = "UPDATE " + TASKS + " SET " + TASK_NAME + " ='" + _taskToModify.getName() + "', "
                    + TASK_OPERATION + " ='" + _taskToModify.getOperation() + "', " + TASK_STATUS + " ='"
                    + _taskToModify.getStatus() + "', " + TASK_REQUEST + " ='" + _taskToModify.getRequest() + "', "
                    + TASK_REQUEST_STATUS + " ='" + _taskToModify.getRequestStatus() + "', " + TASK_RESPONSE + " ='"
                    + _taskToModify.getResponse() + "', " + TASK_RESPONSE_TYPE + " ='" + _taskToModify.getResponseType()
                    + "', " + TASK_MODIFICATION + " = NOW(), " + TASK_UPDATED + " ='" + updated + "' " + " WHERE "
                    + TASK_ID + " ='" + _taskToModify.getId() + "'";
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
