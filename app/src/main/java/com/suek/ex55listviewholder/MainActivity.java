package com.suek.ex55listviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1) 대량의 데이터들
    ArrayList<String> items= new ArrayList<>();

    // 4) 대량의 데이터를 뷰객체로 만들어주는 아답터객체 참조변수
    MyAdapter adapter;
    // 6) AdapterView(ListView) 참조변수
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.1) 대량의 데이터 추가
        items.add(new String("aaa"));
        items.add(new String("bbb"));
        items.add(new String("ccc"));

        // 4.1) 아답터객체 생성
        adapter= new MyAdapter(items, this);   //layoutInflater 를 가지고있는 Context
        // 6.1) listView 에 adapter 붙이기
        listView= findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
