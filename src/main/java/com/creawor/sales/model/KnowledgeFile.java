package com.creawor.sales.model;

import com.creawor.sales.common.Const;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Zero on 2017/5/11.
 * 知识库-文件
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_KNOWLEDGE_FILE")
public class KnowledgeFile {
    /**
     * null
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String uid;
    /**
     * 文件名称
     */
    @Column(name = "file_name", length = 100)
    private String fileName;
    /**
     * 文件大小
     */
    @Column(name = "file_size")
    private int fileSize;
    /**
     * 文件后缀
     */
    @Column(name = "file_suffix", length = 32)
    private String fileSuffix;

    /**
     * 上传者
     */
    @Column(name = "user_id", length = 50)
    private String userId;
    /**
     * 上传时间
     */
    @Column(name = "up_date", length = 100)
    private String upDate;
    /**
     * 阅读量
     */
    @Column(name = "read_count")
    private int readCount;
    /**
     * 下载量
     */
    @Column(name = "download_count")
    private int downloadCount;

    /**
     * 文件分类Id
     */
    @Column(name = "type_id", length = 100)
    private String typeId;
    /**
     * 保存磁盘地址
     */
    @Column(name = "address", length = 255)
    private String filePath;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpDate() {
        return upDate;
    }

    public void setUpDate(String upDate) {
        this.upDate = upDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
