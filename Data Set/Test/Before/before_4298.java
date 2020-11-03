class Dummy{
protected JSONObject getEmail(String userid, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    JSONObject jo = new JSONObject();
    JSONArray ja = new JSONArray();
    JSONObject mainObj = new JSONObject();
    Connection conn1 = (Connection) request.getServletContext().getAttribute("db_conn");
    try {
        Statement preparedSt = conn1.createStatement();
        ResultSet rs;
        rs = preparedSt.executeQuery("SELECT * FROM Received WHERE receiver_id = "+userid);
        while (rs.next()) {
            jo = new JSONObject();
            jo.put("email_source", rs.getString(1));
            jo.put("thread_id", rs.getString(2));
            jo.put("email_read", rs.getString(3));
            jo.put("email_subject", rs.getString(4));
            jo.put("email_interval", rs.getString(5));
            ja.put(jo);
        }
        jo.put("email_source", "Johny");
        jo.put("thread_id", "1");
        jo.put("email_read", "true");
        jo.put("email_subject", "This is the bloody subject of the email");
        jo.put("email_interval", "1 day ago");
        ja.put(jo);
        jo = new JSONObject();
        jo.put("email_source", "Harry");
        jo.put("thread_id", "1");
        jo.put("email_read", "false");
        jo.put("email_subject", "Yo Douche!");
        jo.put("email_interval", "1 day ago");
        ja.put(jo);
        mainObj.put("inbox", ja);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return mainObj;
}}

