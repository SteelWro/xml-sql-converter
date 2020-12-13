package me.cwiklinski.model.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Order-Lines")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLines implements Serializable {
    @XmlElement(name = "Line")
    private Line line;

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "OrderLines{" +
                "line=" + line +
                '}';
    }
}
