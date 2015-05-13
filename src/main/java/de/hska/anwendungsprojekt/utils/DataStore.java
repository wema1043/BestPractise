package de.hska.anwendungsprojekt.utils;

import java.util.ArrayList;

import de.hska.anwendungsprojekt.model.IssueModel;

/**
 * BestPractise
 * 
 * DataStore for all Datas
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
public class DataStore {

	private static DataStore sInstance = new DataStore();
	
	public static DataStore getInstance(){
		return sInstance;
	}
	
	public ArrayList<IssueModel> getAllIssues = new ArrayList<IssueModel>();


}
