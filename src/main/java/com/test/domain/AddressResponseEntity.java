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
@Entity(name = "AdressResponse")
public class AddressResponseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    private Date dateTime;
    @Column(unique = true)
    private Integer zipCode;
    private String formattedAddress;
    private Double latitude;
    private Double longitude;

}
