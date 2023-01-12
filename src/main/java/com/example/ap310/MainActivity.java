package com.example.ap310;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> shoppingList = new ArrayList<String>();
    ListView listView;
    ArrayAdapter<String> itemAdapter;


    public void onClick(View view) {
        TextView txt = findViewById(R.id.txtvAdd);
        String item = new String();
        item = String.valueOf(txt.getText());
        addItemtoShoppingList(item);
        displayItemsInShoppingList(shoppingList);
    }

    public void addItemtoShoppingList(String item){

        shoppingList.add(item);
    }

    public void displayItemsInShoppingList(ArrayList<String> array) {
        itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, shoppingList);
        ListView listView = (ListView) findViewById(R.id.lvList);
        listView.setAdapter(itemAdapter);
        longClick();
    }

    public void longClick() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removido", Toast.LENGTH_SHORT).show();
                shoppingList.remove(i);
                itemAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
