package com.pch.auth.authorization.model.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.pch.common.base.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: pch
 * @Date: 2020/9/11
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@EntityListeners({ AuditingEntityListener.class })
@Table(name = "tb_permission")
public class PermissionPo extends BasePo {
    private static final long serialVersionUID = 4285835478693487481L;

    private Integer pid;

    private Integer type;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String code;

    @Column(length = 150)
    private String uri;

    private Integer seq = 1;

    @Column(updatable = false, length = 32)
    private String createBy;

    /**
     * 更新人
     */
    @Column(length = 32)
    private String updatedBy;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private LocalDateTime updateTime;

}
