package com.bank.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "param")
public class ConfigUtils {
	
    private String demandPath;
    
    private String achievePath;
    
    private Integer adminId;
    
    private Integer missDb;
    
    private Integer recordNumDb;
    
    private Integer recordsDb;

	public String getDemandPath() {
		return demandPath;
	}

	public void setDemandPath(String demandPath) {
		this.demandPath = demandPath;
	}

	public String getAchievePath() {
		return achievePath;
	}

	public void setAchievePath(String achievePath) {
		this.achievePath = achievePath;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getMissDb() {
		return missDb;
	}

	public void setMissDb(Integer missDb) {
		this.missDb = missDb;
	}

	public Integer getRecordNumDb() {
		return recordNumDb;
	}

	public void setRecordNumDb(Integer recordNumDb) {
		this.recordNumDb = recordNumDb;
	}

	public Integer getRecordsDb() {
		return recordsDb;
	}

	public void setRecordsDb(Integer recordsDb) {
		this.recordsDb = recordsDb;
	}

	
  
}
