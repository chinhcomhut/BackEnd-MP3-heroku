package com.codegym.wbdlaptop.repository;

import com.codegym.wbdlaptop.model.Song;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song, Long> {
////    Iterable<Song> findProductsByUserId(Long user_id);
//    Iterable<Song> findSongsByUserId(Long user_id);
////    Iterable<Song> findProductsByNameContaining(String name);
//    Iterable<Song> findSongsByNameSongContaining(String name);
//    Iterable<Song> findSongsBySingerId(Long singer_id);
////    Iterable<Song> findProductsByLineIdAndNameContaining(Long line_id, String name);
//    Iterable<Song> findSongsBySingerIdAndNameSongContaining (Long singer_id, String name);
//
//    Iterable<Song> findSongsBySingerIdAndNameSongContaining(String name);
    List<Song> findAllByUserId(Long userId);
    Iterable<Song> findSongsByUserId(Long userId);
    Optional<Song> findByNameSongContaining(String song);
    List<Song> findAllByOrderByLikeSong();
    List<Song> findAllByOrderByListenSongDesc();
    Optional<Song> findByMp3Url(String mp3Url);
}
