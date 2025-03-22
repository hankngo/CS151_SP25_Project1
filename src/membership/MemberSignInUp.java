/*
*
* sign in or a create membership area
*
* when create membership is made, phone number and first and last name are required
*
* when creating membership there are 3 tiers to select from, bronze (free), silver (5$ a month), gold (15$ a month)
*
*/


package membership;


import java.util.Scanner;


public class MemberSignInUp {
   private static final Scanner scanner = new Scanner(System.in);


   /* checks to see if you are a member and acts as sign in functionality */
   public static Member handleMembership() {
       System.out.println("Welcome! Are you a member? (yes/no)");
       String response = scanner.nextLine().trim().toLowerCase();


       /* if customer is, they enter your phone number associated with account to sign in */
       if (response.equals("yes")) {
           System.out.println("Enter your phone number:");
           String phone = scanner.nextLine().trim();
           Member member = MemberManager.signIn(phone);
           if (member != null) {
               System.out.println("Welcome back, " + member.getTier() + " Member!");
               return member;
           } else {


           /* if custmer thinks they are a member but they put in a phone number that is not associated with an account */   
               System.out.println("Member not found.");
           }
       }


       /* sign up functionality if the customer types no*/
       System.out.println("Would you like to sign up for membership? (yes/no)");
       response = scanner.nextLine().trim().toLowerCase();


       /* allows customer to put in their information if they choose to sign up */
       if (response.equals("yes")) {
           try {
               System.out.println("Enter First Name:");
               String firstName = scanner.nextLine().trim();
               if (firstName.isEmpty()) throw new IllegalArgumentException("No first name provided.");


               System.out.println("Enter Last Name:");
               String lastName = scanner.nextLine().trim();
               if (lastName.isEmpty()) throw new IllegalArgumentException("No last name provided.");


               System.out.println("Enter Phone Number:");
               String phone = scanner.nextLine().trim();
               if (!phone.matches("\\d{10}")) throw new IllegalArgumentException("Invalid phone number. Must be 10 digits.");


               /* selection of tier of membership */
               System.out.println("Select Membership Tier: 1) Bronze (Free), 2) Silver ($5/month), 3) Gold ($15/month)");
               int tierChoice = Integer.parseInt(scanner.nextLine().trim());
               Member.Tier tier = switch (tierChoice) {
                   case 2 -> Member.Tier.SILVER;
                   case 3 -> Member.Tier.GOLD;
                   default -> Member.Tier.BRONZE;
               };


               return MemberManager.signUp(firstName, lastName, phone, tier);
           } catch (IllegalArgumentException e) {
               System.out.println("Error: " + e.getMessage());
           } catch (Exception e) {
               System.out.println("Unexpected error occurred. Please try again.");
           }
       }


       /* if the customer does not sign in or sign up they proceed as guest by default */
       System.out.println("Proceeding as Guest.");
       return null;
   }
}



