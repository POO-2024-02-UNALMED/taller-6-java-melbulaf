package vehiculos;

import java.util.HashMap;
import java.util.Map;

public class Pais {
    private String nombre;
    private static Map<String, Integer> ventasPorPais = new HashMap<>();

    public Pais(String nombre) {
        this.nombre = nombre;
        ventasPorPais.putIfAbsent(nombre, 0);
    }

    public void aumentarVentas() {
        ventasPorPais.put(nombre, ventasPorPais.get(nombre) + 1);
    }

    public static Pais paisMasVendedor() {
        String nombreMax = null;
        int maxVentas = 0;
        for (Map.Entry<String, Integer> entry : ventasPorPais.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                nombreMax = entry.getKey();
            }
        }
        return new Pais(nombreMax);
    }

    public String getNombre() {
        return nombre;
    }
}
