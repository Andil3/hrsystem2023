
package com.andile.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import com.andile.hrsystem.common.AddressType;

/**
 *
 * @author S2026080
 */
@Entity
@Table(name = "address")
@Getter
@Setter
public class Address extends BaseEntity {
    
     @Column(name = "address_line_1")
    private String addressLine1;
    
    @Column(name = "address_line_2")
    private String addressLine2;
    
    @Column(name = "area")
    private String area;
    
    @Column(name = "code")
    private String code;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType addressType;
}
