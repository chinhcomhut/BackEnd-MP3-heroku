package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.model.Song;
import com.codegym.wbdlaptop.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class SongRestAPI {
    @Autowired
    private ISongService songService;
    @GetMapping("/song/pagination")
    public ResponseEntity<?> getListSongAngPagination(@PageableDefault(value = 2, sort = "date", direction = Sort.Direction.ASC)Pageable pageable){
        Page<Song> songs = songService.findAll(pageable);
        if(songs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("/song")
    public ResponseEntity<?> getListSong(){
        List<Song> songs = (List<Song>)songService.findAll();
        if(songs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @GetMapping("/song/{id}")
    public ResponseEntity<?> getSong(@PathVariable Long id){
        Optional<Song> song = songService.findById(id);
        if(!song.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
    @PostMapping("/song")
    public ResponseEntity<?> createSong(@Valid @RequestBody Song song){
        song.setUpdate(false);
        songService.save(song);
        return new ResponseEntity<>(song,HttpStatus.CREATED);
    }
@PutMapping("/song/{id}")
    public ResponseEntity<?> updateSong(@Valid @RequestBody Song song, @PathVariable Long id){
        Optional<Song> song1 = songService.findById(id);
        if(!song1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        song1.get().setUpdate(true);
        song1.get().setUser(song.getUser());
        song1.get().setComments(song.getComments());
        song1.get().setLikeSong(song.getLikeSong());
        song1.get().setListenSong(song.getListenSong());
        song1.get().setLyrics(song.getLyrics());
        song1.get().setMp3Url(song.getMp3Url());
        song1.get().setNameSong(song.getNameSong());
        song1.get().setSinger(song.getSinger());
        songService.save(song1.get());
        return new ResponseEntity<>(song1, HttpStatus.OK);
}
@DeleteMapping("/song/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id){
        Optional<Song> song = songService.findById(id);
        if(!song.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
