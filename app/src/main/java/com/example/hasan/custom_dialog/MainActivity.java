package com.example.hasan.custom_dialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShowDialogClick(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View v = getLayoutInflater().inflate(R.layout.custom_dialog_layout, null, false);
        final EditText et1 = v.findViewById(R.id.et1);
        final EditText et2 = v.findViewById(R.id.et2);
        Button btn1 = v.findViewById(R.id.bt1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msj = et1.getText() + " - " + et2.getText();
                Toast.makeText(MainActivity.this, "-->" + msj, Toast.LENGTH_SHORT).show();
            }
        });
        mBuilder.setView(v);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }
}
