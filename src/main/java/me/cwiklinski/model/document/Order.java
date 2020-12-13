package me.cwiklinski.model.document;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "Document-Order")
    List<DocumentOrder> documentOrders;

    public List<DocumentOrder> getDocumentOrders() {
        return documentOrders;
    }

    public void setDocumentOrders(List<DocumentOrder> documentOrders) {
        this.documentOrders = documentOrders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "documentOrders=" + documentOrders +
                '}';
    }
}
