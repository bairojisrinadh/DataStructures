package com.ds.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/* Problem Statement: Unique email addresses */
public class Problem_929 {
    /**
     * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * Output: 2
     * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
     */

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (int i = 0, len = emails.length; i < len; i++) {
            String email = emails[i];
            int atIdx = email.indexOf('@');
            String localName = email.substring(0, atIdx);
            localName = localName.replace(".", "");
            email = localName + email.substring(atIdx);
            if (email.contains("+")) {
                int plusIdx = email.indexOf('+');
                atIdx = email.indexOf('@');
                email = email.substring(0, plusIdx) + email.substring(atIdx);
            }
            uniqueEmails.add(email);
        }

        for (String email : uniqueEmails) {
            System.out.println(email);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
