package com.example.task15022021;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class ChangeFragment extends Fragment {
    StudentAdapter adapter;
    private EditText et_score;
    private TextView tv_info;
    private AppCompatButton btn_save;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change, container, false);
        adapter = new StudentAdapter(getContext(), MainActivity.students);
        et_score = view.findViewById(R.id.et_score);
        tv_info = view.findViewById(R.id.tv_info);
        btn_save = view.findViewById(R.id.btn_save);
        tv_info.setText("Изменение баллов у " + MainActivity.students.get(MainActivity.itemId).getName() + " из группы " + MainActivity.students.get(MainActivity.itemId).getGroup());

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.students.get(MainActivity.itemId).setScore(Integer.valueOf(et_score.getText().toString()));
                adapter.notifyDataSetChanged();
                getActivity().getSupportFragmentManager().beginTransaction().remove(ChangeFragment.this).commit();


            }
        });
        return view;
    }
}