package main.tourism;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class TourismApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourismApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SpotRepository spotRepository) {
        return args -> {
            List<Spot> spotList = new ArrayList<>();
            List<String> LocationList = new ArrayList<>();

            LocationList.add("Japan");
            LocationList.add("Italy");
            LocationList.add("France");
            LocationList.add("Australia");
            LocationList.add("Thailand");

            Random rand = new Random(898);
            for(int i = 0;i < 10;i++){
                spotList.add(new Spot(
                        "Spot " + i,
                        LocalDate.of(2021, 1, 1),
                        LocalDate.of(2021, 12, 31),
                        "Description " + i,
                        LocationList.get(rand.nextInt(LocationList.size()))
                ));
            }


            spotRepository.saveAll(
                    spotList
            );


        };
    }

}
