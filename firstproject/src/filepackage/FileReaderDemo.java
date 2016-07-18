package filepackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import CallbyValue.CustomDateFormat;

public class FileReaderDemo {
	StringBuffer fileReadget(){
		StringBuffer sb = new StringBuffer();
		CustomDateFormat day_obj = new CustomDateFormat();
		String day = day_obj.mydateFormat();
		day = day.substring(0,10);
		try {
			File file = new File("D:/national_authem.txt");
			
			String filename = file.getName();
			int position = filename.indexOf(".");
//			System.out.println("파일명: "+filename.substring(0, position));
//			System.out.println("확장자: "+filename.substring(position+1));
			String orgfile = filename.substring(0, position);
			String extension = filename.substring(position+1);
			String destfile = orgfile + day + "." + extension ;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file),"euc-kr"));
			String line = null;
			while( (line = br.readLine()) != null){
//				System.out.println(line);
				sb.append(line + "\n");
			}
			br.close();
			
			FileInputStream fis = new FileInputStream( file );
			FileOutputStream fos = new FileOutputStream("d:/filecopy/"+destfile);
			
			int data = 0;
			while( ( data = fis.read() ) != -1 ){
				fos.write(data);
			}
			fis.close();
			fos.close();
			file.delete();
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		return sb;
	}
	
//	void fileReader() {		
//		try {
//			FileReader reader = new FileReader("C:/Users/user/Desktop/national_authem.txt");
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					new FileInputStream(reader),"euc-kr"));
//			
//			while (true){
//				int data = br.read();
//				char ch = (char) data;
//				if (data == -1)
//					break;
//				System.out.print(ch);
//			}
//			System.out.println("=====>111");
//			br.close();
//		} catch (Exception e) {
//			System.out.println("====>2222"+e.getMessage());
//		}
//	}
}
