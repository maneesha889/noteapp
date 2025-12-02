package com.codegnan.service;

import com.codegnan.exception.NoteNotFoundException;
import com.codegnan.model.Note;
import com.codegnan.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(int id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found with ID: " + id));
    }

    @Override
    public Note updateNote(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new NoteNotFoundException("Cannot update. Note not found with ID: " + note.getId());
        }
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteById(int id) {
        if (!noteRepository.existsById(id)) {
            throw new NoteNotFoundException("Cannot delete. Note not found with ID: " + id);
        }
        noteRepository.deleteById(id);
    }
}
