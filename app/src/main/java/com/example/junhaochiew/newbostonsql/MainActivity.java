package com.example.junhaochiew.newbostonsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputName,inputCoord, inputDesc;
    TextView text;
    MyDBHandler dbHandler;
    Locations location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = (EditText) findViewById(R.id.editText);
        inputCoord = (EditText) findViewById(R.id.editText2);
        inputDesc = (EditText) findViewById(R.id.editText3);
        text = (TextView) findViewById(R.id.textView);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    public void addButtonClick(View v){
        location = new Locations(inputName.getText().toString().trim(),inputCoord.getText().toString().trim(),inputDesc.getText().toString());
        dbHandler.addLocations(location);
        printDatabase();
    }

    public void deleteButtonClick(View v){
        String name = inputName.getText().toString().trim();
        String[] returneddetails = dbHandler.getLocationDetails(name);
        if(returneddetails[0]!=null){
            long id=Long.parseLong(returneddetails[0]);
            dbHandler.deleteLocation(id);
        }
        printDatabase();

        printDatabase();
    }

    public void printDatabase(){
        String dbString=dbHandler.databaseToString();
        text.setText(dbString);
        inputName.setText("");
    }

    public void getInfo(View v){
        String s = inputName.getText().toString().trim();
        String[] returnedcoords = dbHandler.getLocationDetails(s);

        inputCoord.setText(returnedcoords[1]);
        inputDesc.setText(returnedcoords[2]);
    }

    public void updateDB(View v){
        String name = inputName.getText().toString().trim();
        String coord = inputCoord.getText().toString().trim();
        String desc = inputDesc.getText().toString();
        String[] returneddetails = dbHandler.getLocationDetails(name);
        if(returneddetails[0]!=null){
            long id=Long.parseLong(returneddetails[0]);
            dbHandler.updateData(id,name,coord,desc);
        }
        printDatabase();
    }
}
