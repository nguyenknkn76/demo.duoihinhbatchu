package com.example.duoihinhbatchu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.duoihinhbatchu.adapter.ResultAdapter;
//import com.example.duoihinhbatchu.db.DBHandler;
import com.example.duoihinhbatchu.model.PlayGameModel;
import com.example.duoihinhbatchu.object.Quest;

import java.util.ArrayList;
import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {
    PlayGameModel models;
    Quest quest;
    private String okResult = "yeuot";
    ArrayList<String> arrResult;
    GridView gdvResult;
    ImageView questImage;
    TextView txvUserMoney;
    TextView txvMan;
    int index = 0;

    ArrayList<String> arrPlayerResult;
    GridView gdvPlayerResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        init();
        anhXa();
        setOnclick();
        viewQuest();

    }
    private void anhXa(){
        gdvResult = findViewById(R.id.gdvResult);
        gdvPlayerResult = findViewById(R.id.gdvPlayerResult);
        questImage = findViewById(R.id.questImage);
        txvUserMoney= findViewById(R.id.txvUserMoney);
        txvMan = findViewById(R.id.txvMan);
    }
    private void init(){
        arrResult = new ArrayList<>();
        arrPlayerResult = new ArrayList<>();
        models = new PlayGameModel( this);
    }

    // ctrl D

    private void viewQuest(){
        // hien cau do
//        DBHandler dbHandler = new DBHandler(this);
//        quest = models.getQuest();                                                /////quan trong nha

        int cauSo = models.getCauSo();

//        if(cauSo == 0){
//            Intent intent = new Intent(this, PlayGameActivity.class);
//            cauSo = getIntent().getIntExtra("cauSo",cauSo);
//        }
        quest = models.getQuestById(cauSo);

//        Quest quest = dbHandler.getAQuest(causo);
        okResult = quest.qResult;

        bamData();
        viewResult();
        viewPlayerResult();
        Glide.with(this)
                .load(quest.qImg)
                .into(questImage);
        models.layThongTin();
        txvUserMoney.setText(models.user.money + " $");
        txvMan.setText(models.getQuestById(cauSo).qName);
    }
    private void viewWinAct(){
        int cauSo = models.getCauSo();
        Intent intent = new Intent(this, WinActivity.class);
        intent.putExtra("okResult",okResult);
        intent.putExtra("cauSo", cauSo);
        startActivity(intent);
    }
    private void viewResult(){
        gdvResult.setNumColumns(arrResult.size());
        gdvResult.setAdapter(new ResultAdapter(this,0, arrResult));
    }
    private void viewPlayerResult(){
        gdvPlayerResult.setNumColumns(arrPlayerResult.size()/2);
        // /2 hien thi tren 2 dong
        gdvPlayerResult.setAdapter(new ResultAdapter(this,0, arrPlayerResult));
    }

    private void setOnclick(){
        gdvPlayerResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                if(s.length() != 0  && index < arrResult.size()){
                    //kiem tra o nao trong thi se~ set cho o do
                    for(int i=0; i<arrResult.size(); i++){
                        if(arrResult.get(i).length() == 0){
                            index = i;
                            break;
                        }
                    }
                    arrPlayerResult.set(position,"");
                    arrResult.set(index,s);
                    index++;
                    viewResult();
                    viewPlayerResult();
                    checkWin();

                }
            }
        });
        gdvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                if(s.length() != 0){
                    index = position;
                    arrResult.set(position,"");
                    for(int i = 0; i < arrPlayerResult.size(); i++){
                        if(arrPlayerResult.get(i).length() ==0 ){
                            arrPlayerResult.set(i,s);
                            break;
                        }
                    }
                    viewResult();
                    viewPlayerResult();
                }
            }
        });
    }
    private void bamData(){
        index = 0;
       arrResult.clear();
       arrPlayerResult.clear();
       Random r = new Random();
       for(int i = 0; i < okResult.length(); i++){
           arrResult.add("");
           String s = "" + (char)(r.nextInt(25)+65);
           arrPlayerResult.add(s);
           String s1 = "" + (char)(r.nextInt(25)+65);
           arrPlayerResult.add(s1);
       }

       //dua string okResult vao trong item cua player's result
       for(int i=0; i<okResult.length();i++){
           String s = ""+okResult.charAt(i);
           arrPlayerResult.set(i,s.toUpperCase());
       }

       // dao? thu tu player result
        for(int i=0; i<arrPlayerResult.size() ; i++){
            String s = arrPlayerResult.get(i);
            int vt = r.nextInt(arrPlayerResult.size());
            arrPlayerResult.set(i, arrPlayerResult.get(vt));
            arrPlayerResult.set(vt,s);
        }
    }

    private void checkWin(){
        //kiem tra neu ket qua? dung thi hien thi. thong bao "cau tra loi chinh xac"
        String s ="";
        for(String s1:arrResult){
            s = s + s1;
        }
        s = s.toUpperCase();
        if(s.equals(okResult.toUpperCase())){
            Toast.makeText(this,"cau tra loi chinh xac " + okResult , Toast.LENGTH_SHORT).show();
            models.layThongTin();
            models.user.money = models.user.money + 100; // them 10 tien khi cau tra loi chinh xac
            models.luuThongTin();
            viewWinAct();
            viewQuest();

        }
    }

    public void suggest(View view) {
        models.layThongTin();
        // kiem tra user con` money de sd suggestion k
        if(models.user.money < 1){
            Toast.makeText(this,"ban da het tien !!!" , Toast.LENGTH_SHORT).show();
            return;
        }
        int id = -1;
        for(int i = 0; i < arrResult.size(); i++){
            if(arrResult.get(i).length()==0){
                id = i;
                break;
            }
        }
        if(id == -1){
            for(int i = 0; i < arrResult.size(); i++){
                String s =  okResult.toUpperCase().charAt(i)+"";
                if(!arrResult.get(i).toUpperCase().equals(s)){
                    id = i;
                    break;
                }
            }
            for(int i = 0; i < arrPlayerResult.size(); i++){
                if(arrPlayerResult.get(i).length() == 0){
                    arrPlayerResult.set(i, arrResult.get(id));
                    break;
                }
            }
        }
        String suggestion = "" + okResult.charAt(id);
        suggestion = suggestion.toUpperCase();

        for(int i = 0; i < arrResult.size();i++){
            if(arrResult.get(i).toUpperCase().equals(suggestion)){
                arrResult.set(i,"");
                break;
            }
        }

        for (int i = 0; i < arrPlayerResult.size(); i++) {
            if (suggestion.equals(arrPlayerResult.get(i))) {
                arrPlayerResult.set(i, "");
                break;
            }
        }
        arrResult.set(id, suggestion);
        viewResult();
        viewPlayerResult();

        models.layThongTin();
        models.user.money = models.user.money - 1; // tru 5 tien khi su dung goi y
        models.luuThongTin();
        txvUserMoney.setText(models.user.money + " $");
        checkWin();
    }

    public void changeQuest(View view) {
        models.layThongTin();
        // kiem tra user con` money de sd suggestion k
        if(models.user.money < 1){
            Toast.makeText(this,"ban da het tien !!!" , Toast.LENGTH_SHORT).show();
            return;
        }
        models.user.money = models.user.money - 10; // tru 5 tien khi su dung goi y
        models.luuThongTin();
        txvUserMoney.setText(models.user.money + " $");
        viewQuest();
    }
}
//arrCauTraLoi = arrResult
// arrDapAn = arrPlayerResult