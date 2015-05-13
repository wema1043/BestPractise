package de.hska.anwendungsprojekt.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

import de.hska.anwendungsprojekt.utils.Constants;
import de.hska.anwendungsprojekt.utils.CreateCacheFile;

/**
 * BestPractise
 * 
 * Client to call Jira-Api
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
public class JiraClient {

	/**
	 * get-Request to get all issues from the group.
	 * 		send get Request only if the local file does not exist
	 * @return response String
	 * 
	 * @throws Exception
	 */
	public static String getAllIssues() throws Exception {

		String url = Constants.JIRA_URL_ALL_ISSUES;
		String auth = new String(Base64.encode(Constants.USERNAME + ":" + Constants.PASSWORD));
		
		//get Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		String pathToFile = Constants.PATH_CACHE_FOLDER + "/" + "JIRA" + "/" + "ALL_ISSUES" + date + ".txt";
		
		File file = new File(pathToFile);
		
		//send get Request only if the local file does not exist
		if (file.exists()){
            InputStream is = new FileInputStream(pathToFile);
            String jsonTxt = IOUtils.toString(is);
            return jsonTxt; 
        }else{
        	//jersey lib
    		Client client = Client.create();
    		WebResource webResource = client.resource(url);
    		
    		ClientResponse response = webResource.header("Authorization", "Basic " + auth)
    									.type("application/json").accept("application/json")
    									.get(ClientResponse.class);
    		
    		String responseBody = response.getEntity(String.class);
    		
    		//create cache File
    		CreateCacheFile.createCacheFile("JIRA", "ALL_ISSUES", date, responseBody);
    		
    		return responseBody;
        }


	}

}
