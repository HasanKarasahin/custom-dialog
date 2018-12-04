package com.example.hasan.custom_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();

    TextView tvReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvReturn = findViewById(R.id.tvReturn);

        listItems = getResources().getStringArray(R.array.shoopingItem);
        checkedItems = new boolean[listItems.length];

    }

    public void btnShowDialogClick(View view) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
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

    public void btnShowDialog1Click(View view) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View v = getLayoutInflater().inflate(R.layout.custom_dialog_layout1, null, false);
        final EditText et1 = v.findViewById(R.id.et1);
        final EditText et2 = v.findViewById(R.id.et2);

        mBuilder.setView(v)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("okey", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String msj = et1.getText() + " - " + et2.getText();
                        Toast.makeText(MainActivity.this, "-->" + msj, Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void btnShowDialogSingleChoiceClick(View view) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Baslik");

        mBuilder.setSingleChoiceItems(listItems, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /*
                if (isChecked) {
                    if (!mUserItems.contains(position)) {
                        mUserItems.add(position);
                    }
                } else {
                    mUserItems.remove(position);
                }*/
            }
        });
        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String item = "";
                for (int i = 0; i < mUserItems.size(); i++) {
                    item += listItems[mUserItems.get(i)];
                    if (i != mUserItems.size() - 1) {
                        item += ", ";
                    }
                }
                tvReturn.setText(item);
            }
        });

        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < checkedItems.length; i++) {
                    checkedItems[i] = false;
                    mUserItems.clear();
                    tvReturn.setText("");
                }
            }
        });
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    public void btnShowDialogMultiChoiceClick(View view) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Baslik");
        mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                if (isChecked) {
                    if (!mUserItems.contains(position)) {
                        mUserItems.add(position);
                    }
                } else {
                    mUserItems.remove(position);
                }
            }
        });

        mBuilder.setCancelable(false);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String item = "";
                for (int i = 0; i < mUserItems.size(); i++) {
                    item += listItems[mUserItems.get(i)];
                    if (i != mUserItems.size() - 1) {
                        item += ", ";
                    }
                }
                tvReturn.setText(item);
            }
        });

        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < checkedItems.length; i++) {
                    checkedItems[i] = false;
                    mUserItems.clear();
                    tvReturn.setText("");
                }
            }
        });
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }
}
