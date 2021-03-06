package com.locked;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * this method all the files name from the folder
	 * @param folderpath
	 * @return list of string
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		
		//creating file object
		File fl=new File(folderpath);
		
		//Getting all the files into FileArray
		File[] listofFiles = fl.listFiles();
		
		//Declare a List to Store files names
		List<String> fileNames=new ArrayList<String>();
		
		for(File f:listofFiles)
				fileNames.add(f.getName());
		
		//return the list
		return fileNames;
		
	}
	
	/**
	 * tThis method will create or append content into the file specified 
	 * @param folderpath
	 * @param fileName
	 * @param content
	 * @return boolean
	 */
	public static boolean writeContentToFile(String folderpath,String fileName,List<String> content)
	{
		try 
		{
			File fl = new File(folderpath, fileName);
			FileWriter fw = new FileWriter(fl);
			
			for (String s:content)
			{
				fw.write(s+"\n");
			}
			fw.close();
			return true;
			
		}catch(Exception Ex)
		{
			return false;
		}
	}
	
	/**
	 * This method delete the file if it exists 
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFile(String folderpath, String fileName)
	{
				File file=new File(folderpath+"\\"+fileName);
		try
		{
			if(file.delete())
				return true;
			else
				return false;
		}catch(Exception Ex)
		{
			return false	;
		}
		
	}
	/**
	 * This method will search the file from the folder
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		File file=new File(folderpath+"\\"+fileName);
		
		if(file.exists())
			return true;
		else 
			return false;
	}
	
	
}
