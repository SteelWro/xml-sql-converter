package me.cwiklinski.model.document;

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

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public DeliveryPoint getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(DeliveryPoint deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public ShipFrom getShipFrom() {
        return shipFrom;
    }

    public void setShipFrom(ShipFrom shipFrom) {
        this.shipFrom = shipFrom;
    }

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
