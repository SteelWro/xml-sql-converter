package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Order-Summary")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderSummary implements Serializable {
    private String TotalLines;

    @Override
    public String toString() {
        return "OrderSummary{" +
                "TotalLines='" + TotalLines + '\'' +
                '}';
    }
}
