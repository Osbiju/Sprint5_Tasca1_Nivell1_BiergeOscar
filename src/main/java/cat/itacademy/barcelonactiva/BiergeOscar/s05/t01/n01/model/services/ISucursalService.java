package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {
    Sucursal createSucursal(Sucursal sucursal);
    Sucursal updateSucursal(Sucursal novaSucursal);
    void deleteSucursal(int id);
    SucursalDTO getSucursalById(int id);
    List<SucursalDTO> getAllSucursal();
}
