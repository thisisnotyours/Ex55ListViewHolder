package com.suek.ex55listviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// 3) MyAdapter
public class MyAdapter extends BaseAdapter {

    // 3.1) 대량의 데이터들 참조변수
    ArrayList<String> items;
    // 3.2) AdapterView 에 View 객체를 만드는 Context(LayoutInflater 같은역할임) 참조변수  ////layoutInflater 를 가지고있는 Context
    Context context;                        //MainActivity, Activity 가 Context 를 상속받음  //Context- 운영체제역할

    // 3.3) 생성자 메소드
    public MyAdapter(ArrayList<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    // 5)
    @Override
    public int getCount() {
        return items.size();    //아이템개수
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);   //방번호 position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 5) AdapterView(ListView) 에 View 를 만들어주는                            //convertView == cardView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {      //convertView 재활용할 뷰  //parent-> listView 참조변수
        // 5.1) 혹시 재활용 할 뷰가 없는가?
        if(convertView==null){
            //없다면 만들어라. (LayoutInflater 부르는 법 from context 로 부터)
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView= inflater.inflate(R.layout.listview_item, parent, false);   //직접붙이지마라. false
            // convertView 는 cardView 의 참조변수. 즉, convertView 안에 textView 들이 있음..


            // 5.3) 참조변수를 멤버로 가지고 있는 객체 (ViewHolder) 생성  => 뷰 객체 생성?
            ViewHolder holder= new ViewHolder(convertView);
            convertView.setTag(holder);

        }

        // 5.5) 뷰에 저장되어있는 tag 객체(ViewHolder)를 얻어오기
        ViewHolder holder= (ViewHolder)convertView.getTag();


        // 5.3) 텍스트뷰에 널을 현재번째 position 데이터
        String s= items.get(position);
        holder.tv.setText(s);

        return convertView;      //convertView 를 화면에 보여주기
    }//getView

    // 5.2) 이너클래스
    class ViewHolder{
        TextView tv;

        // 5.4) 생성자
        public ViewHolder(View itemView){           //cardView 가 itemView 로 이동(둘이 같은말임..?)
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
