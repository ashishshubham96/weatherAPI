Weather Forecast Microservice
1.This microservice is responsible for fetching data from open weather api based on the city name and returns the weather forecast for next 3 days in every 3hours invertal.

2.It has an API which is a GET-Mapping. It takes 'city name' in the params.

3.Contoller package is responsible for exposing the API.

4.Controller Class calls the service layer, where which the help of rest template it fetaches response from open weather API.

5.After the reponse is fetched it is sent to Utility layer for processing the response.

6.Based on the given condition a forecast summary is added. 

7.if temperature greater than 40 degree display a message "Use sunscreen lotion".

8.if its raining then display a message "Carry umbrella."

9.if its wind speed is greater than 10.0 the display the message "It's too windy, watch out!".

10.if its thunderstrom display the message "Don't step out! A strom is brewing!".

11.The development is done following all the coding standards and the code follows SOLID principles.

12.Every Class is repsonsible for only one change.

13.The microserice is developed in a such a way that it can be scaled easily.

14.Coding standards and design patterns are used in the microservice, like builder, strategy etc.

15.the microservice is very well deployed build and deplyed in Github.

16.CI/CD pipeline are also created for building the 'master' branch.

17.Dockerfile is also created to to create a docker image and based on the docker image application can we runned form docker application in desktop.

18.Swaggers are also configured in the microservice.

19.A sequence diagram for the flow of inside the microservice is also added and its path is "ss.drawio.png".

20.Since the microservice is dependent on the a 3rd party API, so there might be a senerio when the 3rd party API is down and we might get some exceptions. To Handle this sererio I have added Caching to int the service layer, where it maps the city name with the retured object response and display the same response even if the 3rd party API is down.
