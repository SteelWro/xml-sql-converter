package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Seller")
@XmlAccessorType(XmlAccessType.FIELD)
public class Seller implements Serializable {
    private String ILN;

    @Override
    public String toString() {
        return "Seller{" +
                "ILN='" + ILN + '\'' +
                '}';
    }
}
