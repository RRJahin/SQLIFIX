public class Dummy{
public static void insertData(String tbName) {
    try {
        InputStream is = new FileInputStream("D://work//diantai.xlsx");
        ExcelReader excelReader = new ExcelReader();
        String[] colName = excelReader.readExcelTitle(is);
        StringBuffer sqlBegin = new StringBuffer("insert into " + tbName + "(");
        for (int i = 0; i < colName.length; i++) {
            sqlBegin.append(colName[i]);
            if (i != colName.length - 1) {
                sqlBegin.append(",");
            }
        }
        sqlBegin.append(") values(");
        is.close();
        POIFSFileSystem fs;
        HSSFWorkbook wb;
        HSSFSheet sheet;
        HSSFRow row;
        is = new FileInputStream("D://work//diantai.xls");
        fs = new POIFSFileSystem(is);
        wb = new HSSFWorkbook(fs);
        sheet = wb.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        String sql = new String(sqlBegin);
        String temp;
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                temp = excelReader.getStringCellValue(row.getCell((short) j)).trim();
                if (colName[j].indexOf("date") != -1) {
                    temp = temp.substring(0, temp.length() - 2);
                    Date d = new Date((Long.valueOf(temp) - 25569) * 24 * 3600 * 1000);
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                    temp = "'" + formater.format(d) + "'";
                }
                sql = sql + temp;
                if (j != colNum - 1) {
                    sql = sql + ",";
                }
                j++;
            }
            sql = sql + ")";
            System.out.println(sql.toString());
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.execute();
            ps.close();
            sql = "";
            sql = sqlBegin.toString();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

