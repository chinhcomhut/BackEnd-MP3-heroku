package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);

    Optional<Song> findByMp3Url(String mp3Url);

    List<Song> findAllByOrderByLikeSong();

    List<Song> findAllByOrderByListenSong();

    List<Song> findAllByUserId (Long userId);

    Iterable<Song> findAll();

    Optional<Song> findById(long id);

    Optional<Song> findByIdSong(Long id);
    Iterable<Song> findSongsByUserId(Long id);

    Song save(Song song);

    void delete(long id);

    Optional<Song> findByNameSongContaining(String song);
}
