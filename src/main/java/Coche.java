public class Coche extends Vehiculo {
    
    private static final double FACTOR_BLINDAJE = 1.15;
    private boolean estaBlindado;
    private Categoria categoria;
    private int plazas;

    public Coche(String patente, int plazas, Categoria unaCategoria, boolean estaBlindado) {
        super(patente);
        if (plazas <= 0) {
            throw new CantidadPlazasInvalidaException("Cantidad de plazas invalida: " + plazas);
        }
        this.plazas = plazas;
        this.categoria = unaCategoria;
        this.estaBlindado = estaBlindado;
    }

    @Override
    public double precio(int dias) {
        double precioTotalDeAlquiler = (double)((COSTO_BASE + (categoria.precioPlazas(this.plazas))) * dias);
        if (this.estaBlindado == true) {
            precioTotalDeAlquiler *= FACTOR_BLINDAJE;
        }
        return precioTotalDeAlquiler;
    }
}