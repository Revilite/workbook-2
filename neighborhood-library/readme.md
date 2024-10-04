# Neighborhood Library

## Why is there two files?
Hello! you might be wonder why I have 2 book files, book and bookmap. 

When  I was working on this assignment I wanted to import the CSV file but not make 20+ Book objects hard coded into 
the source files. So I was trying to find a way to dynamically create variable names and google gave me the idea of a HashMap.
Unfortunatley I had to rewrite my entire ui to incorporate this and I didn't know if I was allowed to use a HashMap in this 
project. So instead of deleting everything and rewriting it to incorporate the HashMap. I copied and pasted everything into a 
new file then changed accordingly.

## Which one is Which?
Book.java is the original file which has a ArrayList to store the library. BookMap.java has the HashMap in it. Both files work 
exactly the same and prints exactly the same way. Both incorporate the CSV file using the File class.