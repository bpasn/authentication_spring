package com.spirngauth.authentication_spring.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "shopping_session")
public class ShoppingSession {
    @Id
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Users.class)
    @JoinColumn(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = Users.class)
    @JoinColumn(name = "id")
    @Column(name = "user_id")
    private Long userId;

    private BigDecimal total;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;

    public ShoppingSession() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "ShoppingSession{" +
                "id=" + id +
                ", userId=" + userId +
                ", total=" + total +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
