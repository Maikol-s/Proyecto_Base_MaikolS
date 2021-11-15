package Objetos;

public class PedidoC {
    private int id;
    private String codigo;
    private int cantidad;
    private String direccion;

    public PedidoC() {
    }

    public PedidoC(int id, String codigo, int cantidad, String direccion) {
        this.id = id;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.direccion = direccion;
    }

    public PedidoC(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString(){
        return id +"  " + codigo +"  "+ cantidad +"  "+direccion;
    }
}
