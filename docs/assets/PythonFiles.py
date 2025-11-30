# comment simepl if program

x = 24
y = 20
list = [10, 20, 30, 40, 50]

if (x not in list):
    print("x is NOT present in given list")
else:
    print("x is present in given list")

if (y in list):
    print("y is present in given list")
else:
    print("y is NOT present in given list")

*******************************************************

#Ternary operators also known as conditional expressions are operators that 
# evaluate something based on a condition being true or false.
a, b = 10, 20
min = a if a < b else b

print(min)

#Operator Precedence
expr = 10 + 20 * 30
print(expr)
name = "Alex"
age = 0

if name == "Alex" or name == "John" and age >= 2:
    print("Hello! Welcome.")
else:
    print("Good Bye!!")

    # o/p is Hello! Welcome.

   # Operator Associativity

   print(100 / 10 * 10)
print(5 - 2 + 3)
print(5 - (2 + 3))
print(2 ** 3 ** 2)

# o/p is 100.0
# 6
# 0
# 512