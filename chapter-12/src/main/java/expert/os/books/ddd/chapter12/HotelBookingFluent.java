package expert.os.books.ddd.chapter12;

class HotelBookingFluent {
    private String guestName;
    private int nights;
    private boolean breakfastIncluded;

    private HotelBookingFluent(String guestName) {
        this.guestName = guestName;
    }

    public static HotelBookingFluent bookFor(String guestName) {
        return new HotelBookingFluent(guestName);
    }

    public HotelBookingFluent nights(int nights) {
        this.nights = nights;
        return this;
    }

    public HotelBookingFluent withBreakfast() {
        this.breakfastIncluded = true;
        return this;
    }

    public String confirm() {
        return guestName + " booked for " + nights + " nights. Breakfast: " + (breakfastIncluded ? "Yes" : "No");
    }
}
