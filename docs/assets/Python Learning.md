print("I have no Indentation ")
    print("I have tab Indentation ")
Output:

ERROR!
Traceback (most recent call last):
  File "<main.py>", line 2
    print("I have tab Indentation ")
IndentationError: unexpected indent

**Explanation:

first print statement has no indentation, so it is correctly executed.

second print statement has tab indentation, but it doesn't belong to a new block of code. Python expects the indentation level to be consistent within the same block. This inconsistency causes an IndentationErro



```
x, y = input("Enter two values: ").split()
print("Number of boys: ", x)
print("Number of girls: ", y)
 
x, y, z = input("Enter three values: ").split()
print("Total number of students: ", x)
print("Number of boys is : ", y)
print("Number of girls is : ", z)
```
