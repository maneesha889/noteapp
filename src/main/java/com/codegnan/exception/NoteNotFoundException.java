package com.codegnan.exception;

public class NoteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoteNotFoundException(Long id) {
        super("Note not found with id: " + id);
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}