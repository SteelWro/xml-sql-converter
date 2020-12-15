package me.cwiklinski.service;

import me.cwiklinski.configuration.Constants;
import me.cwiklinski.exception.FileIsNotDirectoryException;
import me.cwiklinski.exception.LackOfFilesException;
import me.cwiklinski.model.document.DocumentOrder;
import me.cwiklinski.model.document.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class XmlPojoConverter {
    private File archiveDirectory;

    public XmlPojoConverter() {
        this.archiveDirectory = Path.of(Constants.ROOT_PATH, Constants.ARCHIVE_FOLDER_NAME).toFile();
    }

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

//    public void archiveMyFile() throws IOException {
//        File file = new File(Path.of(Constants.ROOT_PATH, Constants.FILE_NAME).toString());
//        if (!file.exists()) {
//            throw new FileNotFoundException();
//        }
//
//        if (!archiveDirectory.exists()) {
//            archiveDirectory.mkdir();
//        }
//
//        file.renameTo(new File(Path.of(Constants.ROOT_PATH, Constants.ARCHIVE_FOLDER_NAME, Constants.FILE_NAME).toString()));
//    }

    public void archiveMyFile(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        if (!archiveDirectory.exists()) {
            archiveDirectory.mkdir();
        }
        file.renameTo(new File(Path.of(Constants.ROOT_PATH
                , Constants.ARCHIVE_FOLDER_NAME
                , file.getName())
                .toString()));
    }

    public File[] getAllFilesNames(File rootDirectory) throws FileNotFoundException, FileIsNotDirectoryException, LackOfFilesException {
        if (rootDirectory.exists()) {
            if (rootDirectory.isDirectory()) {
                File[] files = Arrays.stream(rootDirectory.listFiles()).filter(e -> e.isDirectory() != true).toArray(File[]::new);
                if (files.length == 0) {
                    throw new LackOfFilesException(rootDirectory.getAbsolutePath());
                }
                return files;
            }
            throw new FileIsNotDirectoryException();
        }
        throw new FileNotFoundException();
    }
}
