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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import unicauca.movil.midestin.Adapters.HorarioAdapter;
import unicauca.movil.midestin.Adapters.ReservaAdapter;
import unicauca.movil.midestin.database.HorarioDao;
import unicauca.movil.midestin.database.TiqueteDao;
import unicauca.movil.midestin.databinding.ActivityMainBinding;
import unicauca.movil.midestin.databinding.TemplateHorarioBinding;
import unicauca.movil.midestin.models.Horario;
import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.models.Usuario;
import unicauca.movil.midestin.util.H;
import unicauca.movil.midestin.util.L;

/**
 * Created by Kathe on 4/06/2017.
 */

public class HorarioActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, HorarioAdapter.OnHorarioListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;
    private NavigationView nvDra;
    HorarioAdapter adapter;
    HorarioDao dao;
    Usuario user ;
    Horario hor;
    int trye;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Log.i("Destino", " Trayecto:"+(Integer) getIntent().getExtras().getSerializable("try"));
        dao=new HorarioDao(this);
        hor= new Horario();
        trye =(Integer) (Integer) getIntent().getExtras().getSerializable("try");;
        user= (Usuario) getIntent().getExtras().getSerializable("user");
        Log.i("Dest","Horarios registrados: "+dao.Count());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,
                binding.drawer,
                R.string.menu_open,
                R.string.menu_close);

        binding.drawer.addDrawerListener(this);
        H.data = new ArrayList<>();
        adapter= new HorarioAdapter(getLayoutInflater(),this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        nvDra=(NavigationView)findViewById(R.id.nav);
        setupDrawerContent(nvDra);

            loadData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        H.data= dao.list(trye);
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
        Log.i("Dest","Horarios registrados: "+dao.Count());
        List<Horario> horarios=dao.list(trye);
        H.data= horarios;
        Log.i("Dest","Horario: "+horarios.size());
        Log.i("Dest","Horario: "+horarios.get(0).getEmpresa());
        Log.i("Dest","Horario: "+horarios);


        adapter.notifyDataSetChanged();

        adapter.notifyDataSetChanged();


    }

    @Override
    public void onHorario(View v) {
        int  pos = binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(this, PagarActivity.class);
        intent.putExtra(PagarActivity.EXTRA_POS,pos);
        startActivity(intent);
    }

    //endregion

}