
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileJava {
	int Sno;
	String name;
	
	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public static void main(String[] args) {
		FileJava fj=new FileJava();
		fj.setName("sumit");
		fj.setSno(1);
		String path="C:/demo/";
		String fileName="ma1.java";
		String root=path +File.separator+fileName;
		System.out.println(root);
		File file = new File(root);
		boolean result;
		try {
			
			result = file.createNewFile(); 
			Path path1=Paths.get("C:\\demo\\ma1.java");
			 try {
				 Files.writeString(path1, "hello i am created manulally");
			 }
			 catch (Exception e) {
				System.out.println("Invalid path");
			}
			if (result)
			{
				System.out.println("file created " + file.getCanonicalPath()); 
			} else {
				System.out.println("File already exist at location: " + file.getCanonicalPath());
			}
		} catch (IOException e) {
			e.printStackTrace(); // prints exception if any
		}
	}
}