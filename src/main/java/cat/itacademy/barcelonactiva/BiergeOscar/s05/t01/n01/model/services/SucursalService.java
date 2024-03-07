package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
            sucursalDTO.setPk_SucursalID(sucursal.get().getPk_SucursalID());
            sucursalDTO.setNomSucursal(sucursal.get().getNomSucursal());
            sucursalDTO.setPaisSucursal(sucursal.get().getNomSucursal());
            sucursalDTO.setTipusSucursal(sucursalDTO.tipusSucursal(sucursalDTO.getPaisSucursal()));
        }
        return sucursalDTO;
    }

    //gettAll
    public List<SucursalDTO> getAllSucursal(){
        List<Sucursal> llistaSucursal = sucursalRepository.findAll();
        List<SucursalDTO> llistaSucursalDTO = new ArrayList<SucursalDTO>();
        for (Sucursal sucursal : llistaSucursal){
            SucursalDTO sucursalDTO = new SucursalDTO();
            sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
            sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
            sucursalDTO.setPaisSucursal(sucursalDTO.getPaisSucursal());
            sucursalDTO.setTipusSucursal(sucursalDTO.tipusSucursal(sucursalDTO.getPaisSucursal()));
            llistaSucursalDTO.add(sucursalDTO);
        }
        return llistaSucursalDTO;

    }

}
