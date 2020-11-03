class Dummy {
    private void doRun() throws Exception {
        JSONObject reply = bitcoin_rpc.doSimplePostRequest("getblockcount");
        int block_height = reply.getInt("result");
        if (block_height != last_block) {
            int target_height = block_height + 1;
            getEventLog().log("New target height: " + target_height);
            Connection conn = null;
            try {
                conn = DB.openConnection("share_db");
                Statement ps = conn.createStatement();
                ps.execute("insert into block_discovery (height, node) values (" + target_height + ","
                        + config.get("instance_id") + ")");
                ps.close();
                conn.close();
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                DB.safeClose(conn);
            }
            System.out.println(reply);
            triggerUpdate(true);
            last_block = block_height;
            last_update_time = System.currentTimeMillis();
            last_success_time = System.currentTimeMillis();
            current_block_update_time = System.currentTimeMillis();
            current_block = block_height;
        }
        if (last_update_time + TEMPLATE_REFRESH_TIME < System.currentTimeMillis()) {
            triggerUpdate(false);
            last_update_time = System.currentTimeMillis();
            last_success_time = System.currentTimeMillis();
        }
    }
}
