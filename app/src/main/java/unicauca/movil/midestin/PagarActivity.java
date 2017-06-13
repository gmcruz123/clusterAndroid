package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import unicauca.movil.midestin.database.TiqueteDao;
import unicauca.movil.midestin.databinding.ActivityPagarBinding;
import unicauca.movil.midestin.databinding.ActivityRegistrarBinding;
import unicauca.movil.midestin.models.Horario;
import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.models.Usuario;
import unicauca.movil.midestin.util.H;


public class PagarActivity extends AppCompatActivity {

    public static final String EXTRA_POS = "pos";
    ActivityPagarBinding binding;
    Usuario user;
    TiqueteDao dao;
    Horario res;
    String fecha;
    String origen;
    String destino;
    final DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.MEDIUM);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pagar);
        int pos =  getIntent().getExtras().getInt(EXTRA_POS);

        fecha = getIntent().getExtras().getString("fecha");
        origen=  getIntent().getExtras().getString("origen");
        destino=getIntent().getExtras().getString("destino");

        res = H.data.get(pos);
        user= (Usuario) getIntent().getExtras().getSerializable("user");
        dao= new TiqueteDao(this);
        binding.setUser(user);
        binding.setHandler(this);



    }

    public void goToMain(){
        String name = binding.nombre.getEditText().getText().toString();

        int ced = Integer.valueOf(binding.cedula.getEditText().getText().toString());
        String pass =  binding.pass.getEditText().getText().toString();

        Log.i("Destino", "Nombre:"+name+" Cedula:"+ced+" Pass:"+pass);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToRegistrar(int  tipo){


        String Modo;
        String nombre = binding.nombre.getEditText().getText().toString();
        String cedula = binding.cedula.getEditText().getText().toString();
        String cuenta = binding.cuenta.getEditText().getText().toString();
        String password =  binding.pass.getEditText().getText().toString();
        Calendar calendar = Calendar.getInstance();


        if(tipo==1)
            Modo="compra";
        else
            Modo="reserva";

        int antes= dao.Counter(Modo,user.getCedula());
        Log.i("Dest: ", "antes"+antes);

        if(nombre.isEmpty() || cuenta.isEmpty()|| cedula.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }

        else{

           Tiquete tiq= new Tiquete(user.getNombre(),res.getEmpresa(),origen,destino,fecha,res.getHora(),
           Modo,res.getImagen(),fecha+"",user.getCedula(),res.getPrecio(),5);

            dao.insert(tiq);
            finish();
            int desp= dao.Counter(Modo,user.getCedula());
            Log.i("Dest: ", "desp"+desp);
            if(antes==desp)
            {
                Toast.makeText(this,"Imposible registrar",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Tiquete Registrado",Toast.LENGTH_SHORT).show();
                Log.i("Dest","tiq:"+dao.list(Modo,user.getCedula()).get(desp-1).getIdTiquete());

                if(tipo==1)
                {Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("Posicion",desp-1);
                    intent.putExtra("user",user);
                    startActivity(intent);}
                else {
                    Intent intent = new Intent(this, ReservasActivity.class);
                    intent.putExtra("Posicion",desp-1);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }


            }

        }


    }
}
