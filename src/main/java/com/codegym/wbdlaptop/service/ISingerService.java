package com.codegym.wbdlaptop.service;

import com.codegym.wbdlaptop.model.Singer;

import java.util.List;
import java.util.Optional;

public interface ISingerService {
    Optional<Singer> findById(Long id);

    Iterable<Singer> findAll();

    Singer save(Singer singer);

    void delete(Long id);
    List<Singer> findAllByUserId(Long user_id);

    Iterable<Singer> findSingersByNameSingerContaining(String singer_name);
}
