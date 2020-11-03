public class Dummy{
public ArrayList<String> findCoStars(String person) {
    Statement pStatement;
    ResultSet rs;
    String queryString;
    ArrayList<String> list = new ArrayList<String>();
    try {
        queryString = "set search_path to imdb";
        pStatement = connection.createStatement();
        pStatement.executeQuery(queryString);
        queryString = "select distinct name " + "from people, roles " + "where  people.person_id = roles.person_id and name <> '" + person + "'and movie_id in" + "(select distinct movie_id " + "from people, roles " + "where name  = '" + person + "' AND people.person_id = roles.person_id)";
        pStatement = connection.createStatement();
        rs = pStatement.executeQuery(queryString);
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

