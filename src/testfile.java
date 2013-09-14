import java.io.File;

import com.zjut.teach.serviceimpl.StudentSourceServiceImpl;




public class testfile {
	public static void main(String arg[]){
		File file = new File("Resources");
		String[] a = file.list();
		System.out.println(a[0]);
		//StudentSourceServiceImpl.viewDownloads();
	}

}
