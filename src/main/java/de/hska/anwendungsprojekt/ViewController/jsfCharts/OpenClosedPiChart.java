package de.hska.anwendungsprojekt.ViewController.jsfCharts;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;

import org.primefaces.json.JSONException;
import org.primefaces.model.chart.PieChartModel;

import de.hska.anwendungsprojekt.model.IssueModel;
import de.hska.anwendungsprojekt.utils.DataStore;
import de.hska.anwendungsprojekt.utils.JsonParser;

/**
 * BestPractise
 * 
 * Build PieChartModel
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
@ManagedBean(name = "openClosedPiChart")
public class OpenClosedPiChart {

	/**
	 * build a PieChart Model
	 * 
	 * @return PieChartModel
	 * @throws Exception 
	 */
	public PieChartModel getPieModel() {
		try {
			JsonParser.ParseJsonToIssue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

		HashMap<String, Integer> myMap = new HashMap<String, Integer>();

		for (IssueModel issue : DataStore.getInstance().getAllIssues) {
			if (myMap.containsKey(issue.getField().getStatus().getName())) {
				Integer tmpValue = myMap.get(issue.getField().getStatus()
						.getName()) + 1;
				myMap.put(issue.getField().getStatus().getName(), tmpValue);
			} else {
				myMap.put(issue.getField().getStatus().getName(), 1);

			}
		}

		PieChartModel pieModel = new PieChartModel();
		pieModel.setLegendPosition("w");
		pieModel.setTitle("New Issues from HSKAWI Team");
		pieModel.setShowDataLabels(true);
		for (Entry<String, Integer> entry : myMap.entrySet()) {
			pieModel.set(entry.getKey(), entry.getValue());
		}

		return pieModel;
	}

	/**
	 * get a number of Issues
	 * 
	 * @return number of Issues
	 */
	public int getCountIssues() {

		return DataStore.getInstance().getAllIssues.size();
	}

}
