package com.immoc.play;

import java.util.Scanner;

public class Main {
    Song song1 = new Song("想象之中", "S001", "vae");
    Song song2 = new Song("青花瓷", "S002", "Jay chou");
    Song song3 = new Song("Awake", "S003", "Talor Swift");

    /**
     * 测试Song类
     */
    public void testSong() {
        System.out.println(song1);
        System.out.println("song1与song2是否相等？   " + song1.equals(song3));
    }

    /**
     * 测试PlayList类
     */
    public void testPlayList() {
        PlayList pl1 = new PlayList("主播放列表");
        pl1.addPlayList(song1);
        pl1.addPlayList(song2);
        pl1.addPlayList(song3);
        pl1.disPlayAllSong();
        System.out.println("\n根据ID查询的歌曲信息为");
        System.out.println(pl1.searchMusicByID("S002"));

        Song song4 = new Song("如果爱可以重来", "S004", "LLZ");

        pl1.updateMusic("S003", song4);
        pl1.deleteMusic("S001");
    }

    /**
     * 测试PlayListCollection类
     */
    public void testPlayListCollection() {
        //主列表
        PlayList mainPlayList = new PlayList("Main Play List");
        mainPlayList.addPlayList(song1);
        mainPlayList.addPlayList(song2);
        mainPlayList.addPlayList(song3);

        //我最喜爱的列表
        PlayList favourite = new PlayList("My Favourite");
        favourite.addPlayList(mainPlayList.getMusicList().get(0));
        favourite.addPlayList(mainPlayList.getMusicList().get(1));
        favourite.disPlayAllSong();

        PlayListCollection plc = new PlayListCollection();
        plc.addPlayList(mainPlayList);
        plc.addPlayList(favourite);
        plc.displayAllPlayList();
        plc.searchPlayList("My Favourite").disPlayAllSong();
    }

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
                                        System.out.println("添加成功   " + song);
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
                                        System.out.println("添加成功　" + song);
                                    }
                                }
                                break;

                            case 5:
                                System.out.println("5- 修改播放列表中的歌曲");
                                break;

                            case 6:
                                System.out.println("6- 删除播放列表的歌曲");
                                break;

                            case 7:
                                System.out.println("7- 显示播放列表里的所有歌曲");
                                break;

                            default:
                                System.out.println("请输入对应的数字进行操作");
                                break;
                        }
                    }
                    break;

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
