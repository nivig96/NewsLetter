package com.example.nivgoel.newsletter;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
    //  EditText userName;
    //EditText psswrd;
    //Button loginButton;

    private static int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =new Intent(MainActivity.this,ListActivity.class);
                startActivity(i);
            }
        },SPLASH_TIME_OUT);
//        loginButton=(Button)findViewById(R.id.button);
//        userName=(EditText)findViewById(R.id.text1);
//        psswrd=(EditText)findViewById(R.id.text2);
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (userName.getText().toString().trim().equalsIgnoreCase("")||psswrd.getText().toString().trim().equalsIgnoreCase(""))
//                {
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//
//                    // set title
//                    alertDialogBuilder.setTitle("Please fill the required details");
//
//                    // set dialog message
//                    alertDialogBuilder
//                            .setMessage("Click yes to exit!")
//                            .setCancelable(false)
//                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,int id) {
//                                    // if this button is clicked, close
//                                    // current activity
//                                    //finish();
//                                }
//                            })
//                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    // if this button is clicked, just close
//                                    // the dialog box and do nothing
//                                   // dialog.cancel();
//                                    finish();
//                                }
//                            });
//
//                    // create alert dialog
//                    AlertDialog alertDialog = alertDialogBuilder.create();
//
//                    // show it
//                    alertDialog.show();
//                }
//                else
//                {
//                   // Intent intent2= new Intent(MainActivity.this,ListActivity.class);
//                    //startActivity(intent2);
//                }
//            }
//
//        });

    }
}
