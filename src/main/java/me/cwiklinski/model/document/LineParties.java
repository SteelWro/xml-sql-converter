package me.cwiklinski.model.rootModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Line-Parties")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineParties implements Serializable {
    @XmlElement(name = "DeliveryPoint")
    private DeliveryPoint deliveryPoint;

    @Override
    public String toString() {
        return "LineParties{" +
                "deliveryPoint=" + deliveryPoint +
                '}';
    }
}
