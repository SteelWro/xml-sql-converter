package me.cwiklinski.service;

import me.cwiklinski.model.document.DocumentOrder;
import me.cwiklinski.model.document.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XmlPojoConverter {
    private DocumentOrder documentOrder;

//    public XmlPojoConverter(DocumentOrder documentOrder) {
//        this.documentOrder = documentOrder;
//    }

    public Order UnmarshalMyFile(String path) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream iS = new FileInputStream(path);
        return (Order) jaxbUnmarshaller.unmarshal(iS);
    }

    public DocumentOrder UnmarshalMyFile(File file) throws JAXBException, FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException();
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(DocumentOrder.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (DocumentOrder) jaxbUnmarshaller.unmarshal(file);
    }
}
