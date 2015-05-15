package de.hska.wi.awp.bestpractise.test;

import org.junit.Test;
import static org.junit.Assert.*;

import de.hska.wi.awp.bestpractise.service.JiraClient;
import de.hska.wi.awp.bestpractise.utils.DataStore;
import de.hska.wi.awp.bestpractise.utils.JsonParser;

public class JiraClientTest {

	@Test
	public void checkJiraAPIDatenModel() throws Exception{
		JiraClient client = new JiraClient();
		JsonParser parser = new JsonParser();
		parser.ParseJsonToIssue(client.getAllIssues());
		assertTrue("Issues können nicht gefunden werden", DataStore.getInstance().getAllIssues.size()>0);
	}
}
