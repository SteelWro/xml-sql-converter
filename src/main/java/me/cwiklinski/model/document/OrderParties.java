package me.cwiklinski.model.rootModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Order-Parties")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderParties implements Serializable {
    @XmlElement(name = "Buyer")
    private Buyer buyer;

    @XmlElement(name = "Seller")
    private Seller seller;

    @XmlElement(name = "DeliveryPoint")
    private DeliveryPoint deliveryPoint;

    @XmlElement(name = "ShipFrom")
    private ShipFrom shipFrom;


    @Override
    public String toString() {
        return "OrderParties{" +
                "buyer=" + buyer +
                ", seller=" + seller +
                ", deliveryPoint=" + deliveryPoint +
                ", shipFrom=" + shipFrom +
                '}';
    }
}
