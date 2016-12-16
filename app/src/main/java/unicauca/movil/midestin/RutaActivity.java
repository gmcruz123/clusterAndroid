package unicauca.movil.midestin;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Kathe on 15/12/2016.
 */

public class RutaActivity extends AppCompatActivity implements DialogInterface.OnClickListener, DatePickerDialog.OnDateSetListener {
    ActivityRutaBinding binding;
    static String[] ciudades = {"Cali", "Bogota","Popayan"};
    Button btn,btn1;
    AlertDialog ad;
    Ciudad ciudad;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ruta);


        //Titulo e inicializacion
        setTitle("   COMPRAR O RESERVAR TIQUETE");
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

    @Override
    public void onClick(DialogInterface dialog, int pos) {

          String selectedItem=ciudades[pos];
          Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show();
        if(i==1)
         ((TextView) findViewById(R.id.ori)).setText(selectedItem);
        if(i==2)
        ((TextView) findViewById(R.id.des)).setText(selectedItem);
    }




    public void datePicker(View view){
        DatePickerFragment fragment =new DatePickerFragment();
        fragment.show(getFragmentManager(),"date");

    }

    private void setDate(final Calendar calendar){
        final DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.fec)).setText(dateFormat.format(calendar.getTime()));
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
}
