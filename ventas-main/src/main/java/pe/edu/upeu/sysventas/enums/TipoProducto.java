package pe.edu.upeu.sysventas.enums;

import lombok.Getter;

@Getter
public enum TipoProducto {
    PRENDA("Prenda de Vestir"),
    ACCESORIO("Accesorio"),
    CALZADO("Calzado"),
    SERVICIO("Servicio (Arreglos/Sastrería)");

    String descripcion;

    TipoProducto(String descripcion){
        this.descripcion = descripcion;
    }
}