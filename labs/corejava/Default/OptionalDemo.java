package Default;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        //List<String> cities = getCities().orElse(Arrays.asList("Delhi"));
        //if (cities != null) {
        //   System.out.println(cities.get(0));
        // }
        //String city=System.out.println(getCity().isPresent()?getCity().get():getCity().orElse("Mumbai"));
        //String city1 = getCity().orElse("Mumbai");
        //System.out.println(city1);

        // Optional<List<String>> cities=getCities().or(()->Optional.of(Arrays.asList("Hyderabad","Noida"));
        getCities().orElseThrow(RuntimeException::new);//()->new RuntimeException();
        getCities().ifPresentOrElse(System.out::println, () -> new Runnable() {
            @Override
            public void run() {
                System.out.println("No cities Found");
            }
        });

        Optional<List<String>> filteredCities=getCities().filter(item->item.contains("Noida")||item.contains("Mumbai"));
        System.out.println(filteredCities);
    }

    private static Optional<List<String>> getCities() {
        Optional<List<String>> cities = Optional.of(Arrays.asList("Bengaluru", "Mumbai", "Pune", "Delhi", "kolkata", "Chennai"));
        return cities;
    }

    // private static List<String> getCities()
    // {
    //return Arrays.asList("Bengaluru","Mumbai","Pune","Delhi","kolkata","Chennai");
    //}

    private static String getCity() {
        return "Bengaluru";
        //return null;
    }

    //private static Optional<String> getCity()
    //{
    //Optional<String> city=Optional.of("Bengaluru");
    //return city;
    //}


}

