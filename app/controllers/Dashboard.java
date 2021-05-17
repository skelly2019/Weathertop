package controllers;

import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.findAll();
    render ("dashboard.html", member,stations);
  }

  public static void deleteStation (Long id, Long stationid)
  {
    Member member = Member.findById(id);
    Station station = Station.findById(stationid);
    member.stations.remove(station);
    member.save();
    station.delete();
    Logger.info ("Deleting " + station.name + station.lat + station.lng);
    redirect ("/dashboard");
  }

  public static void addStation (String name, Double lat, Double lng)
  {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station (name,lat, lng);
    member.stations.add(station);
    member.save();
    Logger.info ("Adding a new station called " + name + lat + lng);
    station.save();
    redirect ("/dashboard");
  }

}
