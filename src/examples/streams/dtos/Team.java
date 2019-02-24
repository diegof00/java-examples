package examples.streams.dtos;

import java.util.List;

public class Team {

    private String name;
    private Country country;

    private List<ClubWorldCup> clubWorldCupList;

    public Team(String name, List<ClubWorldCup> clubWorldCups, Country country) {
        this.name = name;
        this.clubWorldCupList = clubWorldCups;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClubWorldCup> getClubWorldCupList() {
        return clubWorldCupList;
    }

    public void setClubWorldCupList(List<ClubWorldCup> clubWorldCupList) {
        this.clubWorldCupList = clubWorldCupList;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
