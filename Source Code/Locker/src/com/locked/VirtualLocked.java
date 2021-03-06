package com.locked;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VirtualLocked 
{
	static final String folderpath="D:\\My phase1 Project\\Lockedfiles";

	public static void main(String[] args) 
	{
		int proceed=1;
		
		
		do
		
		{
		//variable declaration
		
		
		Scanner obj= new Scanner(System.in);
		int  ch;
		//Menu
		displayMenu();
		System.out.println("Enter the choice:");
		ch=Integer.parseInt(obj.nextLine());
		
		switch(ch)
		{
		case 1 : getAllFiles(); 
		         break;
		case 2 :  createFiles();
		         break;
		case 3 :  deleteFiles();
		         break;
		case 4:  searchFiles();
		         break;
		case 5:  System.exit(0);
		         break;
		default : System.out.println("Invalid option");         
		         break;
		
		}
		}while(proceed>0);
		
		
		
	}
	public static void displayMenu()
	{
		System.out.println("*************************************");
		System.out.println("\tCompany Lockers pvt ltd");
		System.out.println("*************************************");
		System.out.println("1.Display all files");
		System.out.println("2.Add files");
		System.out.println("3.Delete files");
		System.out.println("4.Search files");
		System.out.println("5.Exit");
		
		System.out.println("*************************************");
	
	}
	/**
	 * Method for all files
	 */
	public  static void getAllFiles()
	{
List<String> fileNames=FileManager.getAllFiles(folderpath);
		
	    for(String f:fileNames)	
  	System.out.println(f);
	}
	/**
	 * Method for creating files
	 */
	public  static void createFiles()
	{
		Scanner obj = new Scanner(System.in);	
		String  fileNames;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		//Read file name user
		System.out.println("Enter the File Name");
		fileNames=obj.nextLine();
		
		//read no. of line from the user
		System.out.println("Enter how many lines in the files");
		linesCount=Integer.parseInt(obj.nextLine());
		
		//read no. of line from the user
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("Enter the line "+i+":");
			content.add(obj.nextLine());
		}
		//save the content into the file
		boolean isSaved = FileManager.writeContentToFile(folderpath, fileNames, content);
				if(isSaved)
					System.out.println("File and data save successfully");
				else
				     System.out.println("Some error occurred Please contact @admin");
		//close obj
		//obj.close();
		
	/**
	 *Method  For deleting files	
	 */
	}
	public static void deleteFiles()
	{
		 String fileName;
	     Scanner obj=new Scanner(System.in);
	     System.out.println("Enter file name to be deleted");
	     
	     fileName=obj.nextLine();
	     
	     boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
	     
	     if(isDeleted)
	    	 System.out.println("File deleted Succussfully");
	     else
	     System.out.println("Either file not there or some access issue");
	    // obj.close();
	}
	/**
	 * Method for searching files
	 */
	
	public static void searchFiles()
	{
		 String fileName;
	     Scanner obj=new Scanner(System.in);
	     System.out.println("Enter file name to be Search:");
	     
	     fileName=obj.nextLine();
	     
	     boolean isFound = FileManager.searchFile(folderpath, fileName);
	     
	     if(isFound)
	    	 System.out.println("File is present in the Folder");
	     else
	     System.out.println("File is not present in the folder");
	     //obj.close();
	}

}
