package com.ems.blog.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Attachment {
	
	/** The attachment id. */
    private String attachmentId;
    
    /** The file. */
    @NotEmpty
    private MultipartFile file;
    
    /** The file name. */
    private String fileName;
    
    /** The file type. */
    @NotEmpty
    private String fileType;
	/**
	 * @return the attachmentId
	 */
	public synchronized String getAttachmentId() {
		return attachmentId;
	}
	/**
	 * @param attachmentId the attachmentId to set
	 */
	public synchronized void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	/**
	 * @return the file
	 */
	public synchronized MultipartFile getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public synchronized void setFile(MultipartFile file) {
		this.file = file;
	}
	/**
	 * @return the fileName
	 */
	public synchronized String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public synchronized void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @return the fileType
	 */
	public synchronized String getFileType() {
		return fileType;
	}
	/**
	 * @param fileType the fileType to set
	 */
	public synchronized void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attachment [attachmentId=" + attachmentId + ", file=" + file
				+ ", fileName=" + fileName + ", fileType=" + fileType + "]";
	}
}
