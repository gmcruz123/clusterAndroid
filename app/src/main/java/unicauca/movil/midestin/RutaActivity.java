package unicauca.movil.midestin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kathe on 15/12/2016.
 */

public class RutaActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
  ListView listView=null;
    static String[] ciudades = {"Cali", "Bogota","Popayan"};
    Button btn;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);

        //Titulo e inicializacion
        setTitle("   COMPRAR O RESERVAR TIQUETE");
        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
             ad.show();
            }
        });
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("            Selecciona la Ciudad ");
        builder.setItems(ciudades, this);

        builder.setNegativeButton("Cancelar",null);
        ad=builder.create();

    }

    @Override
    public void onClick(DialogInterface dialog, int pos) {
          String selectedItem=ciudades[pos];
         Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show();
    }
}
