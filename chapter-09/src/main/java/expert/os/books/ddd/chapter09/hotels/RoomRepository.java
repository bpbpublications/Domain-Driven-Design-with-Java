package expert.os.books.ddd.chapter09.hotels;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    Optional<Room> findByGuestIsNull();

    Optional<Room> findByNumber(Long number);
}
