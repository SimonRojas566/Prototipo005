package pe.edu.upeu.sysventas.repository;

import pe.edu.upeu.sysventas.enums.TipoProducto;
import pe.edu.upeu.sysventas.model.Categoria;
import pe.edu.upeu.sysventas.model.Marca;
import pe.edu.upeu.sysventas.model.Producto;
import pe.edu.upeu.sysventas.model.UnidMedida;

public class ProductoRepository extends AbstractJpaRepository<Producto, Long>{
    private long sequence = 1;

    @Override
    protected Long getId(Producto entity) {
        return entity.getIdProducto();
    }

    @Override
    protected void setId(Producto entity, Long id) {
        entity.setIdProducto(id);
    }

    @Override
    protected Long generateId() {
        return sequence++;
    }

    // --- DATOS ADAPTADOS PARA TIENDA DE ROPA ---
    public void seedData() {
        if (findAll().isEmpty()) {

            Categoria c = new Categoria();
            c.setIdCategoria(1L); // 1 = Polos (según nuestro nuevo CategoriaRepository)

            Marca m = new Marca();
            m.setIdMarca(1L); // 1 = Nike (según nuestro nuevo MarcaRepository)

            UnidMedida u = new UnidMedida();
            u.setIdUnidad(1L); // Asumiendo que 1 es "Unidad" o "Pieza"

            // Usamos el "Builder" para que sea más fácil leer y no confundir el orden de los datos
            Producto productoPrueba = Producto.builder()
                    .idProducto(generateId())
                    .nombre("Polo Deportivo Básico")
                    // NOTA: Si no cambiaste el enum a PRENDA, usa TipoProducto.PRODUCTO
                    .tipoProducto(TipoProducto.PRENDA)
                    .talla("M")                  // <-- Nuevo campo de ropa
                    .color("Negro")              // <-- Nuevo campo de ropa
                    .material("Algodón")         // <-- Nuevo campo de ropa
                    .género("Unisex")            // <-- Nuevo campo de ropa
                    .pu(45.00)
                    .puold(50.00)
                    .utilidad(15.00)
                    .stock(24.0)
                    .stockold(0.0)
                    .idCategoria(c)
                    .idMarca(m)
                    .idUnidad(u)
                    .build();

            save(productoPrueba);
        }
    }
}
