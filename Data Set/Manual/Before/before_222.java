public class Dummy{
public ArrayList<Note> getAllForOwner(User owner) throws ClassNotFoundException, SQLException {
    Connection connection = ConnectionManager.getConnection();
    Statement statement = connection.createStatement();
    ArrayList<Note> notes = new ArrayList<Note>();
    ResultSet result = statement.executeQuery("SELECT * FROM notes WHERE id_user = " + owner.getIdentifier());
    Note note;
    while (result.next()) {
        note = new Note();
        note.setContent(result.getString("content"));
        note.setDate(result.getString("createdAt"));
        note.setIdentifier(result.getInt("Id"));
        note.setImportance(result.getString("importance"));
        note.setOwner(owner.getIdentifier());
        notes.add(note);
    }
    return notes;
}}

