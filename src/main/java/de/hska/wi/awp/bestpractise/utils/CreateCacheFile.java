package de.hska.wi.awp.bestpractise.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCacheFile {
	
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

}
