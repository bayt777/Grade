package com.parator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

/**
 * Compare files on directories
 *
 */
public class Comparator {
	
	static String a = "";
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter path to directory (For example: \"C:/Bayt/Grade\")");
			a = sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

        List<File> files = getFiles(a);
		compare(files);
		
		files = getFiles(a);
        System.out.println("\n-----------------------");
        System.out.println("New name files");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
    		if (file.length() != file.length()) {
    			System.out.println(file.getAbsolutePath());
    		}
        }
    }
    

  //-------------------------------------------------------------------------------------/  
    public static List<File> getFiles(String folderPath) {
        List<File> filesList = new ArrayList<File>();
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles!=null){
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    filesList.add(file);
                }
            }
        }
        return filesList;
    }

	public static void compare(List<File> files) throws Exception {

    	for (int i = 0; i < files.size(); i++) {
    		  for (int j = i+1; j < files.size(); j++) {
    		        System.out.println("\n-----------------------");
    				System.out.println(files.get(i).getName());
    				System.out.println(files.get(j).getName());
    				if (!FileUtils.contentEquals(files.get(i), files.get(j))) {
    					System.out.println("Files is different");    					
    				}  else { 
    			        renameFile(files.get(i).getName().trim(), files.get(j).getName().trim());
    				}
    		  }
		}
	}

	public static void renameFile(String path1, String path2) {

		File dir = new File(a);
		
		File file1 = new File(dir + "//" + path1);
		File dublicateFile1 = new File(dir + "//" +"dublicated"+ path1);
		File file2 = new File(dir + "//" + path2);
		File dublicateFile2 = new File(dir + "//" +"dublicated"+ path2);
		if(file1.renameTo(dublicateFile1) && file2.renameTo(dublicateFile2)){
			System.out.println("File renamed");
		}else{
			System.out.println("ERROR!!! Файл не был переименован");
		}		
	}
	
}
