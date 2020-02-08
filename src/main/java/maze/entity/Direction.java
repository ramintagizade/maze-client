package maze.entity;

public class Direction {

    private Boolean North;
    private Boolean South;
    private Boolean East;
    private Boolean West;

    public Direction(Boolean north, Boolean south, Boolean east, Boolean west) {
        this.North  = north;
        this.South = south;
        this.East = east;
        this.West = west;
    }

    public Boolean getNorth() {
        return North;
    }

    public Boolean getSouth() {
        return South;
    }

    public Boolean getEast() {
        return East;
    }

    public Boolean getWest() {
        return West;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "North=" + North +
                ", South=" + South +
                ", East=" + East +
                ", West=" + West +
                '}';
    }
}
