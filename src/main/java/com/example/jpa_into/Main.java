package com.example.jpa_into;

import com.example.jpa_into.model.Auto;
import com.example.jpa_into.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component      // spring zarządza tą klasą w kontenerze
public class Main implements CommandLineRunner {
    @Autowired  // wstrzykiwanie zależności - spring tworzy obiekt wstrzykiwanej klasy w momencie gdy jest taka potrzeba
    private AutoRepository autoRepository;

    @Override
    public void run(String... args) throws Exception {
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

    }
}
