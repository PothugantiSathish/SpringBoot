package com.web.user.sample_application.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	    @Id
	    private String userId;
	    private String fullName;
	    private String mobNum;
	    private String panNum;
	    private String managerId;
	    private LocalDateTime createdAt;
	    public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getMobNum() {
			return mobNum;
		}

		public void setMobNum(String mobNum) {
			this.mobNum = mobNum;
		}

		public String getPanNum() {
			return panNum;
		}

		public void setPanNum(String panNum) {
			this.panNum = panNum;
		}

		public String getManagerId() {
			return managerId;
		}

		public void setManagerId(String managerId) {
			this.managerId = managerId;
		}

		private LocalDateTime updatedAt;
	    private boolean isActive;
	    
	    

	    public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public User() {}

	    public User(User user) {
	        this.fullName = user.getFullName();
	        this.mobNum = user.getMobNum();
	        this.panNum = user.getPanNum();
	        this.isActive = true;
	    }
	

}
