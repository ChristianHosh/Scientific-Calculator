# Scientific Calculator

This document provides an overview of the data structure course project, a scientific calculator, developed by Christian Hosh in the second year 
of studying computer science at Birzeit University. The project was implemented in Java programming language, and it employs a cursor stack 
data structure that was created manually. The user interface was developed using JavaFX.

# Objective
The objective of the project was to create a scientific calculator that can perform basic arithmetic operations such as addition, subtraction, multiplication, 
and division, as well as advanced mathematical functions such as square root, exponential, trigonometric functions, logarithms, and others. 
The calculator should support parentheses and obey the order of operations.

# Data Structure
The data structure used in the calculator is a cursor stack. A cursor stack is a data structure that is a variation of a stack. 
In a cursor stack, each element has a cursor that points to the previous element. The cursor allows for fast traversal of the stack and easy deletion of elements.

![Screenshot 2023-05-02 002938](https://user-images.githubusercontent.com/104357056/235535477-ca4ffea7-e3a3-4b89-b3e7-1c381b341095.png)
![Screenshot 2023-05-02 002957](https://user-images.githubusercontent.com/104357056/235535479-1fc411b8-4ee2-429a-b542-0d03ffbd3014.png)

# User Interface
The user interface of the calculator was developed using JavaFX. The main window of the calculator contains three textboxes:

Input Textbox: This textbox displays the expression entered by the user.
Postfix Textbox: This textbox displays the postfix notation of the entered expression.
Result Textbox: This textbox displays the final result of the operation.

The user can input expressions using a keypad and the buttons for basic arithmetic operations and advanced functions. The calculator supports keyboard input as well. As the user enters an expression, 
the input textbox updates in real-time. Once the expression is entered, the calculator converts it to postfix notation and displays it in the postfix textbox. 
The final result of the calculation is displayed in the result textbox. The user can clear the input, postfix, and result textboxes using the clear button.


# Functionalities
The calculator supports the following functionalities:

Basic arithmetic operations: addition, subtraction, multiplication, and division.
Advanced mathematical functions: square root, exponential, trigonometric functions, logarithms, and others.
Parentheses: the calculator supports the use of parentheses and obeys the order of operations.

The calculator also supports error detection for input expressions. If the user enters an invalid expression, such as mismatched parentheses or an 
invalid mathematical function, the calculator displays an error message in the result textbox. This functionality helps the user to correct their input 
and avoid incorrect results as shown below.

![Screenshot 2023-05-02 003017](https://user-images.githubusercontent.com/104357056/235535480-d91682ae-7f62-4fa0-8a31-a903e980e382.png)
