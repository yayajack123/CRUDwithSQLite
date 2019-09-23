package com.example.sqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    FloatingActionButton modStudents;
    FloatingActionButton addStudents;

    private ListView listView;
    private ArrayList<StudentsModel> studentsModelArrayList;
    private CustomAdapterStudent customAdapterStudent;
    private DatabaseHelperStudent databaseHelperStudent;

    public  void setStudentsActivity(){
        addStudents= (FloatingActionButton) findViewById(R.id.btn_add_teacher);
        addStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addStudentr = new Intent(StudentActivity.this, AddStudents.class);
                startActivity(addStudentr);

            }
        });
    }

    public  void modStudentsActivity(){
        modStudents= (FloatingActionButton)findViewById(R.id.btn_teacher_modify);
        modStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modStudentr = new Intent(StudentActivity.this, ModStudent.class);
                startActivity(modStudentr);

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        setStudentsActivity();
        modStudentsActivity();

        listView = (ListView) findViewById(R.id.teachers_lv);
        modStudents.show();
        addStudents.show();

        databaseHelperStudent = new DatabaseHelperStudent(this);

        studentsModelArrayList = databaseHelperStudent.getAllStudent();

        customAdapterStudent = new CustomAdapterStudent(this,studentsModelArrayList);
        listView.setAdapter(customAdapterStudent);



    }

}
