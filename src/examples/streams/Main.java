package examples.streams;

import examples.streams.dtos.Country;
import examples.streams.dtos.ClubWorldCup;
import examples.streams.dtos.Team;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> yearsRealMadridChampion = Arrays.asList(2014, 2016, 2017, 2018);
        Team realMadridCF = new Team("Real Madrid CF", getClubWorldCups(yearsRealMadridChampion), Country.SPAIN);

        List<Integer> yearsBarcelonaChampion = Arrays.asList(2009, 2011, 2015);
        Team barcelonaFC = new Team("FC Barcelona", getClubWorldCups(yearsBarcelonaChampion), Country.SPAIN);

        Team fcBayernMunich = new Team("FC Bayern Munich", Arrays.asList(new ClubWorldCup(2013)), Country.GERMANY);

        List<Team> teamList = Arrays.asList(realMadridCF, barcelonaFC, fcBayernMunich);

        List<Integer> yearsWithGermanChampion = getChampionsYearByCountry(teamList, Country.GERMANY);
        yearsWithGermanChampion.forEach(System.out::println);

        List<Integer> yearsWithSpainChampion = getChampionsYearByCountry(teamList, Country.SPAIN);
        yearsWithSpainChampion.forEach(System.out::println);

        Team mostTimesChampion = teamList.stream().max(Comparator.comparingInt(item->item.getClubWorldCupList().size())).get();
        System.out.println(mostTimesChampion.getName());

        Team lessTimesChampion = teamList.stream().min(Comparator.comparingInt(team->team.getClubWorldCupList().size())).get();
        System.out.println(lessTimesChampion.getName());

    }

    private static List<Integer> getChampionsYearByCountry(List<Team> teamList, Country country) {
        return teamList.stream().filter(team -> country.equals(team.getCountry()))
                .flatMap(team -> team.getClubWorldCupList().stream())
                .map(cup -> cup.getYear()).collect(Collectors.toList());
    }

    private static List<ClubWorldCup> getClubWorldCups(List<Integer> years) {
        return years.stream().map(year -> new ClubWorldCup(year)).collect(Collectors.toList());
    }
}
