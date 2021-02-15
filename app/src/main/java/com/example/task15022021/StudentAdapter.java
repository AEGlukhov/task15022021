package com.example.task15022021;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, List<Student> students){
        super(context, R.layout.list_item, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
        }
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        tv_name.setText(student.getName());
        TextView tv_group = convertView.findViewById(R.id.tv_group);
        tv_group.setText(student.getGroup());
        TextView tv_score = convertView.findViewById(R.id.tv_score);
        tv_score.setText(student.getScore().toString());
        return convertView;
    }
}
