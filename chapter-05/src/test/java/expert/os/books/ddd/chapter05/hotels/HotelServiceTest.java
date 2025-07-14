package expert.os.books.ddd.chapter05.hotels;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {


    @Mock
    private Hotel hotel;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private HotelService service;
    @Test
    void shouldCheckInGuest() {
        Guest guest = new Guest("123", "Ada Lovelace");
        Room room = new Room(101, Room.EMPTY_GUEST);
        Room checkedIn = room.checkIn(guest);

        when(hotel.findEmptyRoom()).thenReturn(Optional.of(room));
        when(hotel.checkIn(Mockito.any())).thenAnswer(invocation -> invocation.getArgument(0));
        Room result = service.checkIn(guest);

        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(result.getNumber()).isEqualTo(101);
            soft.assertThat(result.getGuest()).isEqualTo(guest);
        });

        verify(hotel).checkIn(room);
    }

    @Test
    void shouldCheckOutRoom() {
        Room room = new Room(102, new Guest("456", "Alan Turing"));

        doNothing().when(hotel).checkOut(room);

        service.checkOut(room);

        verify(hotel).checkOut(room);
    }

    @Test
    void shouldFindEmptyRoom() {
        Room emptyRoom = new Room(103, Room.EMPTY_GUEST);

        when(hotel.findEmptyRoom()).thenReturn(Optional.of(emptyRoom));

        Optional<Room> result = hotel.findEmptyRoom();

        assertThat(result).contains(emptyRoom);
    }

    @Test
    void shouldFindReservationByNumber() {
        Room reservedRoom = new Room(104, new Guest("789", "Grace Hopper"));
        when(hotel.reservation("104")).thenReturn(Optional.of(reservedRoom));

        Optional<Room> result = hotel.reservation("104");

        assertThat(result).contains(reservedRoom);
    }

    @Test
    void shouldReturnRoomCount() {
        when(hotel.countBy()).thenReturn(3L);

        Long result = hotel.countBy();

        assertThat(result).isEqualTo(3L);
    }
}