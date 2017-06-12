package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import unicauca.movil.midestin.databinding.ActivityPagarBinding;
import unicauca.movil.midestin.databinding.ActivityRegistrarBinding;
import unicauca.movil.midestin.models.Horario;
import unicauca.movil.midestin.models.Usuario;
import unicauca.movil.midestin.util.H;

/**
 * Created by Kathe on 15/12/2016.
 */

public class PagarActivity extends AppCompatActivity {

    public static final String EXTRA_POS = "pos";
    ActivityPagarBinding binding;
    Usuario user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pagar);

        int pos =  getIntent().getExtras().getInt(EXTRA_POS);
        Horario res = H.data.get(pos);





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

        Intent intent = new Intent(this, DetailActivityReserva.class);
        startActivity(intent);
    }
}
