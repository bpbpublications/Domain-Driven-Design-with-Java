package expert.os.books.ddd.chapter12;

class HotelBooking {
    private final String guestName;
    private final int nights;
    private final boolean breakfastIncluded;

    private HotelBooking(Builder builder) {
        this.guestName = builder.guestName;
        this.nights = builder.nights;
        this.breakfastIncluded = builder.breakfastIncluded;
    }

    public static class Builder {
        private String guestName;
        private int nights;
        private boolean breakfastIncluded;

        public Builder guestName(String guestName) {
            this.guestName = guestName;
            return this;
        }

        public Builder nights(int nights) {
            this.nights = nights;
            return this;
        }

        public Builder includeBreakfast(boolean breakfastIncluded) {
            this.breakfastIncluded = breakfastIncluded;
            return this;
        }

        public HotelBooking build() {
            return new HotelBooking(this);
        }
    }

    @Override
    public String toString() {
        return guestName + " booked for " + nights + " nights. Breakfast: " + (breakfastIncluded ? "Yes" : "No");
    }
}
