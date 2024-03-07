package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository ;

    //add
    public Sucursal createSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    //update
    public Sucursal updateSucursal(Sucursal novaSucursal){
        return sucursalRepository.save(novaSucursal);
    }

    //delete
    public void deleteSucursal(int id){
        //Sucursal sucursal = sucursalRepository.findById(id).orElseThrow(()->new EntityNotFoundException("sucursal no trobada"));
        sucursalRepository.delete(sucursalRepository.findById(id).orElseThrow(()->new EntityNotFoundException("sucursal no trobada")));
    }

    //getOne
    public SucursalDTO getSucursalById(int id){
        SucursalDTO sucursalDTO = new SucursalDTO();
        Optional<Sucursal>sucursal = sucursalRepository.findById(id);
        if(sucursal.isEmpty()){
            sucursalDTO = null;
        } else {
            sucursalDTO.getPk_SucursalID()
        }

    }

}
