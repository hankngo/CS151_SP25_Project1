/*
*
* there will be 3 tiers (bronze, silver, and gold)
*
* bronze will get 250 points for dollar spent
*
* silver will get 350 points for every dollar spent, and gets a 5% discount for every 5 orders made
*
* gold will get 500 points for every dollar spent, and a 15% discount for every 5 orders made
*
* 10,000 points equivalent to a dollar in value
*
* the use of these points is not mandatory and can be saved up to be used whenever the customer feels like it, and the points that are not used can be saved for later use
*
*/


package membership;


public class Member{


   /* The data that customers need to enter to register as a member */
   private String firstName;
   private String lastName;
   private String phoneNumber;


   /* The different tiers of membership the cafe offers */
   public enum Tier {
       BRONZE,
       SILVER,
       GOLD
   }


   private Tier tier;


   public String getTier() {
       return tier.name();
   }


   /* Points gained for every dollar spent */
   private int points;
   private static final int pointsBronze = 250;
   private static final int pointsSilver = 350;
   private static final int pointsGold = 500;


   /* 10,000 points is equivilent to 1$ */
   private static final int pointDollarConverion = 10000;


   /* Discount percentage given for every 5 orders made */
   public static final double discountSilver = 0.05;
   public static final double discountGold = 0.15;


   /* adds points to user account */
   public void addPoints (double dollarsSpent) {
       switch (tier) {
           case BRONZE -> points += dollarsSpent * pointsBronze;
           case SILVER -> points += dollarsSpent * pointsSilver;
           case GOLD -> points += dollarsSpent * pointsGold;
       }
   }


   /* converts members point balance into usable store credit cash amount */
   public double convertPointsToCash() {
       return (double) points / pointDollarConverion;
   }


   /* custom exception that is for insufficient points */
   public static class InsufficientPointsException extends RuntimeException {
       public InsufficientPointsException (String message) {
           super(message);
       }
   }


   /* redeems points if point equivilent meets the menu item cost dollar amount */
   public boolean redeemPoints(int valueRedeemed) {
       try {
           if (valueRedeemed > points) {
               throw new InsufficientPointsException("Insufficient point balance for this purchase.");
           }
           points -= valueRedeemed;
           return true;
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
           return false;
       }
   }


   /* tracks the number of orders a customer makes */
   private int orderCount;


   /* creates customers membership account */
   public Member(String firstName, String lastName, String phoneNumber, Tier tier) {
       if (firstName == null || firstName.trim().isEmpty()) {
           throw new IllegalArgumentException("No first name provided.");
       }
       if (lastName == null || lastName.trim().isEmpty()) {
           throw new IllegalArgumentException("No last name provided.");
       }
       if (!phoneNumber.matches("\\d{10}")) {
           throw new IllegalArgumentException("Invalid phone number. Must be 10 digits.");
       }


       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.tier = tier;
       this.points = 0;
       this.orderCount = 0;
   }


   /* applies discount for every 5 orders made based on the tier of membership the customer has */
   public double applyDiscount(double total) {
       orderCount++;
       if (orderCount % 5 == 0) {
           switch(tier) {
               case SILVER -> total *= (1 - discountSilver);
               case GOLD -> total *= (1 - discountGold);
           }
       }
       return total;
   }
}
