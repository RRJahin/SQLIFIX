class Dummy {
    public void delete(String _taskId, long _transactionId) throws DBBeanException {
        String METHOD = "delete";
        String METHOD_FULL = ": M=public void " + METHOD + "(String _taskId, long _transactionId)";
        Connection connection = null;
        Statement pstmt = null;
        try {
            connection = getConnection(_transactionId);
            String deleteRequest = "DELETE FROM " + TASKS + " WHERE " + TASK_ID + " = '" + _taskId + "' ";
            pstmt = connection.createStatement();
            pstmt.execute(deleteRequest);
        } catch (SQLException e) {
            throw new DBBeanException(e.getMessage(), DBBeanException.ERR_DELETE_SQL, ORIGINE + METHOD_FULL);
        } catch (Exception e) {
            throw new DBBeanException(e.getMessage(), DBBeanException.ERR_DELETE_SQL, ORIGINE + METHOD_FULL);
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
