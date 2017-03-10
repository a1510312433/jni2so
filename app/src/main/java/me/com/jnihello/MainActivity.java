package me.com.jnihello;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.com.jnihello.adapter.RecyAdapter;
import me.com.jnihello.bean.RecyBean;
import me.com.jnihello.common.RecyclerItemClickListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        TextView textView = ((TextView) findViewById(R.id.hello));
        textView.setText(JNIMethod.sayHello());

        for (int i = 0; i < 99; i++) {
            list.add(new RecyBean("我的位置是" + i));
        }
        adapter = new RecyAdapter(list);

        recyclerView = ((RecyclerView) findViewById(R.id.recy));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(recyclerView) {

            @Override
            public void onItemClick(RecyAdapter.recyViewHolder holder,int position) {
//                holder.getItemId();
//                holder.itemtext.setText("");
                Toast.makeText(MainActivity.this,"我的顺序是"+position+holder.itemtext.getText(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(RecyAdapter.recyViewHolder holder, int position) {
                Toast.makeText(MainActivity.this,"长按-我的顺序是"+position+holder.itemtext.getText(),Toast.LENGTH_LONG).show();
            }
        });

    }

    RecyAdapter adapter;
    List<RecyBean> list = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(MainActivity.this,JNIMethod.sayHello(),Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.vertical) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Toast.makeText(this, "纵向listview", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.horizental) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
            Toast.makeText(this, "横向listview", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.pubu) {
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
            Toast.makeText(this, "瀑布流", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.grid) {
            recyclerView.setLayoutManager(new GridLayoutManager(this,3));
            Toast.makeText(this, "gridview", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
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
}
