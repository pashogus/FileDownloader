package sample.download;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownload {

	public static void main(String[] args) {
		// Make sure that this directory exists
		 String dirName = "D:\\FileDownloader";

		 try {

		System.out.println("Downloading \'Maven, Eclipse and OSGi working together\' PDF document...");

	

		 saveFileFromUrlWithCommonsIO(
		 dirName + "\\5190-6883_BrazilPortuguese.pdf",
		 "https://www.agilent.com/cs/library/msds/5190-6883_BrazilPortuguese.pdf");

		 System.out.println("Downloaded \'InnoQ Web Services Standards Poster\' PDF document.");

		 } catch (MalformedURLException e) {
		 e.printStackTrace();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }

		

	
		 }

		// Using Commons IO library
		 // Available at http://commons.apache.org/io/download_io.cgi
		 public static void saveFileFromUrlWithCommonsIO(String fileName,
		 String fileUrl) throws MalformedURLException, IOException {
		 FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
		 }

		}


