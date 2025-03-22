/*
* stores and manages the memberships of the cusomters and instantiates the sign in functionality
*/


package membership;


import java.util.HashMap;
import java.util.Map;


public class MemberManager {


   /* creates hashmap to store members information in */
   private static final Map<String, Member> members = new HashMap<>();


   /* sign up function for members */
   public static Member signUp(String firstName, String lastName, String phoneNumber, Member.Tier tier) {
      
       /* prevents duplicates */
       try {
           if (members.containsKey(phoneNumber)) {
               throw new IllegalArgumentException("Invalid phone number. Phone number already in use.");
           }


           /* creates new member */
           Member newMember = new Member(firstName, lastName, phoneNumber, tier);
           members.put(phoneNumber, newMember);
           System.out.println("Membership created successfully!");
           return newMember;
       } catch (IllegalArgumentException e) {
           System.out.println("Error: " + e.getMessage());
           return null;
       }
   }


   /* sign in function for existing members */
   public static Member signIn(String phoneNumber) {
       return members.get(phoneNumber);
   }
}
