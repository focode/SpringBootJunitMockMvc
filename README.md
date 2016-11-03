# SpringBootJunitMockMvc

Gordon Ramsey, a very smart guy, likes eating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format: [t][Number of items on menu] [amount of satisfaction from eating dish 1][time taken for dish 1] [amount of satisfaction from dish 2][time taken for dish 2]

To build this application command is : mvn clean install

This will also run the test cases automatically from AlgoApplicationTests.java

negative test case has also been implemented 

testing framework is MockMvc

To run this application command is : spring-boot:run

After running the application open http://localhost:8080/gorden



and you will be able to see the maximum satisfaction like this:

Maximum satisfaction that can be attained by Mr. Gorden is :2493893



This solution is derived from knapsack algorithm 

TDD approach has been followed, initially a test case was written for the rest api and it was failed then application was made and finally 

test case passed

Test case class name is : AlgoApplicationTests and MockMvc was the framework that was used for TDD.





