package org.example;

import java.util.Scanner; // to read various data types

public class InteractiveOrderProcessor{
	public static void main (String[]args){
		Scanner scanner = new Scanner (System.in); // initialized scanner
		double unitPrice = 0.0;
		int quantity = 0;

		System.out.println("Welcome to the Interactive Order Processor!");
		System.out.println("-- Enter Order Details --"); // prompt user to enter details
		
		System.out.print("Enter unit price: ");
		unitPrice = scanner.nextDouble();

		System.out.print("Enter quantity: ");
		quantity = scanner.nextInt();	

		System.out.print("Is customer a member (true/false)?: ");
		String tempCustomerMembership = scanner.next();
		boolean customerMembership = new Boolean(tempCustomerMembership).booleanValue(); // boxing

		System.out.print("Enter customer tier (Regular, Silver, Gold): ");
		String customerTier = scanner.next();

		System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ");
		String shippingZone = scanner.next();

		System.out.print("Enter discount code (SAVE10, FREESHIP, or \"\" for none): ");
		String discountCode = scanner.next();


		double subTotal = unitPrice * quantity; // declaring it out of the block scope of if-else

		// customer tier discount
		if (customerTier.equals("Gold")){
			subTotal = subTotal - (subTotal*0.15); // apply 15% discount
		} else if (customerTier.equals("Silver")){
			subTotal = subTotal - (subTotal*0.10); // apply 10% discount
		} else { // Regular customer only or unknown tiers
			subTotal = subTotal; // no discount
		}

		// quantity discount
		if (quantity >= 5){
			//subTotal = subTotal - (subTotal*0.05); // apply 5% discount
			subTotal *= 0.95; // another way to apply 5% discount
		}


	}

}

/**
Welcome to the Interactive Order Processor!

--- Enter Order Details ---
Enter unit price: 30.00
Enter quantity: 8
Is customer a member (true/false)?: true
Enter customer tier (Regular, Silver, Gold): Gold
Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ZoneB
Enter discount code (SAVE10, FREESHIP, or "" for none): SAVE10

--- Order Details ---
Unit Price: $30.00
Quantity: 8
Is Member: true
Customer Tier: Gold
Shipping Zone: ZoneB
Discount Code: SAVE10

--- Calculation Steps ---
Initial Subtotal: $240.00
After Tier Discount (Gold - 15%): $204.00
After Quantity Discount (5% for >=5 items): $193.80
After Promotional Code (SAVE10 for >$75): $183.80
After Small Order Surcharge (if applicable): $183.80 (No surcharge)

Shipping Cost: $12.50 (ZoneB)

Final Order Total: $196.30

--- String Equality Demo ---
Enter first string for comparison: Hello
Enter second string for comparison: hello

String 1: "Hello"
String 2: "hello"

String 1 == String 2: false (Compares references, which are different for user input strings)
String 1 .equals() String 2: false (Content is different due to case)
String 1 .equalsIgnoreCase() String 2: true (Content is identical, ignoring case)
**/