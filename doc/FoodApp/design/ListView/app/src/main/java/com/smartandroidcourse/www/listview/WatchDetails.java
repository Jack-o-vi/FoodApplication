package com.smartandroidcourse.www.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class WatchDetails extends AppCompatActivity {
    String [] watch_title,watch_image,watch_price,watch_save,watch_image1,watch_image2,watch_image3,watch_gender,watch_desc;
    int position;
    String getimage1,getimage2,getimage3;

    ImageView watchimage1;
    TextView watchtitle,watchprice,watchsave,watchgender,watchdesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView cart =(ImageView)findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Cart",Toast.LENGTH_SHORT).show();

            }
        });

        Intent i =getIntent();
        position=i.getExtras().getInt("position");
        watch_title=i.getStringArrayExtra("watchtitle");
        watch_image=i.getStringArrayExtra("watchimage");
        watch_price=i.getStringArrayExtra("watchprice");
        watch_save=i.getStringArrayExtra("watchsave");

        watch_image1=i.getStringArrayExtra("watchimage1");
        watch_image2=i.getStringArrayExtra("watchimage2");
        watch_image3=i.getStringArrayExtra("watchimage3");
        watch_gender=i.getStringArrayExtra("watchgender");
        watch_desc=i.getStringArrayExtra("watchdesc");

        watchtitle=(TextView)findViewById(R.id.watchtitle);
        watchtitle.setText(watch_title[position]);

        watchprice=(TextView)findViewById(R.id.watchprice);
        watchprice.setText(watch_price[position]);


        watchsave=(TextView)findViewById(R.id.watchsave);
        watchsave.setText(watch_save[position]);

        watchgender=(TextView)findViewById(R.id.watchgender);
        watchgender.setText(watch_gender[position]);

        watchdesc=(TextView)findViewById(R.id.watchdescrip);
        watchdesc.setText(watch_desc[position]);

         getimage1 = watch_image1[position];
         getimage2 = watch_image2[position];
         getimage3 = watch_image3[position];

        watchimage1 = (ImageView)findViewById(R.id.watchimage1);
        Picasso.with(getApplicationContext())
                .load(getimage1)
                .into(watchimage1);


        ImageButton image1 = (ImageButton)findViewById(R.id.images1);
        Picasso.with(getApplicationContext())
                .load(getimage1)
                .into(image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchimage1 = (ImageView)findViewById(R.id.watchimage1);
                Picasso.with(getApplicationContext())
                        .load(getimage1)
                        .into(watchimage1);
             //   watchimage1.setVisibility(View.VISIBLE);


            }
        });


        ImageButton image2 = (ImageButton)findViewById(R.id.images2);
        Picasso.with(getApplicationContext())
                .load(getimage2)
                .into(image2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchimage1 = (ImageView)findViewById(R.id.watchimage1);
                Picasso.with(getApplicationContext())
                        .load(getimage2)
                        .into(watchimage1);
               // watchimage1.setVisibility(View.VISIBLE);


            }
        });


        ImageButton image3 = (ImageButton)findViewById(R.id.images3);
        Picasso.with(getApplicationContext())
                .load(getimage3)
                .into(image3);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchimage1 = (ImageView)findViewById(R.id.watchimage1);
                Picasso.with(getApplicationContext())
                        .load(getimage3)
                        .into(watchimage1);
              //  watchimage1.setVisibility(View.VISIBLE);


            }
        });




    }

}
