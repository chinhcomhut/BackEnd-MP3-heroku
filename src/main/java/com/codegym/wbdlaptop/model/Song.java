package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String nameSong;

    private int likeSong;

    private int listenSong;

    @Lob
    private String lyrics;

    @Lob
    private String mp3Url;

    private Boolean isUpdate;

    @ManyToOne
    private Singer singer;

    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class, mappedBy = "song", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Song() {
    }

    public Song(String nameSong, int likeSong, int listenSong, String lyrics, String mp3Url, Boolean isUpdate, Singer singer, User user, List<Comment> comments) {
        this.nameSong = nameSong;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.lyrics = lyrics;
        this.mp3Url = mp3Url;
        this.isUpdate = isUpdate;
        this.singer = singer;
        this.user = user;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public int getLikeSong() {
        return likeSong;
    }

    public int getListenSong() {
        return listenSong;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getMp3Url() {
        return mp3Url;
    }

    public Boolean getUpdate() {
        return isUpdate;
    }

    public Singer getSinger() {
        return singer;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public void setLikeSong(int likeSong) {
        this.likeSong = likeSong;
    }

    public void setListenSong(int listenSong) {
        this.listenSong = listenSong;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public void setMp3Url(String mp3Url) {
        this.mp3Url = mp3Url;
    }

    public void setUpdate(Boolean update) {
        isUpdate = update;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user){
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
