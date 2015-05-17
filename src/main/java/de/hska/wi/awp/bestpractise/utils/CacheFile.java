package de.hska.wi.awp.bestpractise.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CacheFile {
	
	/**
	 * create cacheFile for getRequest only once
	 */
	public static void createCacheFile(String folder, String fileName, String date, String fileContent){
		
		String pathCacheFolder = Constants.PATH_CACHE_FOLDER;
		String pathCacheFile = pathCacheFolder + "/" + folder + "/" + fileName +date + ".txt";
		
		try
		 {
		    File file = new File( pathCacheFile );

		    // if file doesnt exists, then create it 
		    if ( ! file.exists( ) )
		    {
		        file.createNewFile( );
		    }

		    FileWriter fw = new FileWriter( file.getAbsoluteFile( ) );
		    BufferedWriter bw = new BufferedWriter( fw );
		    bw.write( fileContent );
		    bw.close( );
		    //System.out.println("Done writing to " + fileName); //For testing 
		 }
		 catch( IOException e )
		 {
		 System.out.println("Error: " + e);
		 e.printStackTrace( );
		 }
		
	}
	
	public static void deleteCacheFile(String folder, String fileName, String date){
		String pathCacheFolder = Constants.PATH_CACHE_FOLDER;
		String pathCacheFile = pathCacheFolder + "/" + folder + "/" + fileName +date + ".txt";
		
	    // A File object to represent the filename
	    File f = new File(pathCacheFile);

	    // Make sure the file or directory exists and isn't write protected
	    if (!f.exists())
	      throw new IllegalArgumentException(
	          "Delete: no such file or directory: " + fileName);

	    if (!f.canWrite())
	      throw new IllegalArgumentException("Delete: write protected: "
	          + fileName);

	    // If it is a directory, make sure it is empty
	    if (f.isDirectory()) {
	      String[] files = f.list();
	      if (files.length > 0)
	        throw new IllegalArgumentException(
	            "Delete: directory not empty: " + fileName);
	    }

	    // Attempt to delete it
	    boolean success = f.delete();

	    if (!success){
	      throw new IllegalArgumentException("Delete: deletion failed");
	  }else{
		  System.out.println("File was deleted");
	  }
	}


}
