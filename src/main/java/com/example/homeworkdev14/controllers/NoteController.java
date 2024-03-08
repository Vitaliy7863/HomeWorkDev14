package com.example.homeworkdev14.controllers;

import com.example.homeworkdev14.dao.NoteService;
import com.example.homeworkdev14.model.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/nte")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView listNotes() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam("deletedNoteId") Long id) {
        if (id != null) {
            noteService.deleteById(id);
        }
        return listNotes();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditNotePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Note note = noteService.getById(id);
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editNote(@PathVariable Long id, @RequestParam String title, @RequestParam String content) {
        if (id != null && title != null && content != null) {
            Note note = noteService.getById(id);
            note.setTitle(title);
            note.setContent(content);
            noteService.update(note);
        }
        return listNotes();
    }

    @GetMapping("/create")
    public ModelAndView getCreateNotePage() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNote(@ModelAttribute Note newNote) {
        noteService.add(newNote);
        return listNotes();
    }
}
