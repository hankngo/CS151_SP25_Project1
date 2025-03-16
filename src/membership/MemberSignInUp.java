package membership;

import java.util.Scanner;

public class MemberSignInUp {
    private static final Scanner scanner = new Scanner(System.in);

    public static Member handleMembership() {
        System.out.println("Welcome! Are you a member? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            System.out.println("Enter your phone number:");
            String phone = scanner.nextLine().trim();
            Member member = MemberManager.signIn(phone);
            if (member != null) {
                System.out.println("Welcome back, " + member.getTier() + " Member!");
                return member;
            } else {
                System.out.println("Member not found.");
            }
        }

        System.out.println("Would you like to sign up for membership? (yes/no)");
        response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
            System.out.println("Enter First Name:");
            String firstName = scanner.nextLine().trim();
            System.out.println("Enter Last Name:");
            String lastName = scanner.nextLine().trim();
            System.out.println("Enter Phone Number:");
            String phone = scanner.nextLine().trim();

            System.out.println("Select Membership Tier: 1) Bronze (Free), 2) Silver ($5/month), 3) Gold ($15/month)");
            int tierChoice = Integer.parseInt(scanner.nextLine().trim());
            Member.Tier tier = switch (tierChoice) {
                case 2 -> Member.Tier.SILVER;
                case 3 -> Member.Tier.GOLD;
                default -> Member.Tier.BRONZE;
            };

            return MemberManager.signUp(firstName, lastName, phone, tier);
        }

        System.out.println("Proceeding as Guest.");
        return null;
    }
}
