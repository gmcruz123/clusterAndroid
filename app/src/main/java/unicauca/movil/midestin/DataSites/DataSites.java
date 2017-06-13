package unicauca.movil.midestin.DataSites;

import java.util.ArrayList;
import java.util.List;
import unicauca.movil.midestin.models.Places;



public class DataSites {
    private static List<Places> places;
    public static List<Places> getPlaces(){

        if (places==null){

            places = new ArrayList<>();
            Places P1 = new Places();
            P1.setNombre("Popayan");
            P1.setLatitud(2.459167);
            P1.setLongitud(-76.600278);

            Places P2 = new Places();
            P2.setNombre("Cali");
            P2.setLatitud(3.44);
            P2.setLongitud( -76.519722);

            Places P3 = new Places();
            P3.setNombre("Bogota");
            P3.setLatitud(4.598889);
            P3.setLongitud( -74.080833);

            places.add(P2);
            places.add(P1);
            places.add(P3);

        }
return  places;

    }


}
