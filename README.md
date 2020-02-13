# Review Challenge

This challenge is about reviewing code. We have built a solution to our normal backend challenge and we want you to review it. To make things clear, you don't have to prepare any code. To make things a little more complex, we added a UI on top of that backend. The rules for that challenge can be found [here](https://github.com/coveo/backend-coding-challenge). We suggest you read them to help you understand the project.

Here are the things we expect from you:

-   Bring a laptop (if not possible we can find a solution, write us back)
-   Be able to run the code (backend and frontend)
-   Be able to debug the part(s) relevant for the position (backend or frontend, both for a fullstack developer) 
-   Make sure you understand what's going on
-   Review the code, take notes on stuff you would improve/change
-   Have an editor or IDE ready to code during the interview

We didn't follow our normal standards, so you should have something to say about that code.

Whether you are a backend, frontend or fullstack developer, we expect you to understand the whole project a minimum and to have an opinion on it. We understand that if you are applying on a backend job you won't have as much knowledge on the frontend, or viceversa, it's normal. We will adjust the time spent on each part according to the position we target for you.

## Running the Backend

It is built using Java 8, Maven and Spring Boot. To build the backend, you will at least need Java 8 and Maven installed on your machine. To run it you have two options:

-   Install an IDE and run the [main class](https://bitbucket.org/fboutin2/review-challenge/src/default/backend/src/main/java/com/coveo/challenge/ReviewChallengeApplication.java)

OR

-   Build it in the terminal running `mvn package` in the backend folder and then run it with this command `java -jar target/review-challenge-0.0.1-SNAPSHOT.jar`

## Running the Frontend

It is built using Typescript and React. To run it, you will need Node.js installed. In the frontend folder, run `npm install` and then `npm run start`. It will open a tab in the browser where you should be able to search cities. Make sure the backend is running, otherwise the search won't work.