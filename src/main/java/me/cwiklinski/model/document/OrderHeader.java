package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Order-Header")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderHeader implements Serializable {
    private String OrderNumber;
    private String VendorOrderNumber;
    private String OrderDate;
    private String OrderTime; // todo data lub string
    private String DocumentFunctionCode;
    private String MessageType;

    @Override
    public String toString() {
        return "OrderHeader{" +
                "orderNumber='" + OrderNumber + '\'' +
                ", VendorOrderNumber=" + VendorOrderNumber +
                ", OrderDate=" + OrderDate +
                ", orderTime='" + OrderTime + '\'' +
                ", DocumentFunctionCode='" + DocumentFunctionCode + '\'' +
                ", messageType='" + MessageType + '\'' +
                '}';
    }
}
