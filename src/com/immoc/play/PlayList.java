package com.immoc.play;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {
    public String playListName;
    public List<Song> musicList = new ArrayList<Song>();

    public PlayList(String playListName) {
        this.playListName = playListName;
    }

    public String getPlayListName() {
        return playListName;
    }

    public List<Song> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Song> musicList) {
        this.musicList = musicList;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    /**
     * 将歌曲添加到播放列表
     *
     * @param song 要添加的歌曲
     */

    public void addPlayList(Song song) {
        //要排除重复添加的情况
        boolean flag = false;
        for (Song s : musicList) {
            if (s.equals(song)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("该歌曲已经存在，添加失败");
        } else {
            musicList.add(song);
        }
    }

    /**
     * 显示播放列表中的歌曲
     */

    public void disPlayAllSong() {
        System.out.println("播放列表中的所有歌曲为\n*****************");
        for (Song s : musicList) {
            System.out.println(s);
        }
    }

    /**
     * 通过id或者名称查询歌曲
     *
     * @param id, name
     */

    public Song searchMusicByID(String id) {
        for (Song s : musicList) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Song searchMusicByName(String name) {
        for (Song s : musicList) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * 修改播放列表中的歌曲信息
     *
     * @param id   要修改的歌曲id
     * @param song 要存放的新的歌曲
     */

    public void updateMusic(String id, Song song) {
        Song s = searchMusicByID(id);
        if (s == null) {
            System.out.println("没有此歌曲");
        } else {
            musicList.remove(s);
            musicList.add(song);
            System.out.println("修改成功,新的歌曲信息为\n " + song);
        }
    }

    /**
     * 删除播放列表中指定歌曲
     *
     * @param id 要删除的歌曲id
     */

    public void deleteMusic(String id) {
        Song s = searchMusicByID(id);
        if (s == null) {
            System.out.println("没有此歌曲");
        } else {
            musicList.remove(s);
        }
        System.out.println("删除成功");
        disPlayAllSong();
    }

    public void exportMusic() {
        String Filename = this.getPlayListName() + ".txt";
        File file = new File(Filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fos = new FileOutputStream(Filename);
            FileInputStream fis = new FileInputStream(Filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (Song song : musicList) {
                oos.writeObject(song);Song ss = (Song) ois.readObject();
                System.out.println(ss);
            }   //这一步出bug了，希望其他同学能够解决
                //一小时后更新，已解决　current time = 11:39



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
