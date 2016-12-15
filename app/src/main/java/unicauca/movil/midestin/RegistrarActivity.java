package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import unicauca.movil.midestin.databinding.ActivityLoginBinding;
import unicauca.movil.midestin.databinding.ActivityRegistrarBinding;

/**
 * Created by Kathe on 15/12/2016.
 */

public class RegistrarActivity  extends AppCompatActivity {


    ActivityRegistrarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registrar);
        binding.setHandler(this);


    }

    public void goToMain(){
        String name = binding.nombre.getEditText().getText().toString();
        String usr =  binding.usr.getEditText().toString();
        int ced = Integer.valueOf(binding.cedula.getEditText().getText().toString());
        String pass =  binding.pass.getEditText().getText().toString();

        Log.i("Destino", "Nombre:"+name+" Cedula:"+ced+" Usr:"+usr+" Pass:"+pass);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

