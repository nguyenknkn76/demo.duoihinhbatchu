//package com.example.duoihinhbatchu;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.DefaultItemAnimator;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
////import com.example.duoihinhbatchu.adapter.QuestRecyclerAdapter;
////import com.example.duoihinhbatchu.db.DBHandler;
//import com.example.duoihinhbatchu.object.Quest;
//
//import java.util.List;
//
//public class ManageQuestActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_manage_quest);
//
//        DBHandler dbHandler = new DBHandler(this);
//        List<Quest> questList = dbHandler.getAllQuests();
//        RecyclerView questListView = findViewById(R.id.questList);
//        QuestRecyclerAdapter wAdapter = new QuestRecyclerAdapter(questList, new QuestRecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Quest quest) {
//                Intent intent = new Intent(ManageQuestActivity.this, DetailQuestActivity.class);
//                intent.putExtra("questID", String.valueOf(quest.getqId()));
//                intent.putExtra("questName", quest.getqName());
//                intent.putExtra("questResult", quest.qResult);
//                intent.putExtra("questImage", quest.qImg);
//                startActivity(intent);
//            }
//        });
//        RecyclerView.LayoutManager wLayoutManager = new LinearLayoutManager(getApplicationContext());
//        questListView.setLayoutManager(wLayoutManager);
//        questListView.setItemAnimator(new DefaultItemAnimator());
//        questListView.setAdapter(wAdapter);
//
//    }
//    public void add(View view) {
//    }
//
//    public void update(View view) {
//    }
//}