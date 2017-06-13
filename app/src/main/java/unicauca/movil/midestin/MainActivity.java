package unicauca.movil.midestin;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.midestin.Adapters.TiqueteAdapter;
import unicauca.movil.midestin.database.TiqueteDao;
import unicauca.movil.midestin.databinding.ActivityMainBinding;
import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.models.Usuario;
import unicauca.movil.midestin.util.L;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, TiqueteAdapter.OnTiqueteListener {

    ActivityMainBinding binding;
    TiqueteDao dao;
    ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    TiqueteAdapter adapter;
    Tiquete tiq;
    Usuario user ;
    ArrayList<Tiquete> array;
    private NavigationView nvDra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dao=new TiqueteDao(this);
        tiq= new Tiquete();
        //toolbar =(Toolbar) findViewById(R.id.nav_action);
       // setSupportActionBar(toolbar);
        user= (Usuario) getIntent().getExtras().getSerializable("user");
        Log.i("Main", "onCreate:"+user.getNombre());


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,
                binding.drawer,
                R.string.menu_open,
                R.string.menu_close);

        binding.drawer.addDrawerListener(this);
        L.data = new ArrayList<>();
        adapter= new TiqueteAdapter(getLayoutInflater(),this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        nvDra=(NavigationView)findViewById(R.id.nav);
        setupDrawerContent(nvDra);

        int a = dao.Counter("compra", user.getCedula());
        Log.i("Destino", ""+a);
        if(a==0)
        Toast.makeText(this,"Usted no tiene tiquetes registrados",Toast.LENGTH_LONG).show();
        else
        loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.data= dao.list("compra",user.getCedula());
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                }
        );
    }

    public void selectDrawerItem(MenuItem item){
        Intent about;
        switch (item.getItemId()){
            case R.id.nav_reservas:
                about= new Intent(getApplicationContext(), ReservasActivity.class);
                about.putExtra("user", user);
                startActivity(about);
                break;
            case R.id.nav_tiquetes:
                about= new Intent(getApplicationContext(), MainActivity.class);
                about.putExtra("user", user);
                startActivity(about);
                break;
            case R.id.nav_comprar:
                about= new Intent(getApplicationContext(), RutaActivity.class);
                about.putExtra("user", user);
                startActivity(about);
                break;
            case R.id.cerrar:
                about= new Intent(getApplicationContext(), LoginActivity.class);
                about.putExtra("user", user);
                startActivity(about);
                break;


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
        return true;
        }

                return  super.onOptionsItemSelected(item);


    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }




    //region toggle menu

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {

        toggle.onDrawerOpened(drawerView);
        invalidateOptionsMenu();
    }

    @Override
    public void onDrawerClosed(View drawerView) {

        toggle.onDrawerClosed(drawerView);
        invalidateOptionsMenu();
    }



    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion


    //region LoadData
    private void loadData(){

        List<Tiquete> tiquetes=dao.list("compra",user.getCedula());
        L.data= tiquetes;

        adapter.notifyDataSetChanged();

        adapter.notifyDataSetChanged();
    }

    //endregion
    @Override
    public void onTiquete(View v) {
        int  pos = binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(this, DetailActivityTiquete.class);
        intent.putExtra(DetailActivityTiquete.EXTRA_POS,pos);
        intent.putExtra("user",user);
        startActivity(intent);
    }
}
