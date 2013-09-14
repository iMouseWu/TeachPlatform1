import java.text.SimpleDateFormat;
import java.util.Date;


public class testdata {
	public static void main(String[] args){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println(dateFormat.format(date));
	}

}
