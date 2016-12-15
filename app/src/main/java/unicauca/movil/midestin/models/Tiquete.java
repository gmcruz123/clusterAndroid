package unicauca.movil.midestin.models;

/**
 * Created by Kathe on 13/12/2016.
 */

public class Tiquete {
    private String nombre;
    private String empresa;
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private String modo;
    private String imagen;
    private String fechav;


    private int idTiquete;
    private int cedula;
    private int precio;
    private int silla ;


    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public String getNombre() {
        return nombre;
    }
    public String getImagen() {
        return imagen;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setSilla(int silla) {
        this.silla = silla;
    }

    public String getFechav() {
        return fechav;
    }

    public void setFechav(String fechav) {
        this.fechav = fechav;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }


    public double getCedula() {
        return cedula;
    }


    public double getPrecio() {
        return precio;
    }


    public double getSilla() {
        return silla;
    }



}
