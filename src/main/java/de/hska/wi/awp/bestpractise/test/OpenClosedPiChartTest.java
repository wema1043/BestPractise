package de.hska.wi.awp.bestpractise.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.model.chart.PieChartModel;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import de.hska.wi.awp.bestpractise.bean.JsfCharts.OpenClosedPiChart;
import de.hska.wi.awp.bestpractise.service.JiraClient;
import de.hska.wi.awp.bestpractise.utils.Constants;
import de.hska.wi.awp.bestpractise.utils.CacheFile;
import de.hska.wi.awp.bestpractise.utils.DataStore;

public class OpenClosedPiChartTest {
	
	static String date = "";
	
	@BeforeClass
	public static void setUp(){
		// get Date
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		Calendar cal = Calendar.getInstance();
		date = dateFormat.format(cal.getTime());
	}
	
	
	@Test
	public void getPieModelTest() throws Exception{
		//get string for two issues - hard coded
		String pathToFile = Constants.PATH_CACHE_FOLDER + "/" + "JiraTest" + "/"
						+ "Jira_2IssuesTest.txt";
		File file = new File(pathToFile);
		
		String json2IssuesAsString = "";
		if (file.exists()) {
			InputStream is = new FileInputStream(pathToFile);
			json2IssuesAsString = IOUtils.toString(is);
		}
		
		//mock jira client
		JiraClient client = Mockito.mock(JiraClient.class);
		when(client.getAllIssues()).thenReturn(json2IssuesAsString);
		client.getAllIssues();
		
		//Create cache file
		CacheFile.createCacheFile("JIRA", "All_ISSUES", date, json2IssuesAsString);
		
		//create piModel
		OpenClosedPiChart chart = new OpenClosedPiChart();
		PieChartModel pieModel = chart.getPieModel();
		
		assertSame("Legend position ist not w", "w", pieModel.getLegendPosition());
		assertSame("Data Label is not showing",true,pieModel.isShowDataLabels());
		assertSame("They are not exactly 2 issues created", 2, DataStore.getInstance().getAllIssues.size());
		
	}
	
	@AfterClass
	public static void clean(){
		// delete cache file	
		CacheFile.deleteCacheFile("JIRA", "All_ISSUES", date);
	}

}
