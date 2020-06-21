package com.example.jpa_into;

import com.example.jpa_into.model.Auto;
import com.example.jpa_into.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component      // spring zarządza tą klasą w kontenerze
public class Main implements CommandLineRunner {
    @Autowired  // wstrzykiwanie zależności - spring tworzy obiekt wstrzykiwanej klasy w momencie gdy jest taka potrzeba
    private AutoRepository autoRepository;

    public void crudOperations(){
        // INSERT
//        autoRepository.save(new Auto("BMW", "5", 200_000.));
//        autoRepository.save(new Auto("Audi", "A3", 120_000.));
//        autoRepository.save(new Auto("Toyota", "Rav4", 180_000.));
//        autoRepository.save(new Auto("VW", "Passat", 160_000.));
//        autoRepository.save(new Auto("Porshe", "Cayenne", 300_000.));
//        autoRepository.save(new Auto("Volvo", "V80", 180_000.));
//        autoRepository.save(new Auto("Fiat", "Panda", 50_000.));
        // SELECT
        System.out.println("SELECT * FROM Auto");
        autoRepository.findAll().forEach(System.out::println);
        System.out.println("SELECT * FROM Auto ORDER BY price DESC");
        autoRepository.findAll(Sort.by(Sort.Direction.DESC, "price")).forEach(System.out::println);
        System.out.println("SELECT * FROM Auto WHERE autoId = ?");
        Optional<Auto> autoOpt = autoRepository.findById(3);
        autoOpt.ifPresent(System.out::println);
        System.out.println("UPDATE Auto SET price = price * 0.9 WHERE autiId = ?");
        Auto autoToUpdate = autoRepository.findById(3).get();
        autoToUpdate.setPrice(autoToUpdate.getPrice() * 0.9);
        autoRepository.save(autoToUpdate);
        System.out.println("DELETE FROM Auto WHERE price = (SELECT max(price) FROM Auto)");
        Auto mostExpAuto = autoRepository.findAll(Sort.by(Sort.Direction.DESC, "price")).get(0);
        autoRepository.delete(mostExpAuto);
        System.out.println("SELECT * FROM Auto");
        autoRepository.findAll().forEach(System.out::println);
    }
    public void jpaOperations(){
        System.out.println("SELECT * FROM Auto WHERE price between 100_000 AND 200_000");
        
    }
    @Override
    public void run(String... args) throws Exception {
//        crudOperations();
        jpaOperations();
    }
}
