package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "ShipFrom")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShipFrom implements Serializable {
    private String ILN;

    @Override
    public String toString() {
        return "ShipFrom{" +
                "ILN='" + ILN + '\'' +
                '}';
    }
}
