# Name: Ethan Joshua Camingao
## Example:

<img src="https://github.com/ethan-josh/JC-Dynamic-E-commerce-Order-Processor/blob/main/output.png" alt="Example output"/>

### Notes/Observations:
1. Order of Precedence

```System.out.print("String 1 == String 2: " + stringToCompare1==stringToCompare2);``` 

In this line of code I wrote, I was curious as to why I was only seeing `false` instead of 
`String 1 == String 2: false`. Upon further observation, the `+` takes precedence over `==`. Hence, to get the desired output I had to rewrite that to:

```System.out.print("String 1 == String 2: " + (stringToCompare1==stringToCompare2));```

This will work since `()` takes precedence over the `+`.

- **P**lease (Parentheses, ., [], post ++/--)
- **U**se (Unary)
- **M**y (Multiplicative)
- **A**unt's (Additive)
- **S**pecial (Shift)
- **R**ecipes (Relational/instanceof)
- Equality (`==`, `!=`)

2. 
```
System.out.printf("Unit price: $%.2f\n", unitPrice); 
        // This is not autoboxing to String but rather
		// System.out.println("Unit price: $" + String.valueOf(unitPrice));
		// implicit conversion to string is done
```
This is important since it means that there was no new object created.