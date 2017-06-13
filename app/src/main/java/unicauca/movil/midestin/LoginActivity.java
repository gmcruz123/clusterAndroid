package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import unicauca.movil.midestin.database.UsuarioDao;
import unicauca.movil.midestin.databinding.ActivityLoginBinding;
import unicauca.movil.midestin.models.Usuario;



public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    Usuario usuario;
    UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);
        dao= new UsuarioDao(this);
        usuario = new Usuario();
    }

    public void goToMain(){
        String user =  binding.usr.getEditText().getText().toString();
        String password =  binding.pass.getEditText().getText().toString();

        if( user.isEmpty()||  password.isEmpty()){
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_SHORT).show();
        }
        else{
             Log.i("Destino", " Usr:"+user+" Pass:"+password);

             usuario=dao.getByLogin(user,password);
            if(usuario==null){
                Toast.makeText(this,"¡ERROR! Verifique sus datos ",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"¡Bienvenid@ "+ usuario.getNombre()+"!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("user", usuario);
                startActivity(intent);
            }
        }
    }

    public void goToRegistrar(){

        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);
    }
}

