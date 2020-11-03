public class Dummy{
private void updateUserMap() throws java.sql.SQLException, org.json.JSONException, java.io.IOException {
    if (System.currentTimeMillis() > last_check + DB_CHECK_MS) {
        Connection conn = null;
        try {
            double network_diff = server.getDifficulty();
            double diff1shares = 0.0;
            conn = DB.openConnection("share_db");
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery("select * from shares where our_result='Y' order by time desc limit "+Math.round(network_diff / 32.0));
            HashMap<String, Double> slice_map = new HashMap<String, Double>(512, 0.5f);
            while ((rs.next()) && (diff1shares + 1e-3 < network_diff)) {
                String user = rs.getString("username");
                long share_diff = rs.getLong("difficulty");
                double apply_diff = Math.min(share_diff, network_diff - diff1shares);
                diff1shares += apply_diff;
                double fee = 0.0175 + (0.1325 / Math.pow(share_diff, 0.6));
                fee = 0.0;
                double slice = 25.0 * (1.0 - (fee)) * apply_diff / network_diff;
                if (!slice_map.containsKey(user)) {
                    slice_map.put(user, slice);
                } else {
                    slice_map.put(user, slice + slice_map.get(user));
                }
            }
            rs.close();
            ps.close();
            for (Map.Entry<String, Double> me : slice_map.entrySet()) {
                DecimalFormat df = new DecimalFormat("0.00000000");
                System.out.println(me.getKey() + ": " + df.format(me.getValue()));
            }
            System.out.println("Total: " + sum(slice_map.values()));
            last_map = slice_map;
            last_check = System.currentTimeMillis();
        } finally {
            DB.safeClose(conn);
        }
    }
}}

