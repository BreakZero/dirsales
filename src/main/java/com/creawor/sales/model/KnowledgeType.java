package com.creawor.sales.model;

import com.creawor.sales.common.Const;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Zero on 2017/5/11.
 * 知识库分类
 */
@Entity
@Table(catalog = Const.DB_CATALOG, name = "TB_KNOWLEDGE_TYPE")
public class KnowledgeType {
    /**
     * uid
     */
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID", length = 32)
    private String uid;

    /**
     * 分类名称
     */
    @Column(name = "type_name", length = 50)
    private String typeName;

    /**
     * 文件分类描述
     */
    @Column(name = "type_describe", length = 100)
    private String typeDescribe;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescribe() {
        return typeDescribe;
    }

    public void setTypeDescribe(String typeDescribe) {
        this.typeDescribe = typeDescribe;
    }
}
