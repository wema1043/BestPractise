package de.hska.wi.awp.bestpractise.utils;

import java.util.ArrayList;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import de.hska.wi.awp.bestpractise.domain.*;

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
	 * @throws Exception
	 */
	public void ParseJsonToIssue(String response) throws Exception {

		JSONObject jsonObject = new JSONObject(response);

		JSONArray tasks = jsonObject.getJSONArray("issues");

		ArrayList<Issue> allIssues = new ArrayList<Issue>();

		for (int zl = 0; zl < tasks.length(); zl++) {
			Issue myIssue = new Issue();
			Field myField = new Field();
			Creator myCreator = new Creator();
			Status myStatus = new Status();
			Assignee myAssignee = new Assignee();
			myIssue.setId((tasks.getJSONObject(zl).getString("id")));
			myIssue.setKey((tasks.getJSONObject(zl).getString("key")));
			myIssue.setSelf((tasks.getJSONObject(zl).getString("self")));

			myField.setCreatedDate((tasks.getJSONObject(zl).getJSONObject(
					"fields").getString("created")));
			myField.setSummary((tasks.getJSONObject(zl).getJSONObject("fields")
					.getString("summary")));
			myField.setUpdated((tasks.getJSONObject(zl).getJSONObject("fields")
					.getString("updated")));
			myField.setResolutionDate((tasks.getJSONObject(zl).getJSONObject(
					"fields").getString("resolutiondate")));

			if (!tasks.getJSONObject(zl).getJSONObject("fields")
					.isNull("assignee")) {
				myAssignee.setName((tasks.getJSONObject(zl)
						.getJSONObject("fields").getJSONObject("assignee")
						.getString("displayName")));
			}
			myCreator.setName((tasks.getJSONObject(zl).getJSONObject("fields")
					.getJSONObject("creator").getString("displayName")));

			myStatus.setName((tasks.getJSONObject(zl).getJSONObject("fields")
					.getJSONObject("status").getString("name")));

			myField.setCreator(myCreator);
			myField.setStatus(myStatus);
			myField.setAssignee(myAssignee);

			myIssue.setField(myField);

			allIssues.add(myIssue);
		}
		DataStore.getInstance().getAllIssues = allIssues;

	}
}
