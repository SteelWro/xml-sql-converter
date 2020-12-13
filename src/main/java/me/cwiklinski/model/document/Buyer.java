package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Buyer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer implements Serializable {
    private String ILN;

    public String getILN() {
        return ILN;
    }

    public void setILN(String ILN) {
        this.ILN = ILN;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "ILN='" + ILN + '\'' +
                '}';
    }
}
