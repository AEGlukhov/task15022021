package com.example.task15022021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int itemId;
    private ListView listView;
    private AppCompatButton btn_add;
    FragmentTransaction transaction;
    AddFragment addFragment;
    ChangeFragment changeFragment;
    public static List<Student> students = new ArrayList<>();
    private StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment = new ChangeFragment();
        addFragment = new AddFragment();
        listView = findViewById(R.id.list_view);
        btn_add = findViewById(R.id.btn_add);
        adapter = new StudentAdapter(this, students);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.ll_main, changeFragment);
                transaction.commit();
                itemId = position;

            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.ll_main, addFragment);
                transaction.commit();

            }
        });
    }
}