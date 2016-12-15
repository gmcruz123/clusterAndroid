package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import unicauca.movil.midestin.databinding.ActivityPagarBinding;
import unicauca.movil.midestin.databinding.ActivityRegistrarBinding;

/**
 * Created by Kathe on 15/12/2016.
 */

public class PagarActivity extends AppCompatActivity {

   ActivityPagarBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pagar);
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
}
