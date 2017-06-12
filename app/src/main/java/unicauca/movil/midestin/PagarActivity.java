package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;

import unicauca.movil.midestin.database.TiqueteDao;
import unicauca.movil.midestin.databinding.ActivityPagarBinding;
import unicauca.movil.midestin.databinding.ActivityRegistrarBinding;
import unicauca.movil.midestin.models.Horario;
import unicauca.movil.midestin.models.Tiquete;
import unicauca.movil.midestin.models.Usuario;
import unicauca.movil.midestin.util.H;

/**
 * Created by Kathe on 15/12/2016.
 */

public class PagarActivity extends AppCompatActivity {

    public static final String EXTRA_POS = "pos";
    ActivityPagarBinding binding;
    Usuario user;
    TiqueteDao dao;
    Horario res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pagar);
        int pos =  getIntent().getExtras().getInt(EXTRA_POS);
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

    public void goToRegistrar(){

        String nombre = binding.nombre.getEditText().getText().toString();
        String cedula = binding.cedula.getEditText().getText().toString();
        String cuenta = binding.cuenta.getEditText().getText().toString();
        String password =  binding.pass.getEditText().getText().toString();

        int antes= dao.Counter("compra",user.getCedula());
        Log.i("Dest: ", "antes"+antes);

        if(nombre.isEmpty() || cuenta.isEmpty()|| cedula.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }
        else{
           Tiquete tiq= new Tiquete(user.getNombre(),res.getEmpresa(),"Cali","Bogota",res.getFecha(),res.getHora(),
           "compra",res.getImagen(),"2017/07/01",user.getCedula(),res.getPrecio(),5);

            dao.insert(tiq);
            finish();
            int desp= dao.Counter("compra",user.getCedula());
            Log.i("Dest: ", "desp"+desp);
            if(antes==desp)
            {
                Toast.makeText(this,"Imposible registrar",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Tiquete Registrado",Toast.LENGTH_SHORT).show();
                Log.i("Dest","tiq:"+dao.list("compra",user.getCedula()).get(desp-1).getIdTiquete());

                Intent intent = new Intent(this, DetailActivityTiquete.class);
                intent.putExtra("Posicion",desp-1);
                intent.putExtra("user",user);
                startActivity(intent);

            }

        }


    }
}
