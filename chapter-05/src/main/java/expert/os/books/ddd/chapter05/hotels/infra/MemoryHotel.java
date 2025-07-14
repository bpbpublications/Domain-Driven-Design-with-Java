package expert.os.books.ddd.chapter05.hotels.infra;

import expert.os.books.ddd.chapter05.hotels.Hotel;
import expert.os.books.ddd.chapter05.hotels.Room;
import org.jmolecules.architecture.layered.InfrastructureLayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@InfrastructureLayer
public class MemoryHotel implements Hotel {

    private final Map<Integer, Room> rooms = new HashMap<>();

    @Override
    public Room checkIn(Room room) {
        Objects.requireNonNull(room, "room can not be null");
        rooms.put(room.getNumber(), room);
        return room;
    }

    @Override
    public void checkOut(Room room) {
        Objects.requireNonNull(room, "room can not be null");
        rooms.computeIfPresent(room.getNumber(), (number, existing) -> {
            existing.cleanRoom();
            return existing;
        });
    }

    @Override
    public Optional<Room> reservation(String number) {
        Objects.requireNonNull(number, "room number can not be null");
        return Optional.ofNullable(rooms.get(Integer.parseInt(number)));
    }

    @Override
    public Long countBy() {
        return (long) rooms.size();
    }

    @Override
    public Optional<Room> findEmptyRoom() {
        return rooms.values().stream()
                .filter(Room::isEmpty)
                .findFirst();
    }
}
