package com.example.homeworkdev14.dao;

import com.example.homeworkdev14.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> noteMap = new HashMap<>();

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        Random random = new Random();
        Long id = random.nextLong();
        while (noteMap.containsKey(id)) {
            id = random.nextLong();
        }
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (noteMap.containsKey(id)) {
            noteMap.remove(id);
        } else {
            throw new IllegalArgumentException("ID not found");
        }
    }

    public void update(Note note) {
        if (noteMap.containsKey(note.getId())) {
            noteMap.put(note.getId(), note);
        } else {
            throw new IllegalArgumentException("ID not found");
        }
    }

    public Note getById(long id) {
        if (noteMap.containsKey(id)) {
          return noteMap.get(id);
        } else {
            throw new IllegalArgumentException("ID not found");
        }
    }
}
