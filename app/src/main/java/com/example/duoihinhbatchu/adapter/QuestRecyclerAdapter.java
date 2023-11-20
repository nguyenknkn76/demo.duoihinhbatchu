//package com.example.duoihinhbatchu.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.duoihinhbatchu.R;
//import com.example.duoihinhbatchu.object.Quest;
//
//import java.util.List;
//
//public class QuestRecyclerAdapter extends RecyclerView.Adapter<QuestRecyclerAdapter.MyViewHolder> {
//    private List<Quest> questList;
//    private OnItemClickListener itemClickListener;
//
//    public QuestRecyclerAdapter(List<Quest> questList, OnItemClickListener itemClickListener) {
//        this.questList = questList;
//        this.itemClickListener = itemClickListener;
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(Quest quest);
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView mId;
//        TextView mName;
//        TextView mResult;
//        TextView mImage;
//
//        public MyViewHolder(View view) {
//            super(view);
//            mId = view.findViewById(R.id.mId);
//            mId = view.findViewById(R.id.mName);
//            mId = view.findViewById(R.id.mResult);
//            mId = view.findViewById(R.id.mImage);
//        }
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        View itemView = LayoutInflater.from(context).inflate(R.layout.single_quest, parent, false);
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Quest quest = questList.get(position);
//        holder.mId.setText(quest.getqId());
//        holder.mName.setText(quest.getqName());
//        holder.mResult.setText(quest.getqResult());
//        holder.mImage.setText(quest.getqImg());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                itemClickListener.onItemClick(quest);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return questList.size();
//    }
//}