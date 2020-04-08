package com.immoc.play;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayListCollection {
    Map<String,PlayList> p  = new HashMap<String,PlayList>();

    public Map<String, PlayList> getP() {
        return p;
    }

    public void setP(Map<String, PlayList> p) {
        this.p = p;
    }

    /**
     * 向播放列表集合（播放器）添加播放列表
     * @param playList 要添加的播放列表
     */
    public void addPlayList(PlayList playList){
        p.put(playList.getPlayListName(),playList); //播放列表名称作为key值
    }

    /**
     * 删除播放列表
     * @param playList
     */
    public void deletePlayList(PlayList playList){
        p.remove(playList.getPlayListName());
        System.out.println("删除成功");
    }

    /**
     *
     * @param playListName
     * @return
     * 通过播放列表名称进行查询
     */

    public PlayList searchPlayList(String playListName){
        PlayList playList =null;
        Set<String> playListSet = p.keySet();
        for(String s:playListSet){
            if(s.equals(playListName)){
                playList=p.get(s); //得到key对应的value值
            }
        }
        return playList;
    }

    public void displayAllPlayList(){
        Set<String> playListSet = p.keySet();
        System.out.println("播放列表名称为：　");
        for(String s:playListSet){
            System.out.println(s);
        }
    }
}
