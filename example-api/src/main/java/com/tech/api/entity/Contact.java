package com.tech.api.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "contact", indexes = {
        @Index(columnList = "name", name = "name_hidx")
})
public class Contact implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updateAt;

}
