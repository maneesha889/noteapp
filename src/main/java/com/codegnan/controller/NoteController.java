package com.codegnan.controller;

import com.codegnan.model.Note;
import com.codegnan.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Home redirect to list
    @GetMapping("/")
    public String home() {
        return "redirect:/list";
    }

    // Show all notes
    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "list";
    }

    // Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("note", new Note());
        return "add";
    }

    // Save new note
    @PostMapping("/save")
    public String saveNote(@ModelAttribute Note note) {
        noteService.addNote(note);
        return "redirect:/list";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable int id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id));
        return "edit";
    }

    // Update note
    @PostMapping("/update")
    public String updateNote(@ModelAttribute Note note) {
        noteService.updateNote(note);
        return "redirect:/list";
    }

    // Delete note
    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable int id) {
        noteService.deleteNoteById(id);
        return "redirect:/list";
    }
}
