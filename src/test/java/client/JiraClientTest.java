package client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import de.hska.wi.awp.bestpractise.service.JiraClient;
import de.hska.wi.awp.bestpractise.utils.CacheFile;
import de.hska.wi.awp.bestpractise.utils.DataStore;
import de.hska.wi.awp.bestpractise.utils.JsonParser;

public class JiraClientTest {
static String date = "";
	
	@BeforeClass
	public static void setUp(){
		// get Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		date = dateFormat.format(cal.getTime());
	}

	@Test
	public void checkJiraAPIDatenModel() throws Exception{
		JiraClient client = new JiraClient();
		JsonParser parser = new JsonParser();
		parser.ParseJsonToIssue(client.getAllIssues());
		
		//Check if more than one issue was found
		//if not, you have to verify if the API returns the same data structure
		//if the API returns the same data structure than we have a problem with our code 
		assertTrue("Issues not found", DataStore.getInstance().getAllIssues.size()>0);
	}
	
	@AfterClass
	public static void clean(){
		// delete cache file	
		CacheFile.deleteCacheFile("JIRA", "All_ISSUES", date);
	}
}
