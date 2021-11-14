package Objetos;

public class Productos {
    private int id;
    private String[] anime = {"Luffy Gear Fourth","Bleach, Vol.73: Battlefield Burning","Peluche de Koro-sensei","Sudadera sobre Uchiha Itachi"};
    private String[] categoria = {"Figura","Manga","Peluche","Ropa"};
    private int[] precio = {60550,9500,16800,30000};
    private int[] stock = {10,15,5,6};
    private int[] adicional = {450,500,700,600};

    public Productos(){

    }

    public Productos(int id, String[] anime, String[] categoria, int[] precio, int[] stock, int[] adicional) {
        this.id = id;
        this.anime = anime;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.adicional = adicional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getAnime() {
        return anime;
    }

    public void setAnime(String[] anime) {
        this.anime = anime;
    }

    public String[] getCategoria() {
        return categoria;
    }

    public void setCategoria(String[] categoria) {
        this.categoria = categoria;
    }

    public int[] getPrecio() {
        return precio;
    }

    public void setPrecio(int[] precio) {
        this.precio = precio;
    }

    public int[] getStock() {
        return stock;
    }

    public void setStock(int[] stock) {
        this.stock = stock;
    }

    public int[] getAdicional() {
        return adicional;
    }

    public void setAdicional(int[] adicional) {
        this.adicional = adicional;
    }

    public int add(int precio, int adicion){
        int resultado = precio + adicion;
        return resultado;
    }
}
