public class Dummy{
public LinkedList<String[]> getEDResults(String organismName, String top) {
    LinkedList<String[]> total_result = new LinkedList();
    String query = "SELECT * " + "FROM evolutionary_distance " + "WHERE organism_1 like '?' OR organism_2 like '?' ORDER BY CAST(evolutionary_distance AS float)  " + " LIMIT ?";
    System.out.println(query);
    try {
        Connection conn = fachada.conectar();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setObject(1, organismName);
        stmt.setObject(2, organismName);
        stmt.setObject(3, top);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String[] result = new String[4];
            result[0] = rs.getString("organism_1");
            result[1] = rs.getString("organism_2");
            result[2] = rs.getString("evolutionary_distance");
            total_result.add(result);
        }
    } catch (Exception e) {
    }
    return total_result;
}}

