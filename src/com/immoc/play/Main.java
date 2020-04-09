package com.immoc.play;

import java.io.*;
import java.util.Scanner;

public class Main {

    //主菜单
    public void mainMenu() {
        System.out.println("*******************");
        System.out.println("1- 播放列表管理");
        System.out.println("2- 播放器管理");
        System.out.println("0- 退出");
        System.out.println("*******************");
    }

    //播放列表菜单
    public void playListMenu() {
        System.out.println("播放列表管理***********************");
        System.out.println("1- 将歌曲添加到主播放列表");
        System.out.println("2- 将歌曲添加到普通播放列表");
        System.out.println("3- 通过歌曲id查询播放列表中的歌曲");
        System.out.println("4- 通过歌曲名称查询播放列表中的歌曲");
        System.out.println("5- 修改播放列表中的歌曲");
        System.out.println("6- 删除播放列表的歌曲");
        System.out.println("7- 显示播放列表里的所有歌曲");
        System.out.println("8- 导出歌单信息");
        System.out.println("0- 返回主菜单");
        System.out.println("播放列表管理***********************");
    }

    //播放器菜单
    public void playerMenu() {
        System.out.println("播放器管理*******************");
        System.out.println("1- 向播放器中添加播放列表");
        System.out.println("2- 从播放器删除播放列表");
        System.out.println("3- 通过名字查询播放列表信息");
        System.out.println("4- 显示所有播放列表名称");
        System.out.println("0- 返回主菜单");
        System.out.println("播放器管理*******************");
    }

