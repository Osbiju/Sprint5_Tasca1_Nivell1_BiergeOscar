package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@Controller
@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    //para que te devuelva a la pagina de inicio
    @GetMapping
    public String homePage(){
        return "redirect:/show-sucursal/getAll";
    }

    //add
    @GetMapping("/add")
    public String registroAddSucursal(Model modelo){
        Sucursal sucursal = new Sucursal();
        modelo.addAttribute("sucursal", sucursal);
        return "crear_sucursal";
    }
    @PostMapping("/add")
    public String createSucursal(@ModelAttribute("sucursal") Sucursal sucursal){
        sucursalService.createSucursal(sucursal);
        return "redirect:/sucursal/getAll";
    }

    //update
    @GetMapping("/update")
    public  String registroUpdateSucursal(Integer id, Model modelo){
        SucursalDTO sucursalDTO = sucursalService.getSucursalById(id);
        Sucursal sucursal = new Sucursal();
        sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        modelo.addAttribute("sucursal", sucursal);
        return "edit_sucursal";
    }
    @PostMapping("/update")
    public String updateSucursal(@ModelAttribute("sucursal") Sucursal sucursal){
        sucursalService.updateSucursal(sucursal);
        return "redirect:/sucursal/getAll";
    }

    //getOne
    @GetMapping("/getOne/{id}")
    public String getSucursalById(@PathVariable("id") int id, Model modelo){
        modelo.addAttribute("sucursals", sucursalService.getSucursalById(id));
        return "sucursals";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable("id") int id){
        sucursalService.deleteSucursal(id);
        return "sucursals";
    }

    //getAll
    @GetMapping("/getAll")
    public String getAllSucursals(Model modelo){
        modelo.addAttribute("sucursals", sucursalService.getAllSucursal());
        return "sucursals";
    }


    //TODO mirar como utilizar Model model:
    //https://github.dev/rokysf/Tasca-S5.01/tree/main/S05T01N01MonsIglesiasJordi/src
}
