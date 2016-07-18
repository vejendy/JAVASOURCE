package filedir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileDirectory {
	void fileDirView(){
		File dirfile = new File("D:/filecopy");
		File[] list = dirfile.listFiles();
		for ( File list1 : list){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(list1),"euc-kr"));
				String line = null;
				StringBuffer sb = new StringBuffer();
				while ( (line = br.readLine()) != null ){
					sb.append(line+"\n");
				}
				System.out.println(sb);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
}
