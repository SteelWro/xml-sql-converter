package me.cwiklinski.exception;

public class FileIsNotDirectoryException extends Exception {
    public FileIsNotDirectoryException() {
        super("Obiekt nie jest folderem");
    }
}
