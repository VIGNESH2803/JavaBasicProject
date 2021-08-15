package com.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	public static List<String> getAllFiles(String folderPath)

	{
		File fl= new File(folderPath);
		File[] listOfFiles=fl.listFiles();
		
		List<String> fileNames= new ArrayList<String>();
		
		for(File f:listOfFiles)
			fileNames.add(f.getName());
			
		return fileNames;
		
	}

	public static boolean searchFiles(String folderPath,String fileName)
	{
		 File file = new File(folderPath+"\\"+fileName);
		
		 
		 if(file.exists())
			 return true ;
		 else 
			 return false;
		 
		 		
	}
	
	/**
	 * 
	 * @param folderPath
	 * @param fileName
	 * @param Content
	 * @return boolean
	 */
	public static boolean createFile(String folderPath,String fileName,List<String> Content)
	{
		try
		{
			
			File f1= new File(folderPath,fileName);
			FileWriter fw= new FileWriter(f1);
			
			for(String s:Content)
				fw.write(s+"\n");
				
			fw.close();
			return true;
		}
		catch(Exception Ex)
		{
			
			return false;
			
		}
								
	}

	public static boolean deleteFile(String folderPath,String fileName)
	{
		File file= new File(folderPath+"\\"+fileName);
		if(file.delete())
			return true;
		else
			return false;
					
	}
	
}
