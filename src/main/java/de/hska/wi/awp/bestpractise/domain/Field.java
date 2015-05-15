package de.hska.wi.awp.bestpractise.domain;

/**
 * BestPractise
 * 
 * Model for Field
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
public class Field {

	private Creator creator;
	private String resolutionDate;
	private String createdDate;
	private String updated;
	private String summary;
	private Assignee assignee;
	private Status status;
	
	
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	public String getResolutionDate() {
		return resolutionDate;
	}
	public void setResolutionDate(String resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Assignee getAssignee() {
		return assignee;
	}
	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}	
}
