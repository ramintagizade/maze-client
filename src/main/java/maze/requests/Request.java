package maze.requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import maze.entity.Direction;
import maze.entity.Position;
import maze.entity.State;
import maze.http.MazeHttpClient;
import maze.utils.PositionDeserializer;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class Request {

    public Direction GetDirections() {
        MazeHttpClient mazeHttpClient = new MazeHttpClient();
        HttpResponse response = mazeHttpClient.sendGetRequest("http://localhost:8080/directions");
        Direction direction;
        try {
            String json = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();
            direction = gson.fromJson(json, Direction.class);
            System.out.println(direction);
        }
        catch (Exception e) {
            direction = null;
        }

        return direction;
    }

    public Position GetPosition() {
        MazeHttpClient mazeHttpClient = new MazeHttpClient();
        HttpResponse response = mazeHttpClient.sendGetRequest("http://localhost:8080/position");
        Position position;
        try {
            String json = EntityUtils.toString(response.getEntity());
            Gson gson = new GsonBuilder()
                            .registerTypeAdapter(Position.class, new PositionDeserializer())
                            .create();
            position = gson.fromJson(json,Position.class);

            System.out.println(position);
        }
        catch (Exception e) {
            position = null;
        }

        return position;
    }

    public State GetState() {
        MazeHttpClient mazeHttpClient = new MazeHttpClient();
        HttpResponse response = mazeHttpClient.sendGetRequest("http://localhost:8080/state");
        State state;
        try {
            String json = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();
            state = gson.fromJson(json,State.class);
            System.out.println(state);
        }
        catch (Exception e) {
            state = null;
        }
        return state;
    }

    public void PostMove(String direction) {
        MazeHttpClient mazeHttpClient = new MazeHttpClient();
        mazeHttpClient.sendPostRequest("http://localhost:8080/move", direction);
    }

    public void PostReset() {
        MazeHttpClient mazeHttpClient = new MazeHttpClient();
        mazeHttpClient.sendPostRequest("http://localhost:8080/reset", null);
    }
}
