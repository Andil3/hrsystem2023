package com.andile.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author S2026080
 */
@Entity
@Table(name = "contacts")
@Getter
@Setter
public class ContactDetails extends BaseEntity {

    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "landline")
    private String landLine;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "facebook_username")
    private String facebookHandle;
    @Column(name = "liknedin_username")
    private String linkedIn;
    @Column(name = "instagram_handle")
    private String instagram;
    @Column(name = "twitter_handle")
    private String twitterHandle;
    @Column(name = "whatsapp_username")
    private String whatsapp;

}
