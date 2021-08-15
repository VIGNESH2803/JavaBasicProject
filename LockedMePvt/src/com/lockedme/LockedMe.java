package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMe {

	static final String folderPath = "C:\\Users\\svigne28\\Desktop\\ProjectFiles\\Files";
	
	

	public static void main(String[] args)
	
	{
		// TODO Auto-generated method stub
		
		int choise;
		
	
		choise=displayMainMenu();
		
		do 
		{
		
			switch(choise) {
			  case 1:
			    displayFiles();
			    choise=displayMainMenu();
			    break;
			  case 2:
				  searchFiles();
				  choise=displayMainMenu();
			      break;
			  case 3:
				  createFile();
				  choise=displayMainMenu();
				  break;
			  case 4:
				  deleteFile();
				  choise=displayMainMenu();
				  break;
			  case 5:
				  System.exit(0);
			  default:
			    System.out.println("Enter Valid Option");
			    choise=displayMainMenu();
			}		
				
		}while(choise!=5);
		

	}
	
	public static int displayMainMenu()
	{
		
		System.out.println("***********************************************************");
		System.out.println("\t \t Lockedme.com\t\t ");
		System.out.println("***********************************************************");
		System.out.println("1. DISPLAY FILES");
		System.out.println("2. SEARCH  FILE");
		System.out.println("3. CREATE  FILE");
		System.out.println("4. Delete  FILE");
		System.out.println("5. Exit ");
		System.out.println("***********************************************************");
		System.out.println("ENTER YOUR CHOISE : ");
		
		try
		{
			Scanner obj=new Scanner(System.in);
			
			int choice=Integer.parseInt(obj.nextLine());
			return choice;
		}
		
		catch (Exception ex)
		{
			System.out.println("Invalid Input");
			return 0;
		}
		
		
		
	}
	
	public static void searchFiles()
	{
		
		Scanner obj=new Scanner(System.in);
		
		System.out.println("Enter the File Name to be seached");
		
		String searchFile=obj.nextLine();
		
		boolean isFound;
		
		isFound=FileManager.searchFiles(folderPath,searchFile);
		
		if(isFound)
			System.out.println("File is available in the directory");
		else
			System.out.println("File is not available in the directory : 404 ");
		
	}
	
	public static void displayFiles()
	{
		List<String> fileNames=FileManager.getAllFiles(folderPath);
		
		System.out.println("******** LIST OF FILES *********");
		
		
		for(String f:fileNames)
			System.out.println(f);
		
		System.out.println("******** END OF LIST *********");
	}
	
	public static void createFile()
	{
		
		System.out.println("********** CREATE FILE **********");
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the File Name to be created");
		String fileName;
		int linesCount;
		List<String> content= new ArrayList<String>();
		
		fileName=obj.nextLine();
		
		System.out.println("Enter home many line : ");
		linesCount=Integer.parseInt(obj.nextLine());
		
		for(int i=1;i<=linesCount;i++)
		{
			System.out.println("enter the line number "+i+":");
			content.add(obj.nextLine());
		}
		
		boolean	isSaved=FileManager.createFile(folderPath, fileName, content);
		
		if(isSaved)
			System.out.println("File Saved successfully ");
		else
			System.out.println("Exception while creating file");
		
		System.out.println("****************************");
	
		
		
	}

	public static void deleteFile()
	{
		System.out.println("********** DELETE FILE****************");
		
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the File Name to be Deleted");
		String fileName;
		
		fileName=obj.nextLine();
		
		boolean isDeleted=FileManager.deleteFile(folderPath, fileName);
		
		if(isDeleted)
			System.out.println("File Deleted Successfully");
		else
			System.out.println("File is not available in directory to delete or permission issue");
	
		
	}
}
