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

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getVendorOrderNumber() {
        return VendorOrderNumber;
    }

    public void setVendorOrderNumber(String vendorOrderNumber) {
        VendorOrderNumber = vendorOrderNumber;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(String orderTime) {
        OrderTime = orderTime;
    }

    public String getDocumentFunctionCode() {
        return DocumentFunctionCode;
    }

    public void setDocumentFunctionCode(String documentFunctionCode) {
        DocumentFunctionCode = documentFunctionCode;
    }

    public String getMessageType() {
        return MessageType;
    }

    public void setMessageType(String messageType) {
        MessageType = messageType;
    }

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
