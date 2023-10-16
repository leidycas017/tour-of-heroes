package co.com.udea.tourofhero.repository;

import co.com.udea.tourofhero.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroRepository {

    Optional<Hero> getHeroById(Integer id);
    Optional<List<Hero>> getHeros();
    Optional<Hero> save(Hero hero);
    void delete(Integer id);
    Optional<Hero> update(Hero hero);

    Optional<List<Hero>> getHeroesContainsTerm(String term);
}
