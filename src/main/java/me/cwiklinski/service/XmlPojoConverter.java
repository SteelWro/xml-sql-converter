package me.cwiklinski;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class XmlPojoConverter<T> {
    private T t;

    public XmlPojoConverter(T t) {
        this.t = t;
    }

    public T UnmarshalMyFile(String path) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream iS = new FileInputStream(path);
        return (T) jaxbUnmarshaller.unmarshal(iS);
    }
}
