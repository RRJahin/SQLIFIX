public class Dummy{
public LinkedList<String[]> getCisDifference(String organismName, String top) {
    Float nuOrgaVal = null;
    Float nuTmpValu = null;
    LinkedList<String[]> total_result = new LinkedList();
    String sbOrgaVal = "SELECT * " + "FROM organisms " + "WHERE COMPLETE_NAME LIKE '" + organismName + "'";
    try {
        Connection conn = fachada.conectar();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sbOrgaVal);
        while (rs.next()) {
            nuOrgaVal = Float.parseFloat(rs.getString("aminos_vs_cyst"));
        }
    } catch (Exception e) {
    }
    String sbOtheVal = "SELECT complete_name , " + nuOrgaVal + "-CAST(aminos_vs_cyst AS float) " + " as result FROM organisms " + "WHERE COMPLETE_NAME NOT LIKE '" + organismName + "' ORDER BY " + nuOrgaVal + "-CAST(aminos_vs_cyst AS float)" + " LIMIT " + top;
    System.out.println(sbOtheVal);
    try {
        Connection conn = fachada.conectar();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sbOtheVal);
        while (rs.next()) {
            String[] result = new String[4];
            result[0] = rs.getString("complete_name");
            nuTmpValu = Float.parseFloat(rs.getString("result"));
            Float nuResuVal = nuTmpValu;
            result[1] = "" + nuResuVal + "";
            total_result.add(result);
        }
    } catch (Exception e) {
    }
    return total_result;
}}

