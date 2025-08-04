package org.example;

import java.util.Scanner; // to read various data types

public class InteractiveOrderProcessor{
	public static void main (String[]args){
		Scanner scanner = new Scanner (System.in); // initialized scanner
		double unitPrice = 0.0;
		int quantity = 0;

		System.out.println("Welcome to the Interactive Order Processor!");
		System.out.println("--- Enter Order Details ---"); // prompt user to enter details
		
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
		boolean waivedShippingCost = false;
		double shippingCost;

		System.out.println("\n--- Order Details ---");
		System.out.printf("Unit price: $%.2f\n", unitPrice); // no autoboxing but
		// System.out.println("Unit price: $" + String.valueOf(unitPrice));
		// implicit conversion to string is done
		System.out.println("Quantity: " + quantity);
		System.out.println("Is Member: " + customerMembership);
		System.out.println("Customer Tier: " + customerTier);
		System.out.println("Shipping Zone: " + shippingZone);
		System.out.println("Discount Code: " + discountCode);


		// customer tier discount

		System.out.println("\n--- Calculation Steps ---");
		System.out.printf("Initial Subtotal: $%.2f\n", subTotal);
		System.out.print("After Tier Discount "); 

		if (customerTier.equals("Gold")){
			subTotal = subTotal - (subTotal*0.15); // apply 15% discount
			System.out.printf("(Gold - 15%%): $%.2f\n", subTotal);
		} else if (customerTier.equals("Silver")){
			subTotal = subTotal - (subTotal*0.10); // apply 10% discount
			System.out.printf("(Silver - 10%%): $%.2f\n", subTotal);
		} else { // Regular customer only or unknown tiers
			subTotal = subTotal; // no discount
			System.out.printf("(Regular or Unknown - 0%%): $%.2f\n", subTotal);
		}

		// quantity discount
		System.out.print("After Quantity Discount ");
		if (quantity >= 5){
			//subTotal = subTotal - (subTotal*0.05); // apply 5% discount
			subTotal *= 0.95; // another way to apply 5% discount
			System.out.printf("(5%% for >=5 items): $%.2f\n ",subTotal);
		}else{
			System.out.printf("(<5 items): $%.2f\n ",subTotal);
		}

		// discount code discount
		if (discountCode.equals("SAVE10") && subTotal > 75.0){
			// subTotal = subTotal - 10; // flat 10 discount
			subTotal -= 10;
		}else if (discountCode.equalsIgnoreCase("FREESHIP")){
			waivedShippingCost = true;
		}

		// if after all discounts, subtotal is < 25
		// apply $3 small order charge
		subTotal = (subTotal < 25) ? subTotal+=3 : subTotal; 

		// System.out.println(subTotal); // debug

		final String ZONEB = "ZoneB";

		if (waivedShippingCost == false){
			switch(shippingZone){
				case "ZoneA":
					shippingCost = 5;
					break;
				case ZONEB:
					shippingCost = 12.50;
					break;
				case "ZoneC":
					shippingCost = 20.00;
					break;
				default:
					shippingCost = 25.00;
					break;

			}
		}else{
			shippingCost = 0;
		}

		// System.out.println(shippingCost); // debug




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