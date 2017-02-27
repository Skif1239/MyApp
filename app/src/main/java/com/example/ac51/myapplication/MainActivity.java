package com.example.ac51.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgPhone;
    ImageView imgEmail;

    String phoneNumber = "tel:0732006249";
    String toEmail = "oblako_loungebar@ukr.net";
    String subjectPep = "New TEXT";
    String textPep = "New TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPhone = (ImageView)findViewById(R.id.phone);
        imgEmail = (ImageView)findViewById(R.id.email);

        imgPhone.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.phone):
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                startActivity(phoneIntent);
                break;
            case (R.id.email):
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{toEmail});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectPep);
                emailIntent.putExtra(Intent.EXTRA_TEXT, textPep);

                emailIntent.setType("message/rfc822");

                startActivity(emailIntent.createChooser(emailIntent, "Способ отправки Email:"));
                break;
        }
    }
}
