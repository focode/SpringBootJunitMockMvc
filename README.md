# SpringBootJunitMockMvc

Approach has been changed, This problem has been now solved with knapsack algorithm. A utility "KnapsackUtility" which implements Knapsack algorithm
has been written 

Also negative test case has been written which take input as string "abc" and expects bad request

This application can be build with mvn clean install

This application can be run on embedded tomcat server with mvn spring-boot:run 

Open browser and goto http://localhost:8080/1000

and you will be given out with maximum satisfaction that Mr Gorden can attain.




# Please ignore previous description below
Gordon Ramsey, a very smart guy, likes eating food. Now, Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant. You will be given a text file with the following format: [t][Number of items on menu] [amount of satisfaction from eating dish 1][time taken for dish 1] [amount of satisfaction from dish 2][time taken for dish 2]

To build this application command is : mvn clean install

To run this application command is : spring-boot:run

After running the application open http://localhost:8080/100

here 100 is time input

and you will be able to see the maximum satisfaction like this:

Maximum satisfaction that can be attained by Mr. Gorden in 100 is :168349

Please enter time in incremental order only.

This solution is derived from Abstract programming 

TDD approach has been followed, initially a test case was written for the rest api and it ws failed then application was made and finally 

test case passed

Test case class name is : AlgoApplicationTests and MockMvc was the framework that was used for TDD.



