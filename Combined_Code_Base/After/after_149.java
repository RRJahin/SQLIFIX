public class Dummy{
public ArrayList<String> findCoStars(String person) {
    PreparedStatement pStatement;
    ResultSet rs;
    String queryString;
    ArrayList<String> list = new ArrayList<String>();
    try {
        queryString = "set search_path to imdb";
        pStatement = connection.prepareStatement(queryString);
        pStatement.execute();
        queryString = "select distinct name " + "from people, roles " + "where  people.person_id = roles.person_id and name <> '?'and movie_id in" + "(select distinct movie_id " + "from people, roles " + "where name  = '?' AND people.person_id = roles.person_id)";
        pStatement = connection.prepareStatement(queryString);
        pStatement.setObject(1,person);
        pStatement.setObject(2,person);
        rs = pStatement.executeQuery();
        while (rs.next()) {
            String temp = rs.getString("name");
            list.add(temp);
        }
        Collections.sort(list);
    } catch (SQLException se) {
        System.err.println("SQL Exception." + "<Message>: " + se.getMessage());
    }
    return list;
}}

