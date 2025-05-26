package expert.os.books.ddd.chapter06.hotels.controller;

import org.jmolecules.architecture.hexagonal.Adapter;

@Adapter
public record GuestDTO(String documentNumber, String name) {
}
