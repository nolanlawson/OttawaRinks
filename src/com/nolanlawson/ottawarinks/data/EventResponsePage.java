package com.nolanlawson.ottawarinks.data;

import java.util.List;

/**
 * page of results from the Ottawa Public Skating Schedules website
 * @author nlawson
 *
 */
public class EventResponsePage {

	private List<EventResponse> eventResponses;
	private int startRow;
	private int toRow;
	private int totalRows;
	public List<EventResponse> getEventResponses() {
		return eventResponses;
	}
	public void setEventResponses(List<EventResponse> eventResponses) {
		this.eventResponses = eventResponses;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getToRow() {
		return toRow;
	}
	public void setToRow(int toRow) {
		this.toRow = toRow;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
}
