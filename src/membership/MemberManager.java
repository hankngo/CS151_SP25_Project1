package membership;

import java.util.HashMap;
import java.util.Map;

public class MemberManager {
    private static final Map<String, Member> members = new HashMap<>();

    public static Member signUp(String firstName, String lastName, String phoneNumber, Member.Tier tier) {
        if (members.containsKey(phoneNumber)) {
            System.out.println("Member already exists!");
            return null;
        }
        Member newMember = new Member(firstName, lastName, phoneNumber, tier);
        members.put(phoneNumber, newMember);
        System.out.println("Membership created successfully!");
        return newMember;
    }

    public static Member signIn(String phoneNumber) {
        return members.get(phoneNumber);
    }
}
