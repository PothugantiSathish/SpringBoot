package com.web.user.sample_application.controller;

import java.util.List;
import java.util.Map;

public class UpdateUserRequest {
	
	 private List<String> userIds;
	 private Map<String, String> updateData;
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	public Map<String, String> getUpdateData() {
		return updateData;
	}
	public void setUpdateData(Map<String, String> updateData) {
		this.updateData = updateData;
	}
	 

}
