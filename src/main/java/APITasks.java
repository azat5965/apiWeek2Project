import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by nurkulov 12/26/19
 */
public class APITasks {

    /*
     * GET all soccer team names listed in given resource
     */
    public static List<String> getAllTeams() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> dataList = (List<Map<String, Object>>) deserializaitedResponse.get("teams");
        List<String> listOfAllTeams = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            listOfAllTeams.add(dataList.get(i).get("name").toString());
        }

        return listOfAllTeams;
    }

    /*
     * GET names of all goalkeepers from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getAllGoalkeepers() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("squad");
        List<String> listOfAllGoalkeepers = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            if (squadList.get(i).get("position") != null) {
                if (squadList.get(i).get("position").toString().equals("Goalkeeper")) {
                    listOfAllGoalkeepers.add(squadList.get(i).get("name").toString());
                }
            }
        }

        return listOfAllGoalkeepers;
    }

    /*
     * GET names of all defenders from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getDefenders() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("squad");
        List<String> Defenders = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            if (squadList.get(i).get("position") != null) {
                if (squadList.get(i).get("position").toString().equals("Defender")) {
                    Defenders.add(squadList.get(i).get("name").toString());
                }
            }
        }

        return Defenders;
    }

    /*
     * GET names of all midfielders from England team
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getMidfielders() throws IOException, URISyntaxException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("squad");
        List<String> listOfMidfielders = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            if (squadList.get(i).get("position") != null) {
                if (squadList.get(i).get("position").toString().equals("Midfielder")) {
                    listOfMidfielders.add(squadList.get(i).get("name").toString());
                }
            }
        }

        return listOfMidfielders;
    }

    /*
     * GET names of all midfielders from England team whose country is Brazil
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getMidfielderFromBrazil() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("squad");
        List<String> listOfMidfielderFromBrazil = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            if (squadList.get(i).get("position") != null) {
                if (squadList.get(i).get("nationality").toString().equals("Brazil")) {
                    if (squadList.get(i).get("position").toString().equals("Midfielder")) {
                        listOfMidfielderFromBrazil.add(squadList.get(i).get("name").toString());
                    }
                }
            }
        }

        return listOfMidfielderFromBrazil;
    }

    /*
     * GET names of all attackers from England team whose origin country is England
     * note: England team id is 66
     * Deserialization type: TypeReference
     */
    public static List<String> getAttackerFromEngland() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/66");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("squad");
        List<String> listOfAttackerFromEngland = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            if (squadList.get(i).get("position") != null) {
                if (squadList.get(i).get("countryOfBirth").toString().equals("England")) {
                    if (squadList.get(i).get("position").toString().equals("Attacker")) {
                        listOfAttackerFromEngland.add(squadList.get(i).get("name").toString());
                    }
                }
            }
        }

        return listOfAttackerFromEngland;
    }

    /*
     * GET name of Spain team coach
     * note: Spain team id is 77
     * Deserialization type: TypeReference
     */
    public static List<String> getSpainCoach() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/teams/77");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("squad");
        List<String> listOfSpainCoach = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            if (squadList.get(i).get("role").toString().equals("COACH")) {
                listOfSpainCoach.add(squadList.get(i).get("name").toString());
            }
        }

        return listOfSpainCoach;
    }

    /*
    GET list of all competitions
    Deserialization type: TypeReference
     */
    public static List<String> getAllCompetitions() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/competitions");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> squadList = (List<Map<String, Object>>) deserializaitedResponse.get("competitions");
        List<String> listOfAllCompetitions = new ArrayList<>();
        for (int i = 0; i < squadList.size(); i++) {
            listOfAllCompetitions.add(squadList.get(i).get("name").toString());
        }

        return listOfAllCompetitions;

    }

    /*
     * GET names of second highest scorrer from competitions of 2000 season
     * note: endpoint for competitions: `competitions/<year>/
     * note: endpoint for scorers: `competitions/<year>/scorers`
     * Deserialization type: TypeReference
     */
    public static List<String> getSecondHighestScorer() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost("api.football-data.org").setPath("v2/competitions/2000/scorers");

        HttpGet GetMethod = new HttpGet(builder.build());
        GetMethod.setHeader("X-Auth-Token", "3d78def18d3442ebaff49ce3e146232c");

        HttpResponse response = client.execute(GetMethod);
        InputStream responseBody = response.getEntity().getContent();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializaitedResponse = objectMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
        });
        List<Map<String, Object>> scorersList = (List<Map<String, Object>>) deserializaitedResponse.get("scorers");

        List<Integer> listOfGoals = new ArrayList<>();
        List<String> listOfNames = new ArrayList<>();
        TreeSet<Integer> sortedNumberOfGoals = new TreeSet();

        for (int i = 0; i < scorersList.size(); i++) {
            sortedNumberOfGoals.add(Integer.parseInt(scorersList.get(i).get("numberOfGoals").toString()));
        }
        for (int goals : sortedNumberOfGoals) {
            listOfGoals.add(goals);
        }
        Integer secondHighNumOfGoals = listOfGoals.get(listOfGoals.size() - 2);

        for (int i = 0; i < scorersList.size(); i++) {
            if (Integer.parseInt(scorersList.get(i).get("numberOfGoals").toString()) == secondHighNumOfGoals) {
                Map<String, Object> playersList = (Map<String, Object>) scorersList.get(i).get("player");
                listOfNames.add(playersList.get("name").toString());
            }
        }
        return listOfNames;
    }
}
