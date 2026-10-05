public class Clasico implements Categoria {
    
    private static final double PRECIO_POR_PLAZA = 100.0;

    @Override
    public double precioPlazas(int cantidadPlazas) {
        return (double)(cantidadPlazas * PRECIO_POR_PLAZA);
    }
}
