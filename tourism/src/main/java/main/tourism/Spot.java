package main.tourism;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "Spot")
@Table(
        name = "spot"
)

public class Spot {
    @Id
    @SequenceGenerator(
            name = "spots_sequence",
            sequenceName = "spots_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "spots_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private long Id;
    @Column(
            name="spot_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String spotName;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private String description;
    @Column(
            nullable = false
    )
    private String location;
    //constructor without ID

    public Spot() {
    }

    public Spot(long id, String spotName, LocalDate openingDate, LocalDate closingDate, String description, String location) {
        Id = id;
        this.spotName = spotName;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.description = description;
        this.location = location;
    }

    public Spot(String spotName, LocalDate openingDate, LocalDate closingDate, String description, String location){
        this.spotName = spotName;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.description = description;
        this.location = location;
    }


    public void setId(long id) {
        Id = id;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

