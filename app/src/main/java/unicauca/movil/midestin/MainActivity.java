package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import unicauca.movil.midestin.Adapters.TiqueteAdapter;
import unicauca.movil.midestin.databinding.ActivityMainBinding;
import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.util.L;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, TiqueteAdapter.OnTiqueteListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

   TiqueteAdapter adapter;

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
        adapter= new TiqueteAdapter(getLayoutInflater(),this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));

        loadData();
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
    public void onTiquete(View v) {
        int  pos = binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(this, DetailActivityTiquete.class);
        intent.putExtra(DetailActivityTiquete.EXTRA_POS,pos);
        startActivity(intent);
    }
}
