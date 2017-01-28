package com.test.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class ZipCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    private Date dateTime;
    private Integer searchRequest;
    @Column(columnDefinition = "TEXT")
    private String searchResult;

}
