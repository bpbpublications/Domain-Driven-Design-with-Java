package expert.os.books.ddd.chapter05.hotels.infra;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import expert.os.books.ddd.chapter05.hotels.Guest;
import expert.os.books.ddd.chapter05.hotels.Hotel;
import expert.os.books.ddd.chapter05.hotels.Room;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
class MemoryHotelTest {


    private final Hotel hotel = new MemoryHotel();
    @Test
    void shouldCheckInRoom() {
        Guest guest = new Guest("123", "Ada Lovelace");
        Room room = new Room(101, guest);
        Room checkedIn = hotel.checkIn(room);

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(checkedIn.getNumber()).isEqualTo(101);
            soft.assertThat(checkedIn.getGuest()).isEqualTo(guest);
            soft.assertThat(hotel.reservation("101")).contains(checkedIn);
        });
    }

    @Test
    void shouldCheckOutRoom() {
        Guest guest = new Guest("123","Alan Turing");
        Room checkedIn = hotel.checkIn(new Room(102, guest));

        hotel.checkOut(checkedIn);

        Optional<Room> updated = hotel.reservation("102");

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(updated).isPresent();
            soft.assertThat(updated.orElseThrow().isEmpty()).isTrue();
        });
    }

    @Test
    void shouldReturnReservationByNumber() {
        Guest guest = new Guest("123","Grace Hopper");
        Room room = hotel.checkIn(new Room(103, guest));
        assertThat(hotel.reservation("103")).contains(room);
    }

    @Test
    void shouldReturnEmptyWhenReservationNotFound() {
        assertThat(hotel.reservation("999")).isEmpty();
    }

    @Test
    void shouldReturnRoomCount() {
        hotel.checkIn(new Room(104, new Guest("321", "Edsger Dijkstra")));
        hotel.checkIn(new Room(105, new Guest("213231", "Barbara Liskov")));

        assertThat(hotel.countBy()).isEqualTo(2L);
    }

    @Test
    void shouldFindEmptyRoom() {
        Guest guest = new Guest("123", "Donald Knuth");
        Room room = new Room(106, guest);
        hotel.checkIn(room);
        hotel.checkOut(room);

        Optional<Room> result = hotel.findEmptyRoom();

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(result).isPresent();
            soft.assertThat(result.orElseThrow().isEmpty()).isTrue();
        });
    }

    @Test
    void shouldNotFindEmptyRoomIfNoneExist() {
        hotel.checkIn(new Room(107, new Guest("123", "Linus Torvalds")));
        assertThat(hotel.findEmptyRoom()).isEmpty();
    }

    @Test
    void shouldFailWhenCheckInWithNullGuest() {
        Room room = new Room(108, Room.EMPTY_GUEST);

        assertThatThrownBy(() -> room.checkIn(null))
                .isInstanceOf(NullPointerException.class);
    }
}