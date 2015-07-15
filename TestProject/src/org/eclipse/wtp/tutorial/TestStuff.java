package org.eclipse.wtp.tutorial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TestStuff {

	
	
	 public static void main(String [] args) throws IOException {
		 String batchArgs = "a=b c=d";
		 String[] split = batchArgs.split("=");
		 System.out.println(split);
		 
		 //WHI_santana2716_inventory_20150123_1422005565357
		 List<String> allSkuRows= Files.readAllLines(Paths.get("S:\\WHI_santana2716_inventory_20150123_1422005565357.csv"), StandardCharsets.UTF_8);
		 Set<String> set = new HashSet<String>();
		 for(String row:allSkuRows) {
			 String rowArr[] = row.split(",");
			 //System.out.println(rowArr[1]);
			 set.add(rowArr[1]);
		 }
		 System.out.println("Set has "+set.size());
		 
		 for(int i = 40;i<=80;i++) {
			 BufferedReader reader = new BufferedReader(new FileReader("S:\\WHI_fitments_12232014_"+i+".csv"));
			 BufferedWriter writer = new BufferedWriter(new FileWriter("S:\\file.out",true));
		
			 String skuRow= null;
			 long count1 = 0;
			 long count2= 0;
			 Set<String> matchesSet = new HashSet<String>();
			 System.out.println("Working on file "+"S:\\WHI_fitments_12232014_"+i+".csv");
			 while((skuRow = reader.readLine()) !=null) {
				 String [] skuArr = skuRow.split(",");
				 //System.out.println(skuArr[0]);
				 if(set.contains(skuArr[0])) {
					 writer.write(skuRow+"\n");
					 count1++;
					 matchesSet.add(skuArr[0]);
				 }
				 if(count1 % 150000 == 0) {
					 writer.flush();
				 }
				 count2++;
				 if(count2 % 1000000 == 0) {
					 System.out.println("1M done "+ count2/1000000);
				 }
			 }
			 
			 writer.flush();
			 writer.close();
			 reader.close();
			 System.out.println("done");
			 
			 //now remove above matched items
			 set.removeAll(matchesSet);
			
		 }
			
		 
		
		 
	 }
	
}
