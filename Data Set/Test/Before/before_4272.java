class Dummy{
public int insertBinaryStream(String sTable, String sField, int MMS_id, String MMS_CLASS, String MMS_TITLE, String MMS_CONTENT) {
    insertdata_errcode = 0;
    insertdata_errstr = "";
    boolean flag = true;
    BLOB blob = null;
    try {
        conn.setAutoCommit(false);
        File files = new File(MMS_CONTENT);
        FileInputStream fis = new FileInputStream(files);
        sqlstr = "INSERT INTO " + sTable + " ( " + sField + " ) VALUES ("+MMS_id+","+MMS_TITLE+","+MMS_CLASS+","+empty_blob()+")";
        Statement ps = conn.createStatement();
        ps.executeUpdate(sqlstr);
        ps.close();
        sqlstr = "select MMS_CONTENT from " + sTable + " where MMS_ID= "+MMS_id+" for update";
        Statement ps1 = conn.createStatement();
        ResultSet rset = ps1.executeQuery(sqlstr);
        if (rset.next())
            blob = (BLOB) rset.getBlob(1);
        ps = conn.createStatement();
        OutputStream out = blob.getBinaryOutputStream();
        int count = -1, total = 0;
        byte[] data = new byte[blob.getBufferSize()];
        while ((count = fis.read(data)) != -1) {
            total += count;
            out.write(data, 0, count);
        }
        fis.close();
        out.close();
        try {
            ps.executeUpdate("update " + sTable + " set MMS_CONTENT="+blob+" where MMS_ID="+MMS_id);
        } catch (java.sql.SQLException ex) {
            insertdata_errstr = ex.getMessage();
            insertdata_errcode = ex.getErrorCode();
        }
        ps.close();
        conn.commit();
        conn.close();
    } catch (java.sql.SQLException ex) {
        insertdata_errstr = ex.getMessage();
        insertdata_errcode = ex.getErrorCode();
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
    return insertdata_errcode;
}}

