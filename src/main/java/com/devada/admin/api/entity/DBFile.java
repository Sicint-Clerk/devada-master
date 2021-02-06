package com.devada.admin.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.devada.base.entity.KKEntity;

@Entity
@Table(name = "Ads_Table")
public class DBFile extends KKEntity {

	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    private String imageInStr;
    
    @Column
    private String adDesc;
    
    
    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data,String desc) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.adDesc = desc;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getImageInStr() {
		return imageInStr;
	}

	public void setImageInStr(String imageInStr) {
		this.imageInStr = imageInStr;
	}

	public String getAdDesc() {
		return adDesc;
	}

	public void setAdDesc(String adDesc) {
		this.adDesc = adDesc;
	}
	
	
}
