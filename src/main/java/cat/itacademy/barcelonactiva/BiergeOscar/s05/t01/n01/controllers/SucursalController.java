package cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.BiergeOscar.s05.t01.n01.model.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    //para que te devuelva a la pagina de inicio
    @GetMapping
    public String homePage(){
        return "redirect:/sucursal/getAll";
    }
    //TODO mirar como utilizar Model model:
    //https://github.dev/rokysf/Tasca-S5.01/tree/main/S05T01N01MonsIglesiasJordi/src
}
