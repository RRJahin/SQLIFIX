class Dummy{
@Override
public Map<Album, List<Image>> getUserAlbums(int userId) throws SelectException {
    Map<Album, List<Image>> result = new HashMap<Album, List<Image>>();
    try (Connection c = connection;
    PreparedStatement s = c.prepareStatement("Select UserId, `Name`, a.Id as aId, i.Id, `Hash`, `Image`, `Album`, `CreatedIn` From `ALBUM` as a " + "INNER JOIN `IMAGE` as i on i.Album = a.Id" + " Where `UserId` = ? Group by `Name`, i.`Id`, `Album`")) {
        s.setObject(1,userId);
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            Album album = new Album(rs.getString("Name"), rs.getInt("aId"), rs.getInt("UserId"));
            Image image = new Image();
            image.parseResultSet(rs);
            List<Image> albumImages = result.get(album);
            if (albumImages == null) {
                albumImages = new ArrayList<Image>();
            }
            albumImages.add(image);
            result.put(album, albumImages);
        }
        rs.close();
        return result;
    } catch (Exception ex) {
        throw new SelectException(ex);
    }
}}

