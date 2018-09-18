package org.myrh.entities;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file")

public class FileStorageProperties {
	
	public FileStorageProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
	

}
