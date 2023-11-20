package com.example.duoihinhbatchu.model;

import com.example.duoihinhbatchu.PlayGameActivity;
import com.example.duoihinhbatchu.db.DbHelper;
import com.example.duoihinhbatchu.object.Quest;
import com.example.duoihinhbatchu.object.User;

import java.util.ArrayList;

public class PlayGameModel{
    PlayGameActivity c;
    ArrayList<Quest> arr;
    int cauSo = -1;
    public User user;
    public PlayGameModel(PlayGameActivity c) {
        this.c = c;
        user = new User();
        createData();
    }
    private void createData() {
        arr = new ArrayList<>();
//        arr.add(new Quest("","",""));
        arr.add(new Quest(1,"Man 1","hoga","https://1.bp.blogspot.com/-gyz54ig8HzY/U825SHd7yyI/AAAAAAAADWU/eScqetwzDVE/s1600/2014-07-22+01.35.15-1.png"));
        arr.add(new Quest(2,"Man 2","epcung","https://4.bp.blogspot.com/-9hnCZX3f7_U/U825mSVUZcI/AAAAAAAADWs/_B5_Ov_gJ7U/s1600/2014-07-22+01.38.05-1.png"));
        arr.add(new Quest(3,"Man 3","cacao","https://4.bp.blogspot.com/-zOKWrXkUjr4/U826ZfPwkzI/AAAAAAAADXk/9QZPKzp4ZTA/s1600/2014-07-22+01.41.02-1.png"));
        arr.add(new Quest(4,"Man 4","batloi","https://4.bp.blogspot.com/-nwTGIeipIXg/U826eqMkM4I/AAAAAAAADXs/MoswteChfdI/s1600/2014-07-22+01.41.25-1.png"));
    }
    public int buocNhay(){
        cauSo++;
        if(cauSo>= arr.size()){
            cauSo = arr.size()-1;
        }
        return cauSo;
    }
    public Quest getQuestById(int qId){
//        arr.get(qId);
        return arr.get(qId);
    }
    public Quest getQuest(){
        cauSo++;
        if(cauSo>= arr.size()){
            cauSo = arr.size()-1;
        }
//        buocNhay();
        return arr.get(cauSo);
    }
    public int getCauSo(){
        cauSo++;
        if(cauSo>= arr.size()){
            cauSo = arr.size()-1;
        }
//        buocNhay();
        return cauSo;
    }

    //lay thong tin, luu thong tin nguoi dung
    public void layThongTin(){
        user.getInfo(c);
    }
    public void luuThongTin(){
        user.saveInfo(c);
    }
}
