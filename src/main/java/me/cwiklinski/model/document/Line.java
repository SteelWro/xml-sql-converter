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

    public LineItem getLineItem() {
        return lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public LineParties getLineParties() {
        return lineParties;
    }

    public void setLineParties(LineParties lineParties) {
        this.lineParties = lineParties;
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineItem=" + lineItem +
                ", lineParties=" + lineParties +
                '}';
    }
}
