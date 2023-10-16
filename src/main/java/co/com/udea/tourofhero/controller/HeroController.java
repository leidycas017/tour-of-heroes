package co.com.udea.tourofhero.controller;

import co.com.udea.tourofhero.model.Hero;
import co.com.udea.tourofhero.model.Mensaje;
import co.com.udea.tourofhero.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(HeroController.HERO_URL)
@Api(tags = "Hero Controller")
public class HeroController {

    public static final String HERO_URL = "/heroes";

    private final HeroService service;

    @Autowired
    public HeroController(HeroService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener un héroe por su ID")
    public ResponseEntity<Hero> getHero(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getHeroByCodigo(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Obtener todos los héroes")
    public ResponseEntity<List<Hero>> getHeroes() {
        return new ResponseEntity<>(service.getHeros(), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Agregar un nuevo héroe")
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero) {
        hero.setId((int) (Math.random()*1000+1));
        return new ResponseEntity<>(service.saveHero(hero), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar un héroe por su ID")
    public ResponseEntity<Mensaje> deleteHero(@PathVariable Integer id) {
        service.deleteHero(id);
        return new ResponseEntity<>(new Mensaje( "001", "Hero delete"), HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Actualizar la información de un héroe")
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero) {
        return new ResponseEntity<>(service.updateHero(hero), HttpStatus.OK);
    }


    @GetMapping("/")
    @ApiOperation("Buscar héroes por nombre")
    public ResponseEntity<List<Hero>> searchHeroes(@RequestParam String name) {
        return new ResponseEntity<>(service.searchHeroesContainsTerm(name), HttpStatus.OK);
    }
}
