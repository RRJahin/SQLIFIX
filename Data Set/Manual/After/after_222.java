public class Dummy{
public ArrayList<Note> getAllForOwner(User owner) throws ClassNotFoundException, SQLException {
    Connection connection = ConnectionManager.getConnection();
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM notes WHERE id_user = ?");
    statement.setObject(1,owner.getIdentifier());
    ArrayList<Note> notes = new ArrayList<Note>();
    ResultSet result = statement.executeQuery();
    Note note;
    while (result.next()) {
        note = new Note();
        note.setContent(result.getString("content"));
        note.setObject(result.getString("createdAt"));
        note.setIdentifier(result.getInt("Id"));
        note.setImportance(result.getString("importance"));
        note.setOwner(owner.getIdentifier());
        notes.add(note);
    }
    return notes;
}}

