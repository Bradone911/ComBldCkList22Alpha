package com.bignerdranch.android.combldcklist2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//                             create an arraylist object to store items
    ArrayList<String> selectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        create and instance of ListView
        ListView build_list=(ListView) findViewById(R.id.checkable_list);
//        set multiple selection mode
        build_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items = {"ATX tower case","Power Supple","CPU","ATX MotherBoard","Processor","RAM/Memory",
                "Hard Drive","Graphics/VideoCard","Sound Card","Cooling Fans"};
//        supple data items to ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout,R.id.txt_lan,items);
        build_list.setAdapter(adapter);
        build_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                selected item
                String selectedItem = ((TextView)view).getText().toString();
                if (selectedItem.contains(selectedItem))    {
                    selectedItems.remove(selectedItem);      //removes item from the list. it does not work right now
                }
                else
                    selectedItems.add(selectedItem);    //add selected item to list. does not work right now
            }
        });
    }
    public void showSelectedItems(View view)    {
        String items = "";
        for (String item:selectedItems) {
            item += "-" +item+"\n";
        }
        Toast.makeText(this,"You have installed \n" + items,Toast.LENGTH_LONG).show();
    }

//    public void showSelectedItems(View view)    {
//        String selItems = "";
//        for (String item:selectedItems) {
//            if (selItems=="")
//                selItems=item;
//            else
//                selItems += "/" + item;
//        }
//        Toast.makeText(this,selItems,Toast.LENGTH_LONG).show();
}
