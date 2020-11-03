class Dummy {
    @Override
    public boolean addImage(final StrategyImage image) {
        KeyHolder holder = new GeneratedKeyHolder();
        int count = getJdbcTemplate().update(new PreparedStatementCreator() {

            @Override
            public Statement createPreparedStatement(Connection con) throws SQLException {
                Statement ps = con.createStatement();
                ps.executeQuery("insert into " + SqlConstants.TABLE_STRATEGY_IMAGES
                        + "(rank, strategy_id, icon_url, lastmod_time, lastmod_userid, isdel) values(" + image.getRank()
                        + ", " + image.getStrategyId() + ", " + image.getIconUrl() + ", now(), "
                        + image.getLastModUserid() + ", " + image.getIsdel() + ")");
            }
        }, holder);
        if (count > 0 && holder.getKey() != null) {
            image.setId(holder.getKey().longValue());
            return true;
        } else
            return false;
    }
}
