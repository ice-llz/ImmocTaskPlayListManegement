package com.immoc.play;

import java.io.Serializable;
import java.util.Objects;

public class Song implements Serializable {
    private String name;
    private String id;
    private String singer;

    public Song(String name, String id, String singer) {
        this.name = name;
        this.id = id;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return name.equals(song.name) &&
                id.equals(song.id) &&
                singer.equals(song.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, singer);
    }

    @Override
    public String toString() {
        return "歌曲信息:   id为"+ id+"     歌曲名称为: " + name + "     演唱者为: "+ singer;
    }
}
