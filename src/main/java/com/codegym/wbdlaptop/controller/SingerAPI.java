package com.codegym.wbdlaptop.controller;

import com.codegym.wbdlaptop.message.response.ResponseMessage;
import com.codegym.wbdlaptop.model.Singer;
import com.codegym.wbdlaptop.model.Song;
//import com.codegym.wbdlaptop.security.service.UserPrinciple;
import com.codegym.wbdlaptop.service.ISingerService;
import com.codegym.wbdlaptop.service.ISongService;
//import com.codegym.wbdlaptop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = ("*"))
@RestController
@RequestMapping("/api/auth")
public class SingerAPI {
    @Autowired
    private ISingerService singerService;
    @Autowired
    private ISongService songService;
//    @Autowired
//    private IUserService userService;
//    private UserPrinciple getCurrentUser(){
//        return (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }
    @GetMapping("/singer")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getListAllSinger(){
        List<Singer> singerList = (List<Singer>) singerService.findAll();
        if(singerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(singerList, HttpStatus.OK);
    }
    @GetMapping("/singer/{id}")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getSinger(@PathVariable Long id){
        Optional<Singer> singer = singerService.findById(id);
        if(!singer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(singer,HttpStatus.OK);
    }
    @PostMapping("/singer")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createSinger(@Valid @RequestBody Singer singer){
//        singer.setUser(this.userService.findByUserId(getCurrentUser().getId()));
        singerService.save(singer);
        return new ResponseEntity<>(singer, HttpStatus.CREATED);
    }
    @PutMapping("/singer/{id}")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateSinger(@Valid @RequestBody Singer singer, @PathVariable Long id){
        Optional<Singer> singer1 = singerService.findById(id);
        if(!singer1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        singer1.get().setNameSinger(singer.getNameSinger());
        singer1.get().setInformation(singer.getInformation());
        singer1.get().setSingerAvatar(singer.getSingerAvatar());
        singerService.save(singer1.get());
        return new ResponseEntity<>(singer1, HttpStatus.OK);
    }
    @DeleteMapping("/singer/{id}")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteSinger(@PathVariable Long id){
        Optional<Singer> singer = singerService.findById(id);
        if(!singer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Song> songs = (List<Song>) songService.findSongsByUserId(id);
        if(!songs.isEmpty()){
            for (Song song: songs){
                songService.delete(song.getId());
            }
        }
        singerService.delete(id);
        return new ResponseEntity<>(new ResponseMessage("Delete Singer success!"),HttpStatus.OK);
    }

}
