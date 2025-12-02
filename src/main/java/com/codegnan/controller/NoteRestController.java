package com.codegnan.controller;

import com.codegnan.model.Note;
import com.codegnan.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin("*")
public class NoteRestController {

    @Autowired
    private NoteService noteService;

    // POST - create new note
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }

    // GET - all notes
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // GET - note by id
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    // PUT - update full note (title etc.)
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable int id, @RequestBody Note note) {
        note.setId(id);   // ✅ mandatory
        return noteService.updateNote(note);
    }

    // DELETE - delete note
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable int id) {
        noteService.deleteNoteById(id);
        return "Note deleted successfully";
    }
}
