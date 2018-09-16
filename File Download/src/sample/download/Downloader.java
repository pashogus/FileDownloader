package sample.download;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class Downloader {
	public static String dirname=null;
	public static String fileReader= null;
	public static String httpPath= null;
	public static String outFile= null;
	

	public static void main(String[] args) throws IOException {
		
		InputStream input = null;
		//input = new FileInputStream("D:\\Shanmugasundaram P\\WorkSpace\\File Download\\config.properties");
		input = new FileInputStream("/u01/domains/WCCContentDownload/config.properties");
		Properties prop = new Properties();
		prop.load(input);
		dirname = prop.getProperty("downloadPath");
		fileReader = prop.getProperty("fileReaderPath");
		httpPath = prop.getProperty("httpPath");
		outFile = prop.getProperty("outFilePath");
		
		
		int Count=0;
		
		  BufferedWriter writer=null;
		  BufferedReader  reader =null;
		  writer = new BufferedWriter(new FileWriter(outFile));
			
				//  dirName = "D:\\Shanmugasundaram P\\Environment setup\\library";

				 try {
					 
					 
					System.out.println("Start of File Download Method");			 
					 
					 reader =  new BufferedReader(new FileReader (fileReader));
					 System.out.println("File Reader Path --------"+fileReader);
					 //Elibrary---webURl---nativeFilename
					 String line;
				     while ((line = reader.readLine())!= null) {
				    	 String[] input1=null;
				  	    input1 =line.split("---");
				  	    String ContentID= input1[0];
				  	    String weburl=input1[1];
				  	    String nativeFileName=input1[2];
				  	  
				  	String  url= weburl.replaceAll(" ","%20");
				  	 
				  	      StringBuffer bf= new StringBuffer(httpPath);
				  	    String httpURl=  bf.append(url).toString().trim();
				  	    
				  	      
				     
				  	  System.out.println("Processing Content ----- " + ContentID+"-->"+httpURl);
			
			 
				 saveFileFromUrlWithCommonsIO(dirname +nativeFileName,httpURl);
				  	   // saveFileFromUrlWithCommonsIO(dirname+"\\"+nativeFileName,httpURl);
				  	    
				  	  
				  	  writer.write(ContentID+"-->"+httpURl);
				  	  writer.newLine();
				  	  Count++;
				  	  System.out.println("Proceessed Count ----  "+ Count);
				  	  
				  	  
				     }
				     
				     writer.write("Total Content downloaded -- "+Count);
				     System.out.println("Total Content downloaded -- "+Count);

				 

				 } catch (MalformedURLException e) {
				 e.printStackTrace();
				 } catch (IOException e) {
				 e.printStackTrace();
				 }
				 finally
				 {
					
						
						 writer.close();
						 reader.close();
					 
					
				 }

				}

				
				// Using Commons IO library
		
				 public static void saveFileFromUrlWithCommonsIO(String fileName,
				 String fileUrl) throws MalformedURLException, IOException {
				 FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
				 }
	}


