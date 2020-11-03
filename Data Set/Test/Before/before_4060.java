class Dummy {
    private String getSynonymOwner(String synonymName) {
        Statement ps = null;
        ResultSet rs = null;
        String ret = null;
        try {
            ps = getConnection().createStatement();
            rs = ps.executeQuery("select table_owner from sys.all_synonyms where table_name=" + synonymName
                    + " and owner=" + getSchema());
            if (rs.next()) {
                ret = rs.getString(1);
            } else {
                String databaseStructure = getDatabaseStructureInfo();
                throw new RuntimeException(
                        "Wow! Synonym " + synonymName + " not found. How can it happen? " + databaseStructure);
            }
        } catch (SQLException e) {
            String databaseStructure = getDatabaseStructureInfo();
            GLogger.error(e.getMessage(), e);
            throw new RuntimeException("Exception in getting synonym owner " + databaseStructure);
        } finally {
            dbHelper.close(rs, ps);
        }
        return ret;
    }
}
