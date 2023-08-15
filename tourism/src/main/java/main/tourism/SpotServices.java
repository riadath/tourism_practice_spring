package main.tourism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServices {
    @Autowired
    public SpotRepository spotRepository;


    public List<Spot> getAllSpot(){
        return spotRepository.findAll();
    }


    public Spot getSpotByName(String name) {
        return spotRepository.findBySpotName(name);
    }

    public List<Spot> getSpotsByLocation(String location) {
        return spotRepository.findSpotsByLocation(location);
    }

    public Spot getSpotById(Long id) {
        return spotRepository.findById(id).orElse(null);
    }

    public Spot addSpot(Spot spot) {
        return spotRepository.save(spot);
    }

    public Spot updateSpot(Long id, Spot spot) {
        Spot spotToUpdate = spotRepository.findById(id).orElse(null);

        if(spotToUpdate == null){
            System.out.println("Invalid Spot ID");
            throw new IllegalStateException("Invalid Spot ID");
        }

        spotToUpdate.setSpotName(spot.getSpotName());
        spotToUpdate.setOpeningDate(spot.getOpeningDate());
        spotToUpdate.setClosingDate(spot.getClosingDate());
        spotToUpdate.setDescription(spot.getDescription());
        spotToUpdate.setLocation(spot.getLocation());

        spotRepository.save(spotToUpdate);
        return spotToUpdate;
    }

    public void deleteSpot(Long id) {
        boolean exists = spotRepository.existsById(id);
        if(!exists){
            System.out.println("Invalid Spot ID");
            throw new IllegalStateException("Invalid Spot ID");
        }
        spotRepository.deleteById(id);
    }
}
