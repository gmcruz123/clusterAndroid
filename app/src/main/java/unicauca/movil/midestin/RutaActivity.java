package unicauca.movil.midestin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import unicauca.movil.midestin.databinding.ActivityRutaBinding;
import unicauca.movil.midestin.models.Ciudad;
import unicauca.movil.midestin.models.Usuario;



public class RutaActivity extends AppCompatActivity implements DialogInterface.OnClickListener,DrawerLayout.DrawerListener, DatePickerDialog.OnDateSetListener {
    ActivityRutaBinding binding;
    ActionBarDrawerToggle toggle;
    private NavigationView nvDra;
    static String[] ciudades = {"Cali", "Bogota","Popayan"};
    Button btn,btn1;
    AlertDialog ad;
    Usuario user ;
    Ciudad ciudad;
    int i=0, origen, destino,trayecto;
    public static String fecha;
    public static String origen1;
    public static String destino1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ruta);
        user= (Usuario) getIntent().getExtras().getSerializable("user");
        binding.setCiudad(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this,
                binding.drawer,
                R.string.menu_open,
                R.string.menu_close);

        binding.drawer.addDrawerListener(this);
        nvDra=(NavigationView)findViewById(R.id.nav);
        setupDrawerContent(nvDra);


        //Titulo e inicializacion
        setTitle(" COMPRAR O RESERVAR ");
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                ad.show();
                i=1;
            }
        });
        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                ad.show();
                i=2;
            }
        });


        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("            Selecciona la Ciudad ");
        builder.setItems(ciudades, this);

        builder.setNegativeButton("Cancelar",null);
        ad=builder.create();

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
    //region toggle menu

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




    @Override
    public void onClick(DialogInterface dialog, int pos) {

        String selectedItem=ciudades[pos];
        //  Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show();
        if(i==1){
            ((TextView) findViewById(R.id.ori)).setText(selectedItem);
            origen1=ciudades[pos];
            origen=pos;
        }

        if(i==2){
            ((TextView) findViewById(R.id.des)).setText(selectedItem);
            destino1=ciudades[pos];
            destino=pos;
        }


    }




    //region Datepicker
    public void datePicker(View view){
        DatePickerFragment fragment =new DatePickerFragment();
        fragment.show(getFragmentManager(),"date");

    }

    private void setDate(final Calendar calendar){
        final DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.fec)).setText(dateFormat.format(calendar.getTime()));

         fecha = dateFormat.format(calendar.getTime());

    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal= new GregorianCalendar(year,month,day);
        setDate(cal);
    }



    public static  class DatePickerFragment extends DialogFragment{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c=Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)getActivity(),year,month,day) ;
        }
    }
    //endregion

    public void goToReservar(){



    }



    public void goToRuta(){

        String ori = binding.ori.getText().toString();
        String des = binding.des.getText().toString();

        if (ori=="Popayan" && des =="Cali" || ori=="Cali"&& des=="Popayan"){

            origen=1;
            destino=2;
        }




        if (ori=="Popayan" && des =="Bogota" ||ori=="Bogota" && des =="Popayan" ){

            origen=2;
            destino=3;
        }


        if (ori=="Cali" && des =="Bogota"||ori=="Bogota" && des =="Cali" ){

            origen=1;
            destino=3;
        }



        Log.d("Lugares", "ORIGEN:"+origen+" DESTINO:"+destino);

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("ORIGEN", origen);
        intent.putExtra("DESTINO", destino);
        startActivity(intent);





    }



    public void goToRegistrar(){
        Log.i("Destino", " Trayecto:"+trayecto+" origen:"+origen);
        if(origen==destino){
            Toast.makeText(this,"Seleccione correctamente origen y destino",Toast.LENGTH_LONG).show();
        }
        else{

            if(origen==0 && destino==1)
                trayecto=1;
            if(origen==0 && destino==2)
                trayecto=2;
            if(origen==1 && destino==0)
                trayecto=3;
            if(origen==1 && destino==2)
                trayecto=4;
            if(origen==2 && destino==0)
                trayecto=5;
            if(origen==2 && destino==1)
                trayecto=6;


            Log.i("Destino", " Trayecto:"+trayecto+" origen:"+origen);

            Intent intent = new Intent(this, HorarioActivity.class);
            intent.putExtra("try", trayecto);
            intent.putExtra("user", user);
            intent.putExtra("fecha", fecha);
            intent.putExtra("origen", origen1);
            intent.putExtra("destino",destino1);
            startActivity(intent);

        }

    }
}