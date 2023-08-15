package main.tourism;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot,Long>{

    @Query("select s from Spot s where s.spotName = ?1")
    public Spot findBySpotName(String name);

    @Query("select s from Spot s where s.location = ?1")
    public List<Spot> findSpotsByLocation(String location);
}
