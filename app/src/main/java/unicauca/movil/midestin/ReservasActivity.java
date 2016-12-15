package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import unicauca.movil.midestin.Adapters.ReservaAdapter;
import unicauca.movil.midestin.databinding.ActivityMainBinding;
import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.util.L;

/**
 * Created by Kathe on 14/12/2016.
 */

public class ReservasActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, ReservaAdapter.OnReservaListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;
    private NavigationView nvDra;
    ReservaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,
                binding.drawer,
                R.string.menu_open,
                R.string.menu_close);

        binding.drawer.addDrawerListener(this);
        L.data = new ArrayList<>();
        adapter= new ReservaAdapter(getLayoutInflater(),this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        nvDra=(NavigationView)findViewById(R.id.nav);
        setupDrawerContent(nvDra);
        loadData();
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
                startActivity(about);
                break;
            case R.id.nav_tiquetes:
                about= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(about);
                break;


        }
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;

        return  super.onOptionsItemSelected(item);

    }
    //region toggle menu

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion


    //region LoadData
    private void loadData(){


        Tiquete r1 = new Tiquete();
        r1.setIdTiquete(1);
        r1.setEmpresa("Bolivariano");
        r1.setNombre("Tasha");
        r1.setDestino("Cali");
        r1.setOrigen("Popayan");
        r1.setEmpresa("Bolivariano");
        r1.setFecha("2016-12-13");
        r1.setModo("compra");
        r1.setHora("9:00");
        r1.setPrecio(70000);
        r1.setSilla(2);
        r1.setFechav("2016-12-11");
        r1.setCedula(1235);
        r1.setImagen("http://www.lacosechaparrillada.com/wp-content/uploads/2015/03/para-inicio-centro-FILEminimizer.jpg");

        Tiquete r2 = new Tiquete();
        r2.setIdTiquete(2);
        r2.setDestino("Cali");
        r2.setNombre("Tasha");
        r2.setEmpresa("Bolivariano");
        r2.setOrigen("Bogotá");
        r2.setEmpresa("Bolivariano");
        r2.setFecha("2016-12-13");
        r2.setModo("compra");
        r2.setPrecio(70000);
        r2.setFechav("2016-12-11");
        r2.setHora("12:00");
        r2.setCedula(124);
        r2.setSilla(5);
        r2.setImagen("http://www.lacosechaparrillada.com/wp-content/uploads/2015/03/para-inicio-centro-FILEminimizer.jpg");

        L.data.add(r1);
        L.data.add(r2);

        adapter.notifyDataSetChanged();
    }

    //endregion
    @Override
    public void onReserva(View v) {
        int  pos = binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(this, DetailActivityReserva.class);
        intent.putExtra(DetailActivityReserva.EXTRA_POS,pos);
        startActivity(intent);
    }
}
