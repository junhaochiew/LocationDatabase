package com.example.junhaochiew.newbostonsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputName, inputName2, inputCoord, inputYCoord, inputDesc;
    TextView text;
    MyDBHandler dbHandler;
    Route location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = (EditText) findViewById(R.id.editText);
        inputName2 = (EditText) findViewById(R.id.editText4);
        inputCoord = (EditText) findViewById(R.id.editText2);
        inputYCoord = (EditText) findViewById(R.id.editText5);
        inputDesc = (EditText) findViewById(R.id.editText3);
        text = (TextView) findViewById(R.id.textView);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }

    public void addButtonClick(View v){
        location = new Route(inputName.getText().toString().trim(), inputName2.getText().toString().trim(),Long.parseLong(inputCoord.getText().toString().trim()),
                Long.parseLong(inputYCoord.getText().toString().trim()),inputDesc.getText().toString());
        dbHandler.addLocations(location);
        printDatabase();
    }

    public void deleteButtonClick(View v){
        String location1 = inputName.getText().toString().trim();
        String location2 = inputName2.getText().toString().trim();
        String[] returneddetails = dbHandler.getRouteDetails(location1,location2);
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
        String location1 = inputName.getText().toString().trim();
        String location2 = inputName2.getText().toString().trim();
        String[] returnedcoords = dbHandler.getRouteDetails(location1, location2);

        inputCoord.setText(returnedcoords[1]);
        inputYCoord.setText(returnedcoords[2]);
        inputDesc.setText(returnedcoords[3]);
    }

    public void updateDB(View v){
        String location1 = inputName.getText().toString().trim();
        String location2 = inputName2.getText().toString().trim();
        Long coordx = Long.parseLong(inputCoord.getText().toString().trim());
        Long coordy = Long.parseLong(inputYCoord.getText().toString().trim());
        String desc = inputDesc.getText().toString();
        String[] returneddetails = dbHandler.getRouteDetails(location1, location2);
        if(returneddetails[0]!=null){
            long id=Long.parseLong(returneddetails[0]);
            dbHandler.updateData(id, location1, location2, coordx, coordy, desc);
        }
        printDatabase();
    }

    public void searchAllInstance(View v){
        String location1 = inputName.getText().toString().trim();
        String location2 = inputName2.getText().toString().trim();
        String[] allInstance = dbHandler.searchDB(location1,location2);
        int i=0;
        text.setText(allInstance[0] + "\n" + allInstance[1] + "\n" + allInstance[2]);
    }
}
