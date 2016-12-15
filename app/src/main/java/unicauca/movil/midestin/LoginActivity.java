package unicauca.movil.midestin;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import unicauca.movil.midestin.databinding.ActivityLoginBinding;

/**
 * Created by Kathe on 13/12/2016.
 */

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);


    }

    public void goToMain(){
        String usr =  binding.usr.getEditText().getText().toString();
        String pass =  binding.pass.getEditText().getText().toString();

        Log.i("Destino", "Usr:"+usr+" Pass:"+pass);

        Intent intent = new Intent(this, ReservasActivity.class);
        startActivity(intent);
    }
}

