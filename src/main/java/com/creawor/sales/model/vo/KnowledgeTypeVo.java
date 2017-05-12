package com.creawor.sales.model.vo;

import com.creawor.sales.model.KnowledgeType;

/**
 * Created by Zero on 2017/5/11.
 *
 */
public class KnowledgeTypeVo extends KnowledgeType {
    private int fileCount;

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }
}
