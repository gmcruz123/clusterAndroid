package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import unicauca.movil.midestin.database.UsuarioDao;
import unicauca.movil.midestin.databinding.ActivityLoginBinding;
import unicauca.movil.midestin.databinding.ActivityRegistrarBinding;
import unicauca.movil.midestin.models.Usuario;



public class RegistrarActivity  extends AppCompatActivity {


    ActivityRegistrarBinding binding;
    Usuario usuario;
    UsuarioDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registrar);
        binding.setHandler(this);
        dao= new UsuarioDao(this);
        usuario = new Usuario();
    }

    public void Registrar(){
        String nombre = binding.nombre.getEditText().getText().toString();
        String user =  binding.usr.getEditText().getText().toString();
        String cedula = binding.cedula.getEditText().getText().toString();
        String password =  binding.pass.getEditText().getText().toString();
        int antes= dao.Count();

        Log.i("Destino", "Nombre:"+nombre+" Usr:"+user+" Pass:"+password);
        Log.i("Destino", "antes="+antes);

        if(nombre.isEmpty() || user.isEmpty()|| cedula.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }
        else{

            int a = (int)  Integer.parseInt(cedula);
            usuario.setNombre(nombre);
            usuario.setCedula(a);
            usuario.setPassword(password);
            usuario.setUser(user);
            dao.insert(usuario);
            finish();
            int desp= dao.Count();
            Log.i("Destino", "Cedula:"+a+ "Despues: "+desp);
            if(antes==desp)
            {
                Toast.makeText(this,"Imposible registrar.Cedula o Usuario existente",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Usuario Registrado",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);

            }

        }


    }
}

