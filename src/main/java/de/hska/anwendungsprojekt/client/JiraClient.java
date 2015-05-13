package de.hska.anwendungsprojekt.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hska.anwendungsprojekt.utils.Constants;
import sun.misc.BASE64Encoder;

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
	 * 
	 * @return response String
	 * 
	 * @throws Exception
	 */
	public static String getAllIssues() throws Exception {

		String url = "http://www.iwi.hs-karlsruhe.de/awpjira/rest/api/2/search?jql=project=HWB&maxResults=-1";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		BASE64Encoder enc = new sun.misc.BASE64Encoder();
		String userpassword = Constants.USERNAME + ":" + Constants.PASSWORD;
		String encodedAuthorization = enc.encode(userpassword.getBytes());
		con.setRequestProperty("Authorization", "Basic " + encodedAuthorization);

		// add request header
		con.setRequestProperty("User-Agent", Constants.USER_AGENT);

		
		System.out.println(con.getResponseCode());
		
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();

	}

}

