package expert.os.books.ddd.chapter05.hotels;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.Objects;

@Entity
public class Room {

    public static final Guest EMPTY_GUEST = new Guest("0", "EMPTY");

    @Identity
    private int number;

    private Guest guest;

    public int getNumber() {
        return number;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room checkIn(Guest guest) {
        Objects.requireNonNull(guest, "guest can not be null");
        this.guest = guest;
        return this;
    }

    public void cleanRoom() {
        this.guest = EMPTY_GUEST;
    }

    public Room(int number, Guest guest) {
        this.number = number;
        this.guest = guest;
    }

    public boolean isEmpty() {
        return EMPTY_GUEST.equals(guest);
    }


}
