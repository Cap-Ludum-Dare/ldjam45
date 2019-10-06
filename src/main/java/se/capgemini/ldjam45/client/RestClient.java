package se.capgemini.ldjam45.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import se.capgemini.ldjam45.model.Score;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestClient {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Score> getScores() {
        HttpGet request = new HttpGet("https://ld45score.azurewebsites.net/scores");
        return request(request);
    }

    public List<Score> getHighScore() {
        HttpGet request = new HttpGet("https://ld45score.azurewebsites.net/highscore");
        return request(request);
    }

    public List<Score> getTop3Scores() {
        HttpGet request = new HttpGet("https://ld45score.azurewebsites.net/top3");
        return request(request);
    }

    public String saveScore(String username, int score) {
        HttpPost request = new HttpPost("https://ld45score.azurewebsites.net/savescore?username=" + username + "&score=" + score);
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {

            HttpResponse response = null;
            response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

            return "saved";

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<Score> request(HttpGet getRequest) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {

            HttpResponse response = null;
            response = httpClient.execute(getRequest);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + statusCode);
            }

            //Now pull back the response object
            HttpEntity httpEntity = response.getEntity();
            String apiOutput = EntityUtils.toString(httpEntity);

            JsonNode nodes = objectMapper.readValue(apiOutput, JsonNode.class);
            List<Score> scores = new ArrayList<>();

            for (JsonNode node : nodes) {
                Score dto = new Score();
                dto.setUsername(node.at("/username").asText());
                dto.setScore(node.at("/score").asInt());
                scores.add(dto);
            }
            return scores;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
