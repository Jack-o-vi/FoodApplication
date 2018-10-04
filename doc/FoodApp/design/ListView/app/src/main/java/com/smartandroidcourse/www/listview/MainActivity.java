package com.smartandroidcourse.www.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import xyz.hanks.library.bang.SmallBangView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridView listView;
    ListAdapter adapter;

    public String judul, src_asset, mp3;
    String[] watch_title,watch_image,watch_price,watch_save;
    String[] watchimage1,watchimage2,watchimage3,watchgender,watchdesc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ImageView cart =(ImageView)findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Cart",Toast.LENGTH_SHORT).show();

            }
        });

      //LIST START


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            judul = extras.getString("judul");
            src_asset = extras.getString("src_asset");
            mp3 = extras.getString("mp3");
        }

        watch_title = getResources().getStringArray(R.array.watchs_titles);
        watch_price = getResources().getStringArray(R.array.watchs_price);
        watch_image = getResources().getStringArray(R.array.watchs_image);
        watch_save = getResources().getStringArray(R.array.watchs_price_save);

        watchimage1 = getResources().getStringArray(R.array.watchs_image1);
        watchimage2 = getResources().getStringArray(R.array.watchs_image2);
        watchimage3 = getResources().getStringArray(R.array.watchs_image3);
        watchgender= getResources().getStringArray(R.array.gender);
        watchdesc= getResources().getStringArray(R.array.description);

        listView=(GridView)findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Intent intent = new Intent(MainActivity.this,WatchDetails.class);
                intent.putExtra("watchtitle",watch_title);
                intent.putExtra("watchimage",watch_image);
                intent.putExtra("position",position);
                intent.putExtra("watchprice",watch_price);
                intent.putExtra("watchsave",watch_save);

                intent.putExtra("watchimage1",watchimage1);
                intent.putExtra("watchimage2",watchimage2);
                intent.putExtra("watchimage3",watchimage3);
                intent.putExtra("watchgender",watchgender);
                intent.putExtra("watchdesc",watchdesc);
                startActivity(intent);

            }

        });


        adapter=new ListAdapter(this,watch_title,watch_image,watch_price,watch_save);
        listView.setAdapter(adapter);

        //LIST END

        //LIKE FUNCTION



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //List METHOD

    public class ListAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        String[] watch_titles,watch_images,watch_prices,watch_save_prices;
        SmallBangView like_heart;
        LayoutInflater inflater;
        public ListAdapter(Context context, String[] watch_titles,String[] watch_images,String[] watch_prices,String[] watch_save_prices) {
            this.context = context;
            this.watch_titles = watch_titles;
            this.watch_images = watch_images;
            this.watch_prices = watch_prices;
            this.watch_save_prices = watch_save_prices;
        }
        @Override
        public int getCount() {
            return watch_titles.length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
// Declare Variables
            String imageget = watch_images[position];
            TextView watchtitle,watchprice,watchsave;
            ImageView watchimage;

            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemView = inflater.inflate(R.layout.watch_list, parent, false);

            watchtitle = (TextView) itemView.findViewById(R.id.watch_title);
            watchprice = (TextView) itemView.findViewById(R.id.watch_price);
            watchsave = (TextView) itemView.findViewById(R.id.watch_price_save);
            watchimage = (ImageView) itemView.findViewById(R.id.watch_images);
            Picasso.with(context)
                    .load(imageget)
                    .into(watchimage);

            watchtitle.setText(watch_titles[position]);
            watchprice.setText(watch_prices[position]);
            watchsave.setText(watch_save_prices[position]);





            return itemView;

        }
    }

    private void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
