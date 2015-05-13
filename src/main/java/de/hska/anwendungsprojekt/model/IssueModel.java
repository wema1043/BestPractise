package de.hska.anwendungsprojekt.model;

/**
 * BestPractise
 * 
 * Model for Issue
 * 
 * @author Marc Weisenburger
 * @date 2015-05-12
 *
 */
public class IssueModel {
	
	private String id;
	private String self;
	private String key;
	private FieldModel field;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public FieldModel getField() {
		return field;
	}
	public void setField(FieldModel field) {
		this.field = field;
	}


	
	
}
