package de.hska.anwendungsprojekt.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import de.hska.anwendungsprojekt.client.JiraClient;
import de.hska.anwendungsprojekt.model.*;

/**
 * BestPractise
 * 
 * Parse json strings
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
public class JsonParser {

	/**
	 * parse the json string to Java-model
	 * 
	 * @throws JSONException
	 */
	public static void ParseJsonToIssue() throws JSONException {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(JiraClient.getAllIssues());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONArray tasks = jsonObject.getJSONArray("issues");

		ArrayList<IssueModel> allIssues = new ArrayList<IssueModel>();
		
		for (int zl = 0; zl < tasks.length(); zl++) {
			IssueModel myIssue = new IssueModel();
			FieldModel myField = new FieldModel();
			CreatorModel myCreator = new CreatorModel();
			StatusModel myStatus = new StatusModel();
			AssigneeModel myAssignee = new AssigneeModel();
			myIssue.setId((tasks.getJSONObject(zl).getString("id")));
			myIssue.setKey((tasks.getJSONObject(zl).getString("key")));
			myIssue.setSelf((tasks.getJSONObject(zl).getString("self")));
			
			myField.setCreatedDate((tasks.getJSONObject(zl).getJSONObject("fields").getString("created")));
			myField.setSummary((tasks.getJSONObject(zl).getJSONObject("fields").getString("summary")));
			myField.setUpdated((tasks.getJSONObject(zl).getJSONObject("fields").getString("updated")));
			myField.setResolutionDate((tasks.getJSONObject(zl).getJSONObject("fields").getString("resolutiondate")));
			
			if(!tasks.getJSONObject(zl).getJSONObject("fields").isNull("assignee")){
			myAssignee.setName((tasks.getJSONObject(zl).getJSONObject("fields").getJSONObject("assignee").getString("displayName")));
			}
			myCreator.setName((tasks.getJSONObject(zl).getJSONObject("fields").getJSONObject("creator").getString("displayName")));
			
			myStatus.setName((tasks.getJSONObject(zl).getJSONObject("fields").getJSONObject("status").getString("name")));
			
			myField.setCreator(myCreator);
			myField.setStatus(myStatus);
			myField.setAssignee(myAssignee);

			
			myIssue.setField(myField);
			
			allIssues.add(myIssue);
		}
		DataStore.getInstance().getAllIssues = allIssues;
		
	}
}
