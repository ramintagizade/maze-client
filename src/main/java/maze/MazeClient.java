package maze;


import maze.entity.Direction;
import maze.entity.Position;
import maze.entity.State;
import maze.requests.Request;

public class MazeClient {

    Request request = new Request();
    boolean [][] wasHere = new boolean[50][50];

    public Boolean findCenter() {

        State state = request.GetState();
        Position position = request.GetPosition();

        if (state.getState().equals("TargetReached")) {
            System.out.println("OK found center point " + position);
            return true;
        }

        if(wasHere[position.getX()][position.getY()]) {
            return false;
        }

        Direction direction = request.GetDirections();

        wasHere[position.getX()][position.getY()] = true;

        if(direction.getWest()) {
            request.PostMove("West");
            boolean ok = findCenter();
            if(ok) return true;
            request.PostMove("East");
        }

        if(direction.getEast()) {
            request.PostMove("East");
            boolean ok = findCenter();
            if(ok) return true;
            request.PostMove("West");
        }

        if(direction.getNorth()) {
            request.PostMove("North");
            boolean ok = findCenter();
            if(ok) return true;
            request.PostMove("South");
        }

        if(direction.getSouth()) {
            request.PostMove("South");
            boolean ok = findCenter();
            if (ok) return true;
            request.PostMove("North");
        }

        return false;
    }

    public static void main(String [] args ) {

        MazeClient mazeClient = new MazeClient();
        Request request = new Request();
        request.PostReset();
        mazeClient.findCenter();
    }

}
