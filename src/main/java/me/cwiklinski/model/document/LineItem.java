package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Line-Item")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineItem implements Serializable {
    private String LineNumber;
    private String EAN;
    private String OrderedQuantity;
    private String UnitOfMeasure;
    private String ExpectedDeliveryDate;
    private String ExpectedDeliveryTime;

    @Override
    public String toString() {
        return "LineItem{" +
                "LineNumber='" + LineNumber + '\'' +
                ", EAN='" + EAN + '\'' +
                ", OrderedQuantity='" + OrderedQuantity + '\'' +
                ", UnitOfMeasure='" + UnitOfMeasure + '\'' +
                ", ExpectedDeliveryDate='" + ExpectedDeliveryDate + '\'' +
                ", ExpectedDeliveryTime='" + ExpectedDeliveryTime + '\'' +
                '}';
    }
}
