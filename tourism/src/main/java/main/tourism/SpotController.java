package main.tourism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpotController {

    @Autowired
    public SpotServices spotServices;

    /*
        - GET method : get all spots
        - GET method : get a spot given its id
        - GET method : get a spot given its name
        - GET method : get all spots given its location
    */
    @GetMapping("api/v1/tourism")
    public List<Spot> getAllSpot() {
        return spotServices.getAllSpot();
    }


    @GetMapping("api/v1/tourism/getById/{id}")
    public Spot getSpotById(@PathVariable Long id) {
        return spotServices.getSpotById(id);
    }

    @GetMapping("api/v1/tourism/getByName/{name}")
    public Spot getSpotByName(@PathVariable String name) {
        return spotServices.getSpotByName(name);
    }

    @GetMapping("api/v1/tourism/getByLocation/{location}")
    public List<Spot> getSpotsByLocation(@PathVariable String location) {
        return spotServices.getSpotsByLocation(location);
    }

    /*
    - POST method : add a new spot
    - PUT method : update a spot given its id
    - DELETE method : delete a spot given its id
    */
    @PostMapping("api/v1/tourism/add")
    public Spot addSpot(@RequestBody Spot spot) {
        return spotServices.addSpot(spot);
    }

    @PutMapping("api/v1/tourism/update/{id}")
    public Spot updateSpot(@PathVariable Long id, @RequestBody Spot spot) {
        return spotServices.updateSpot(id, spot);
    }

    @DeleteMapping("api/v1/tourism/delete/{id}")
    public void deleteSpot(@PathVariable Long id) {
        spotServices.deleteSpot(id);
    }
}
