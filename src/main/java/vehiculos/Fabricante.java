package vehiculos;

import java.util.HashMap;
import java.util.Map;

public class Fabricante {
    private String nombre;
    private Pais pais;
    private static Map<String, Integer> ventasPorFabricante = new HashMap<>();

    public Fabricante(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
        ventasPorFabricante.putIfAbsent(nombre, 0);
    }

    public void aumentarVentas() {
        ventasPorFabricante.put(nombre, ventasPorFabricante.get(nombre) + 1);
        pais.aumentarVentas();
    }

    public static Fabricante fabricaMayorVentas() {
        String nombreMax = null;
        int maxVentas = 0;
        for (Map.Entry<String, Integer> entry : ventasPorFabricante.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                nombreMax = entry.getKey();
            }
        }
        return new Fabricante(nombreMax, null);
    }

    public String getNombre() {
        return nombre;
    }

    public Pais getPais() {
        return pais;
    }
}
