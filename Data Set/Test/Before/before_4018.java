class Dummy {
    @Override
    public boolean addInfo(final StrategyInfo info) {
        KeyHolder holder = new GeneratedKeyHolder();
        int count = getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public Statement createPreparedStatement(Connection con) throws SQLException {
                Statement ps = con.createStatement();
                ps.executeQuery("insert into " + SqlConstants.TABLE_STRATEGY_INFO
                        + "(strategy_id, rank, title, content, url, lastmod_time, lastmod_userid, isdel) values("
                        + info.getStrategyId() + ", " + info.getRank() + ", " + info.getTitle() + ", "
                        + info.getContent() + ", " + info.getUrl() + ", now(), " + info.getLastModUserid() + ", "
                        + IWamiConstants.ACTIVE + ")");
            }
        }, holder);
        if (count > 0 && holder.getKey() != null) {
            info.setId(holder.getKey().longValue());
            return true;
        } else
            return false;
    }
}
