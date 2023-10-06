
package com.training.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stud" type="{http://ws.training.com}Student"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "stud"
})
@XmlRootElement(name = "addStudent")
public class AddStudent {

    @XmlElement(required = true)
    protected Student stud;

    /**
     * Gets the value of the stud property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getStud() {
        return stud;
    }

    /**
     * Sets the value of the stud property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setStud(Student value) {
        this.stud = value;
    }

}
