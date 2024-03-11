package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.repository.SucursalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService implements ISucursalService{

    private static final List<String> PAISOS_UE = Arrays.asList("alemania", "belgica", "croacia", "dinamarca",
            "españa", "francia", "irlanda", "letonia", "luxemburgo", "paises bajos", "suecia", "bulgaria", "estonia",
            "grecia", "malta", "polonia", "republica checha", "austria", "chipre", "eslovenia", "finlandia", "hunfria",
            "italia", "lituania", "portugal", "rumania");



    @Autowired
    private SucursalRepository sucursalRepository ;

    //add
    @Override
    public Sucursal createSucursal(Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }

    //update
    @Override
    public Sucursal updateSucursal(Sucursal novaSucursal){
        return sucursalRepository.save(novaSucursal);
    }

    //delete
    @Override
    public void deleteSucursal(int id){
        //Sucursal sucursal = sucursalRepository.findById(id).orElseThrow(()->new EntityNotFoundException("sucursal no trobada"));
        sucursalRepository.delete(sucursalRepository.findById(id).orElseThrow(()->new EntityNotFoundException("sucursal no trobada")));
    }

    //getOne
    @Override
    public SucursalDTO getSucursalById(int id){
        SucursalDTO sucursalDTO = new SucursalDTO();
        Sucursal sucursal = sucursalRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Sucursal no trobada"));

        return sucursalDTO = toDTO(sucursal);
    }

    //gettAll
    public List<SucursalDTO> getAllSucursal(){
        List<Sucursal> llistaSucursal = sucursalRepository.findAll();
        List<SucursalDTO> llistaSucursalDTO = new ArrayList<>();
        for (Sucursal sucursal : llistaSucursal){
            llistaSucursalDTO.add(toDTO(sucursal));
        }
        return llistaSucursalDTO;
    }

    public SucursalDTO toDTO(Sucursal sucursal){
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
        sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
        sucursalDTO.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursalDTO.setTipusSucursal(tipoSucursal(sucursal.getPaisSucursal()));
        return sucursalDTO;
    }

    private String tipoSucursal(String paisSucursal) {
        String ue = "";
        if (PAISOS_UE.contains(paisSucursal)){
            ue = "UE";
        } else {
            ue = "FORA UE";
        }
        return ue;
    }


}
