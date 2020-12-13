package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Document-Order")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentOrder implements Serializable {
    @XmlElement(name = "Order-Header")
    private OrderHeader orderHeader;

    @XmlElement(name = "Order-Parties")
    private OrderParties orderParties;

    @XmlElement(name = "Order-Lines")
    private OrderLines orderLines;

    @XmlElement(name = "Order-Summary")
    private OrderSummary orderSummary;

    public OrderHeader getOrderHeader() {
        return orderHeader;
    }


    public OrderParties getOrderParties() {
        return orderParties;
    }

    public OrderLines getOrderLines() {
        return orderLines;
    }

    public OrderSummary getOrderSummary() {
        return orderSummary;
    }

    @Override
    public String toString() {
        return "DocumentOrder{" +
                "orderHeader=" + orderHeader +
                ", orderParties=" + orderParties +
                ", orderLines=" + orderLines +
                ", orderSummary=" + orderSummary +
                '}';
    }
}
