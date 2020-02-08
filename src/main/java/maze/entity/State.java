package maze.entity;


public class State {

    private String State;

    public State(String state) {
        this.State = state;
    }

    public String getState() {
        return State;
    }

    @Override
    public String toString() {
        return "State{" +
                "state='" + State + '\'' +
                '}';
    }
}
