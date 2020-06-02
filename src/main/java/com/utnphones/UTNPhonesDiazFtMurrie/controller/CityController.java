package com.utnphones.UTNPhonesDiazFtMurrie.controller;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.Call;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.City;
import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.PhoneLine;
import com.utnphones.UTNPhonesDiazFtMurrie.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController
{
    //Properties:
    private final CityService service;

    //Constructors:
    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    //Methods:
    @PostMapping("/")
    public ResponseEntity<City> addCity(@RequestBody @Valid City city) {
        return ResponseEntity.ok(service.add(city));
    }

    @GetMapping("/")
    ResponseEntity<List<City>> getAllCities() {
        List<City> cityList = service.getAll();
        if (cityList.size() > 0 )
            return ResponseEntity.ok(cityList);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Cabe destacar que mi base de datos esta pensada para autocompletar el numero de telefono con lso areacodes que respectan al usuario en dicho instante
    //Por ese motivo no tengo la necesidad de joinear con ciudades y me es mas performatico hacer el like en la query nativa llamando solo a phonelines y usando phone number en el where
    //En database scripts esta el script de la funcion que auto completa el phonenumber
    //Metodo testeado con junit test version 4
    //Dude en realizarlo utilizando un dto pero no estaria exprimiendo las ventajas que me provee haber orientado parte de la funcionalidad a la base de datos. Mi opinion
    //es que si hubiese diseñado un sistema mas orientado al lado de java me hubiese convenido utilizar dto...
    @GetMapping("/linesbyareacode221")
    public ResponseEntity<List<PhoneLine>> getLinesByAreaCode221()
    {
        List<PhoneLine> list=service.getByAreaCode221();
        if (list.size() > 0 )
            return ResponseEntity.ok(list);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{idCity}")
    ResponseEntity<Optional<City>> getCityById(@PathVariable Integer idCity) {
        Optional<City> city = service.getById(idCity);
        if (city != null)
            return ResponseEntity.ok(city);
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
