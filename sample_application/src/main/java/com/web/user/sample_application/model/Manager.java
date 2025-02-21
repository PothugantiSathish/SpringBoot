package com.web.user.sample_application.model;

import java.util.UUID;

import jakarta.persistence.Id;

public class Manager {
	
	    @Id
	    private UUID id;
	    private String name;
	    private boolean isActive;
		public UUID getId() {
			return id;
		}
		public void setId(UUID id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
	    

}
