package com.codegnan.service;

import com.codegnan.model.Note;
import java.util.List;

public interface NoteService {

    Note addNote(Note note);

    List<Note> getAllNotes();

    Note getNoteById(int id);

    Note updateNote(Note note);

    void deleteNoteById(int id);
}
