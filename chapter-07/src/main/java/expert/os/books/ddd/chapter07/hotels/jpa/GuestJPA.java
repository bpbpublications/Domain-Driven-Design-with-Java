package expert.os.books.ddd.chapter07.hotels.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
class GuestJPA {

    @Id
    private Long id;

    @Column
    private String documentNumber;

    @Column
    private String name;

    GuestJPA(String documentNumber, String name) {
        this.documentNumber = documentNumber;
        this.name = name;
    }

    public GuestJPA() {
    }

    public Long getId() {
        return id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GuestJPA guestJPA = (GuestJPA) o;
        return Objects.equals(id, guestJPA.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
