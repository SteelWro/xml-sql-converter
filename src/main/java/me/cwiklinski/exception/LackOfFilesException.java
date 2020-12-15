package me.cwiklinski.exception;

public class LackOfFilesException extends Exception {
    public LackOfFilesException(String message) {
        super("Brak plików w lokalizacji: " + message);
    }
}
