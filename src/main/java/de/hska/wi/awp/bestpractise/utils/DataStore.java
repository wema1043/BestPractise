package de.hska.wi.awp.bestpractise.utils;

import java.util.ArrayList;

import de.hska.wi.awp.bestpractise.domain.Issue;

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
	
	public ArrayList<Issue> getAllIssues = new ArrayList<Issue>();


}
