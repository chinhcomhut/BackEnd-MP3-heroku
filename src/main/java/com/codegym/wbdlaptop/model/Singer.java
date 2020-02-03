package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "singer")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSinger;
private String information;
private String singerAvatar;

    public Singer(String nameSinger, String infomation, String singerAvatar, List<Song> songs) {
        this.nameSinger = nameSinger;
        this.information = infomation;
        this.singerAvatar = singerAvatar;
        this.songs = songs;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Song.class, mappedBy = "singer", cascade = CascadeType.ALL)
    private List<Song> songs;

    public String getInformation() {
        return information;
    }

    public void setInformation(String infomation) {
        this.information = infomation;
    }

    public String getSingerAvatar() {
        return singerAvatar;
    }

    public void setSingerAvatar(String singerAvatar) {
        this.singerAvatar = singerAvatar;
    }

    public Singer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

}
