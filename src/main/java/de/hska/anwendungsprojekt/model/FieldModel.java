package de.hska.anwendungsprojekt.model;

/**
 * BestPractise
 * 
 * Model for Field
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
public class FieldModel {

	private CreatorModel creator;
	private String resolutionDate;
	private String createdDate;
	private String updated;
	private String summary;
	private AssigneeModel assignee;
	private StatusModel status;
	
	
	public CreatorModel getCreator() {
		return creator;
	}
	public void setCreator(CreatorModel creator) {
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
	public StatusModel getStatus() {
		return status;
	}
	public void setStatus(StatusModel status) {
		this.status = status;
	}
	public AssigneeModel getAssignee() {
		return assignee;
	}
	public void setAssignee(AssigneeModel assignee) {
		this.assignee = assignee;
	}	
}
