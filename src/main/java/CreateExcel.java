import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//import statements
public class CreateExcel {
    public static void main(String[] args) {

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
        int rownum = 0, cellnum;
        Cell cell;
        Set<String> keyset = data.keySet();

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"ThoughtworksUser@gmail.com", "CorrectP@ssw0rd", "MY ACCOUNT"});   //Correct_username__Correct_password
        data.put("2", new Object[]{"ThoughtworksUser@gmail.com", "IncorrectPassword", "Authentication failed."}); //Correct_username__Incorrect_password
        data.put("3", new Object[]{"ThoughtworksUser345@gmail.com", "CorrectP@ssw0rd", "Authentication failed."});    //Incorrect_username__Correct_password
        data.put("4", new Object[]{"ThoughtworksUser24@gmail.com", "IncorrectPassword", "Authentication failed."});  //Incorrect_username__Incorrect_password
        data.put("5", new Object[]{"", "AnytPassword", "An email address required."});   //Empty email-id
        data.put("6", new Object[]{"ThoughtworksUser@gmail.com", "", "Password is required."});   //Empty password
        data.put("7", new Object[]{"", "", "An email address required."});   //Empty email and email password

        //Iterate over data and write to sheet
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            cellnum = 0;

            for (Object obj : objArr) {
                cell = row.createCell(cellnum++);

                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }

        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("UserCredentials_demo.xlsx"));

            workbook.write(out);
            out.close();
            System.out.println("UserCredentials_demo.xlsx written successfully on disk.");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}