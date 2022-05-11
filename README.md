# String Calculator

This is a simple string calculator with only one public method: int Add(string numbers).
The add function receive a string as input and returns the sum of the numbers contained in the string

---
The main branch contains the full solution with all the steps including the bonus.
The evolution of functionality is in branches as follows:

*Branch:* **Step 1** 

1. Create a simple String calculator with a method: int Add(string numbers)
  - The numbers in the string are separated by a comma.
  - Empty strings should return 0.
  - The return type should be an integer.
  - Example input: “1,2,5” - expected result: “8”.
  - Write tests to prove your input validates.

*Branch:* **Step 2** 

2. Change the Add method to handle new lines in the input format
  - Example: “1\n,2,3” - Result: “6”
  - Example 2: “1,\n2,4” - Result: “7”

*Branch:* **Step 3** 

3. Support a custom delimiter
 - The beginning of your string will now contain a small control code that lets you
    set a custom delimiter.
 - Format: “//[delimiter]\n[delimiter separated numbers]”
 - Example: “//;\n1;3;4” - Result: 8
 - In the above you can see that following the double forward slash we set a
    semicolon, followed by a new line. We then use that delimiter to split our
    numbers.
 - Other examples:
    - i. “//$\n1$2$3” - Result: 6
    - ii. “//@\n2@3@8” - Result: 13

*Branch:* **Step 4** 

4. Calling add with a negative number should throw an exception: “Negatives not allowed”.
    The exception should list the number(s) that caused the exception
    
*Branch:* **Bonus** 

5. Bonus
  - 5.1 Numbers larger than 1000 should be ignored.
  -  5.2 Delimiters can be arbitrary length
  -  5.3 Allow for multiple delimiters 
  -  5.4 Combine 2 and 3 bonus questions. Allow multiple delimiters of arbitrary length

