package com.example.miniproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String string[]={"Amritsar","Bilaspur","Bangalore","Bhilai","Chennai","Durg","Ellor"};
    ArrayAdapter arrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Main activity", Toast.LENGTH_SHORT).show();

        autoCompleteTextView = findViewById(R.id.city);
        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,string);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setThreshold(1);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.fragment){
           startActivity(new Intent(MainActivity.this,FragmentActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


}