    public void test() {
        Scanner sc = new Scanner(System.in);
        int input1 = 0, input2 = 0, input3 = 0;
        //创建一个播放器和主播放列表，并将主播放列表添加至播放器中
        PlayListCollection plc = new PlayListCollection();
        PlayList mainPlayList = new PlayList("主播放列表");
        plc.addPlayList(mainPlayList);

        PlayList playList2 = null;
        //备用列表，想以ArrayList存储。因此用户可以自由添加列表
        PlayList playList3 = null;
        PlayList playList4 = null;

        while (true) {
            mainMenu();
            System.out.println("请输入对应的数字进行操作");
            input1 = sc.nextInt();
            if (input1 == 0)
                break;
            switch (input1) {
                case 1:
                    while (true) {
                        playListMenu();
                        System.out.println("请输入对应的数字进行操作");
                        input2 = sc.nextInt();
                        if (input2 == 0)
                            break;
                        switch (input2) {
                            case 1:
                                System.out.println("1- 添加歌曲到主播放列表");
                                System.out.println("请输入要添加的歌曲数量");
                                int count = sc.nextInt();
                                for (int i = 0; i < count; i++) {
                                    System.out.println("请输入第" + (i + 1) + "首歌曲的id");
                                    String strid = sc.next();
                                    System.out.println("请输入这首歌曲的名称");
                                    String strName = sc.next();
                                    System.out.println("请输入歌手名称");
                                    String strSingerName = sc.next();
                                    Song song = new Song(strName, strid, strSingerName);
                                    mainPlayList.addPlayList(song);
                                    mainPlayList.disPlayAllSong();
                                }
                                break;

                            case 2:
                                System.out.println("2- 添加歌曲到普通播放列表");
                                System.out.println("请输入要添加的播放列表的名称");
                                String sName = sc.next();
                                if (plc.searchPlayList(sName) == null) {
                                    System.out.println("该播放列表不存在");
                                } else {
                                    System.out.println("请输入要添加的歌曲数量");
                                    int count1 = sc.nextInt();
                                    for (int i = 0; i < count1; i++) {
                                        System.out.println("请输入第" + (i + 1) + "首歌曲的id");
                                        String strid = sc.next();
                                        System.out.println("请输入这首歌曲的名称");
                                        String strName = sc.next();
                                        System.out.println("请输入歌手名称");
                                        String strSingerName = sc.next();
                                        Song song = new Song(strName, strid, strSingerName);
                                        playList2.addPlayList(song);
                                    }
                                    playList2.disPlayAllSong();
                                    break;
                                }

                            case 3:
                                System.out.println("3- 通过歌曲id查询播放列表中的歌曲");
                                System.out.println("请输入播放列表名称");
                                String s = sc.next();
                                if (plc.searchPlayList(s) == null) {
                                    System.out.println("该播放列表不存在");
                                    break;
                                } else {
                                    System.out.println("请输入歌曲id");
                                    String id = sc.next();
                                    Song song = plc.searchPlayList(s).searchMusicByID(id);
                                    if (song == null) {
                                        System.out.println("没有这首歌曲呢");
                                    } else {
                                        System.out.println("找到了   " + song);
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("4- 通过歌曲名称查询播放列表中的歌曲");
                                System.out.println("请输入播放列表名称");
                                String s1 = sc.next();
                                if (plc.searchPlayList(s1) == null) {
                                    System.out.println("该播放列表不存在");
                                    break;
                                } else {
                                    System.out.println("请输入歌曲名称");
                                    String name = sc.next();
                                    Song song = plc.searchPlayList(s1).searchMusicByName(name);
                                    if (song == null) {
                                        System.out.println("没有这首歌曲呢");
                                    } else {
                                        System.out.println("找到了　" + song);
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("5- 修改播放列表中的歌曲");
                                System.out.println("您要修改的列表名称是______ 歌曲id是______？");
                                String strListName = sc.next();
                                String strId = sc.next();
                                if (plc.searchPlayList(strListName) == null) {
                                    System.out.println("没有此列表");
                                } else {
                                    if (plc.searchPlayList(strListName).searchMusicByID(strId) == null) {
                                        System.out.println("该列表没有此歌曲");
                                    } else {
                                        System.out.println("请输入修改后的歌曲信息,依次为名称，id和歌手");
                                        Song song = new Song(sc.next(), sc.next(), sc.next());
                                        plc.searchPlayList(strListName).updateMusic(strId, song);
                                    }
                                }
                                break;

                            case 6:
                                System.out.println("6- 删除播放列表的歌曲");
                                System.out.println("您要删除的播放列表名称是______ 歌曲id是______？");
                                String strListName1 = sc.next();
                                String strId1 = sc.next();
                                if (plc.searchPlayList(strListName1) == null) {
                                    System.out.println("没有此列表");
                                } else {
                                    if (plc.searchPlayList(strListName1).searchMusicByID(strId1) == null) {
                                        System.out.println("该列表没有此歌曲");
                                    } else {
                                        plc.searchPlayList(strListName1).deleteMusic(strId1);
                                    }
                                }
                                break;

                            case 7:
                                System.out.println("7- 显示播放列表里的所有歌曲");
                                System.out.println("您要显示的播放列表名称是?");
                                String strListName2 = sc.next();
                                if (plc.searchPlayList(strListName2) == null) {
                                    System.out.println("没有此列表");
                                } else {
                                    plc.searchPlayList(strListName2).disPlayAllSong();
                                }
                                break;

                            case 8:
                                System.out.println(("8- 导出歌单信息"));
                                System.out.println("您要导出的歌单名称是?");
                                String strListName3 = sc.next();
                                if (plc.searchPlayList(strListName3) == null) {
                                    System.out.println("没有此歌单");
                                } else {
                                    plc.searchPlayList(strListName3).exportMusic();
                                }
                            default:
                                System.out.println("请输入对应的数字进行操作");
                                break;
                        }
                    }
                    break;


                //主界面的选择２
                case 2:
                    while (true) {
                        playerMenu();
                        input3 = sc.nextInt();
                        if (input3 == 0) {
                            break;
                        }
                        switch (input3) {
                            case 1:
                                System.out.println("1- 向播放器中添加播放列表");
                                System.out.println("为播放列表创建一个名字");
                                String playName = sc.next();
                                playList2 = new PlayList(playName);
                                plc.addPlayList(playList2);
                                break;

                            case 2:
                                System.out.println("2- 从播放器删除播放列表");
                                System.out.println("请输入要删除的播放列表名称");
                                String s = sc.next();
                                if (plc.searchPlayList(s) == null) {
                                    System.out.println("不存在该列表");
                                } else if (s.equals("主播放列表")) {
                                    System.out.println("主播放列表不能删除");
                                } else {
                                    plc.deletePlayList(plc.searchPlayList(s));
                                }
                                break;

                            case 3:
                                System.out.println("3- 通过名字查询播放列表信息");
                                System.out.println("请输入列表名字");
                                String playName1 = sc.next();
                                if (plc.searchPlayList(playName1) == null) {
                                    System.out.println("不存在该列表");
                                } else {
                                    System.out.println("找到了");
                                    plc.searchPlayList(playName1).disPlayAllSong();
                                }
                                break;

                            case 4:
                                System.out.println("4- 显示所有播放列表名称");
                                plc.displayAllPlayList();
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("请输入对应的数字进行操作");
            }
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.test();
    }
}
