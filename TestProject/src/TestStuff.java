import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class TestStuff {

	public static String test(List<String> s) {
		s = new ArrayList<String>();
		s.add("f");
		if(true)
		{
			throw new RuntimeException();
		}
		return "";
	}
	
	
	 public static void main(String [] args) throws IOException {
		 //WHI_santana2716_inventory_20150123_1422005565357
		 String batchArgs = "a=b c=d";
		 String[] split = batchArgs.split("=");
		 System.out.println(split);
		 List<String> ff = new ArrayList<String>();
		 ff.add("g");
		 String f = "f";
		 try {
			f=test(ff);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(f);

		 
		
		 
	 }
	
}
