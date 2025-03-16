package cafe;

public class Member {
    public enum Tier { BRONZE, SILVER, GOLD }
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Tier tier;
    private int points;
    private int orderCount;
    
    private static final int POINTS_PER_DOLLAR_BRONZE = 250;
    private static final int POINTS_PER_DOLLAR_SILVER = 350;
    private static final int POINTS_PER_DOLLAR_GOLD = 500;
    private static final int POINTS_TO_DOLLAR = 10000;
    private static final double DISCOUNT_SILVER = 0.05;
    private static final double DISCOUNT_GOLD = 0.15;
    
    public Member(String firstName, String lastName, String phoneNumber, Tier tier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.tier = tier;
        this.points = 0;
        this.orderCount = 0;
    }
    
    public void addPoints(double amountSpent) {
        switch (tier) {
            case BRONZE -> points += amountSpent * POINTS_PER_DOLLAR_BRONZE;
            case SILVER -> points += amountSpent * POINTS_PER_DOLLAR_SILVER;
            case GOLD -> points += amountSpent * POINTS_PER_DOLLAR_GOLD;
        }
    }
    
    public double applyDiscount(double total) {
        orderCount++;
        if (orderCount % 5 == 0) {
            switch (tier) {
                case SILVER -> total *= (1 - DISCOUNT_SILVER);
                case GOLD -> total *= (1 - DISCOUNT_GOLD);
            }
        }
        return total;
    }
    
    public boolean redeemPoints(int pointsToRedeem) {
        if (pointsToRedeem <= points) {
            points -= pointsToRedeem;
            return true;
        }
        return false;
    }
    
    public double convertPointsToCash() {
        return (double) points / POINTS_TO_DOLLAR;
    }
    
    public String getTier() {
        return tier.name();
    }
}

