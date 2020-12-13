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
    private int OrderedQuantity;
    private String UnitOfMeasure;
    private String ExpectedDeliveryDate;
    private String ExpectedDeliveryTime;

    public String getLineNumber() {
        return LineNumber;
    }

    public void setLineNumber(String lineNumber) {
        LineNumber = lineNumber;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public int getOrderedQuantity() {
        return OrderedQuantity;
    }

    public void setOrderedQuantity(int orderedQuantity) {
        OrderedQuantity = orderedQuantity;
    }

    public String getUnitOfMeasure() {
        return UnitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        UnitOfMeasure = unitOfMeasure;
    }

    public String getExpectedDeliveryDate() {
        return ExpectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        ExpectedDeliveryDate = expectedDeliveryDate;
    }

    public String getExpectedDeliveryTime() {
        return ExpectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
        ExpectedDeliveryTime = expectedDeliveryTime;
    }

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
