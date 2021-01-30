package com.salom.vasalim.demain;

import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class FileStorage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="extension")
    private String extension;

    @Column(name="fileSize")
    private Long fileSize;

    @Column(name="hashid")
    private String hashId;

    @Column(name="contentType")
    private String contentType;

    @Column(name="uploatPath")
    private String uploatPath;

    @Enumerated(EnumType.STRING)
    private FileStorageStatus fileStorageStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }


    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUploatPath() {
        return uploatPath;
    }

    public void setUploatPath(String uploatPath) {
        this.uploatPath = uploatPath;
    }

    public FileStorageStatus getFileStorageStatus() {
        return fileStorageStatus;
    }

    public void setFileStorageStatus(FileStorageStatus fileStorageStatus) {
        this.fileStorageStatus = fileStorageStatus;
    }
}
