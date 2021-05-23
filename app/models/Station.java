package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Station extends Model {
    public String name;
    public Double lat;
    public Double lng;
    @OneToMany(cascade = CascadeType.ALL)
    public List < Reading > readings = new ArrayList < Reading > ();

    public Station(String name, Double lat, Double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }
}