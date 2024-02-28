package com.example.homeworkdev14;

import com.example.homeworkdev14.dao.NoteService;
import com.example.homeworkdev14.model.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeWorkDev14Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeWorkDev14Application.class, args);
        NoteService noteService = new NoteService();
        Note note = new Note();
        note.setContent("GG");
        note.setTitle("abc");
        noteService.add(note);
        Note note2 = new Note();
        note2.setId(note.getId());
        note2.setContent("IZI");
        note2.setTitle("cba");
        noteService.add(note2);
        noteService.deleteById(1L);
        System.out.println(noteService.getById(note2.getId()));
        noteService.update(note2);
        System.out.println(noteService.listAll());
    }

}
