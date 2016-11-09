package com.be.ooxs.example.jaxb.extended;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Created by Odyssey on 09.11.2016.
 */
public enum Status {
    @XmlEnumValue(value = "pending")
    PENDING_APPROVAL,
    @XmlEnumValue(value = "active")
    ACTIVE,
    @XmlEnumValue(value = "inactive")
    INACTIVE
}
