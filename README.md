# Welcome to Fight Club

This is a Command Line Interface game where you can fight with the Robot.

## How to Play
Each **Capital alphabet** is containing a Punch (either from gammer or from robot). You need to enter the alphabet to fight with.

## Before Play, 
### You need to install
  - Java8 or more
  - Maven 3 or more
  - Redis 3.2.8 or more
### You need to configure
  - use [redis.conf](https://github.com/cooligc/SampleFightGame/blob/master/redis.conf) to start your redis
  - Set the Application specification configuration
    1.  Change the redis.host property with the host ip on [config.properties](https://github.com/cooligc/SampleFightGame/blob/master/src/main/resources/config.properties) where you have installed 
    2.  Set fight.in.bout(No of fight that you want to play in one bout . Must be an odd number) and total.no.bout(No of bout that you want to play . Must be an odd number) on [config.properties](https://github.com/cooligc/SampleFightGame/blob/master/src/main/resources/config.properties) based on your selection
 -  Run [app.App](https://github.com/cooligc/SampleFightGame/blob/master/src/main/java/app/App.java) to start the application


[click here](https://cooligc.github.io/coverage-cfg/) to see the code coverage of the application




<iframe src="https://player.vimeo.com/video/218184839" width="640" height="480" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
