package me.cwiklinski.service;

public class FileIsNotDirectoryException extends Exception {
    public FileIsNotDirectoryException() {
        super("Obiekt nie jest folderem");
    }
}
