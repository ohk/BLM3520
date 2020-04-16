package com.example.blm3520;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 5;
    EditText noteBody;
    EditText noteTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note);
        File folder = new File(NoteActivity.this.getDataDir() + File.separator + "Notes");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        noteTitle = findViewById(R.id.editText);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noteTitle.getText().toString().length() ==  0){
                    Toast.makeText(getApplicationContext(),"You have to enter a name of your note!", Toast.LENGTH_LONG).show();
                }else{
                    Save(noteTitle.getText().toString());
                }

            }
        });

        Button buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(NoteActivity.this, NoteSelect.class);
                startActivityForResult(myIntent, REQUEST_CODE);
            }
        });
        noteBody = findViewById(R.id.etNote);

        (findViewById(R.id.btn_note_back)).setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent menu = new Intent(NoteActivity.this,Menu.class);
                startActivity(menu);
            }
        });
    }


    public void Save(String fileName) {
        try {
            String filePath = NoteActivity.this.getDataDir() +
                    File.separator + "Notes" + File.separator + fileName;
            OutputStreamWriter out =
                    new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
            out.write(noteBody.getText().toString());
            out.close();
            Toast.makeText(this, "Note saved!", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public String Open(String fileName) {
        String content = "";
        try {
            String filePath = NoteActivity.this.getDataDir() +
                    File.separator + "Notes" + File.separator + fileName;
            InputStream in = new FileInputStream(filePath);
            if ( in != null) {
                InputStreamReader tmp = new InputStreamReader( in );
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                } in .close();
                content = buf.toString();
            }
        } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        return content;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == REQUEST_CODE && requestCode == REQUEST_CODE) {
            noteBody.setText(Open(data.getExtras().getString("note")));
            noteTitle.setText(data.getExtras().getString("note"));
        }
        else {
            noteBody.setText("");
            noteTitle.setText("");
        }
    }




}
