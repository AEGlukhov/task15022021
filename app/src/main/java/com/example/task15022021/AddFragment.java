package com.example.task15022021;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class AddFragment extends Fragment {
    private EditText et_name;
    private EditText et_group;
    private AppCompatButton btn_complete_add;
    StudentAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        et_name = view.findViewById(R.id.et_name);
        et_group = view.findViewById(R.id.et_group);
        btn_complete_add = view.findViewById(R.id.btn_complete_add);
        adapter = new StudentAdapter(getContext(), MainActivity.students);
        btn_complete_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.students.add(new Student(et_name.getText().toString(), et_group.getText().toString(), 0));
                Collections.sort(MainActivity.students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getScore() - o2.getScore();
                    }
                });
                adapter.notifyDataSetChanged();
                getActivity().getSupportFragmentManager().beginTransaction().remove(AddFragment.this).commit();

            }
        });
        return view;

    }
}