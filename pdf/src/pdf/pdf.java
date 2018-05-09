package pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AgeFileFilter;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class pdf {

	public static String pdfUtils(Map<String, String> dataMap) throws Exception {
        String fileName = "F:\\qtzzTZS.pdf"; // pdf模板  
        
        PdfReader reader = new PdfReader(fileName);
 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        PdfStamper ps = new PdfStamper(reader, bos);  
        AcroFields fields = ps.getAcroFields();  
        fillData(fields, dataMap);  
        ps.setFormFlattening(true);  
        ps.close();  
        
        String outFileName = "F:\\aa.pdf";
        File outFile=new File(outFileName);
        if(!outFile.exists()){
        	outFile.getParentFile().mkdirs();
        }
        OutputStream fos = new FileOutputStream(outFileName);  
        fos.write(bos.toByteArray());  
        fos.close();
        return outFileName;
    } 
	
   public static void fillData(AcroFields fields, Map<String, String> data) throws IOException, DocumentException {  
        for (String key : data.keySet()) {  
            String value = data.get(key);  
            fields.setField(key, value);  
        }  
    } 
   
	//通知书附件方法
	public static void agencyNoticeBookDoc() throws Exception{
//		Enrollment enrollment=setNowDateAndNumb(tableId);
		Map<String, String> dataMap = new HashMap<String, String>(); 
			dataMap.put("nowyear","1");
			dataMap.put("numb","2");
			dataMap.put("name","3");
			dataMap.put("cfcc","4");
			dataMap.put("applyDate", "5");
			dataMap.put("time", "6");
			dataMap.put("cnasEnddate","7");
		pdfUtils(dataMap);
	}
   
	 public static void main(String[] args) {
		try {
			agencyNoticeBookDoc();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
   

}
