# Java OCP Trainer

This java swing application is a centralized project of the previous 2 projects I created during my studies for the Oracle Certified Professional Java 11 developer certification (1Z0-819).

It is a trainer to help memorize operators and deque methods.

It is sufficient to [download the latest jar from here](https://github.com/thermz/OCPTrainer/raw/master/target/OCPJavaTrainer-1.0.jar) and run it.

## **Operators tab**
In the operators trainer tab you need to click start to run the test and then you can click **1, SAME, 2** to select the correct precedence between the 2 randomly chosen operators. When you click stop you have the rate of correct answers. You can always double click on every OK or KO record to check the full message of the related attempt.
![Alt text](OperatorsTrainer.PNG?raw=true "Operators trainer")

## **Deque tab**
This is much easier, it's a simulation of an integer Deque implemented by ArrayDeque (https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html). There is no test here, just a visual training of all the Deque interface methods and how they will affect the Deque.
You can click the Randomize button to speed up the input generation instead of manually inserting a different input everytime.

![Alt text](DequeTrainer.PNG?raw=true "Deque trainer")

Next features: 
- Another tab that tests the user knowledge of the Java functional interfaces.

I'm always open to any suggestion / pull request.

*The Java swing application has been coded with Netbeans IDE support and build with maven.
No external java dependency is necessary for this program to run, only Java runtime version 11 or higher. It works on both Oracle JRE and OpenJDK distributions.*
*This project includes Flat Darcula LaF from https://github.com/JFormDesigner/FlatLaf*
