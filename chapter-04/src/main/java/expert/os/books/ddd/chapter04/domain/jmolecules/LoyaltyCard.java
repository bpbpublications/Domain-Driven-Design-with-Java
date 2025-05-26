package expert.os.books.ddd.chapter04.domain.jmolecules;


import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

@AggregateRoot
public class LoyaltyCard {

    @Identity
    private final String id;

    private final Customer customer;
    private LoyaltyPoints loyaltyPoints;
    private boolean isPremium;
    private CustomerCategory category;

    public LoyaltyCard(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.loyaltyPoints = new LoyaltyPoints(0);
        this.isPremium = false;
        this.category = CustomerCategory.BRONZE;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPoints() {
        return loyaltyPoints.points();
    }

    public boolean isPremium() {
        return isPremium;
    }

    public CustomerCategory getCategory() {
        return category;
    }

    public void addPoints(int points) {
        this.loyaltyPoints = loyaltyPoints.addPoints(points);
        updateCategory();
        if (loyaltyPoints.canUpgradeToPremium()) {
            this.isPremium = true;
        }
    }

    private void updateCategory() {
        this.category = CustomerCategory.getCategoryByPoints(loyaltyPoints.points());
    }
}
