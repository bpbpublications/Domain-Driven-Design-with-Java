package expert.os.books.ddd.chapter03.player;

import java.time.Year;
import java.util.Objects;
import java.util.Optional;

public class Player {

    private String name;

    private Year start;

    private Year end;

    private String email;

    private Position position;

    private int goal = 0;

    Player(String name, Year start, Year end, String email, Position position) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.email = email;
        this.position = position;
    }

    @Deprecated
    Player() {
    }

    public String getName() {
        return name;
    }

    public Year getStart() {
        return start;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public Position getPosition() {
        return position;
    }

    public Optional<Year> getEnd() {
        return Optional.ofNullable(end);
    }

    public int getGoal() {
        return goal;
    }

    public void goal() {
        goal++;
    }

    public void setEnd(Year end) {
        if (end != null && end.isBefore(start)) {
            throw new IllegalArgumentException("the last year of a player must be equal or higher than the start.");
        }
        this.end = end;
    }

    public static FluentPlayer name(String name) {
        return new PlayerDSL(Objects.requireNonNull(name, "name is required"));
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }


}
