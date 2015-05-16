package de.hska.wi.awp.bestpractise.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import de.hska.wi.awp.bestpractise.utils.Constants;
import de.hska.wi.awp.bestpractise.utils.DataStore;
import de.hska.wi.awp.bestpractise.utils.JsonParser;
import static org.junit.Assert.*;

public class JsonParserTest {
	
	@Test
	public void parseJsonToIssue() throws Exception{
		//get string for two issues - hard coded
		String pathToFile = Constants.PATH_CACHE_FOLDER + "/" + "JiraTest" + "/"
				+ "Jira_2IssuesTest.txt";
		File file = new File(pathToFile);
		
		String json2IssuesAsString = "";
		if (file.exists()) {
			InputStream is = new FileInputStream(pathToFile);
			json2IssuesAsString = IOUtils.toString(is);
		}
		
		//call method parseJsonToIssue
		JsonParser parser = new JsonParser();
		parser.ParseJsonToIssue(json2IssuesAsString);
		
		//verify the results
		assertSame("They are not exactly 2 issues created", 2, DataStore.getInstance().getAllIssues.size());
		
	}

}
