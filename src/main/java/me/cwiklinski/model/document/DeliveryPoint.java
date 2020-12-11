package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "DeliveryPoint")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryPoint implements Serializable {
    private String ILN;
    private String Name;

    @Override
    public String toString() {
        return "DeliveryPoint{" +
                "ILN='" + ILN + '\'' +
                ", name='" + Name + '\'' +
                '}';
    }
}
