package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Line")
@XmlAccessorType(XmlAccessType.FIELD)
public class Line implements Serializable {
    @XmlElement(name = "Line-Item")
    private LineItem lineItem;

    @XmlElement(name = "Line-Parties")
    private LineParties lineParties;

    @Override
    public String toString() {
        return "Line{" +
                "lineItem=" + lineItem +
                ", lineParties=" + lineParties +
                '}';
    }
}
