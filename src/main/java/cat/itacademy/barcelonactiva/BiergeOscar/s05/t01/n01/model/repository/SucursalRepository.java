package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}