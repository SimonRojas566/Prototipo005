package pe.edu.upeu.sysventas.repository;

import pe.edu.upeu.sysventas.model.Categoria;

public class CategoriaRepository extends AbstractJpaRepository<Categoria, Long>{
    private long sequence = 1;

    @Override
    protected Long getId(Categoria entity) {
        return entity.getIdCategoria();
    }

    @Override
    protected void setId(Categoria entity, Long id) {
        entity.setIdCategoria(id);
    }

    @Override
    protected Long generateId() {
        return sequence++;
    }

    // --- DATOS ADAPTADOS PARA TIENDA DE ROPA ---
    public void seedData() {
        if (findAll().isEmpty()) {
            save(new Categoria(generateId(), "Polos y Camisas"));
            save(new Categoria(generateId(), "Pantalones y Jeans"));
            save(new Categoria(generateId(), "Casacas y Abrigos"));
            save(new Categoria(generateId(), "Vestidos y Faldas"));
            save(new Categoria(generateId(), "Accesorios"));
        }
    }
}