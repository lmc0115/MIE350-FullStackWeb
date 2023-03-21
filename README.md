# MIE350-FullStackWeb
# 1.0 Executive Summary
Soccer is a very popular sport all around the world with a considerable amount of soccer fans willing to check accurate game information and discuss it together. The team was activated by the enthusiasm of those soccer fans and decided to design an Online Community Site that is related to Premier League discussions with official accurate information.
The team uses interviews, task analysis, and scenarios to identify the requirements of this website that help design the back end and the front end. In the design process, the team considers both the functional requirements and the non-functional requirements.
For functional requirements, the designed website is supposed to contain the data of both soccer teams and soccer players in the Premier League. To make it convenient for soccer fans, namely the users, to check the data that they look for, the data displayed on this website should have a filter function and the search bar function. Therefore, users can find information about their favourite player or team in a short time rather than browsing through huge amounts of data. Besides, the designed website is expected to have a discussion page that allows users to post their comments and share their opinion when the team or player they are concerned with wins or loses a game. In addition, every user should have an account on this website that keeps their favourite team and player. Hence, the website has both the register and login functions that users can log in to their accounts with their unique usernames and passcodes. After logging in, users can set their favourite team and player on the profile page and check all the discussions posted by them. If users get interested in another team or player, they can also change their profile information or delete previous discussions posted by themselves.
For non-functional requirements,  the website can be accessed by wireless devices, such as computers and laptops. For security and safety, the website restricts access to profitable information and protects the private information of users. The website displays statistics clearly and in an organized structure, hence users can easily understand the context. Besides, the website uses visual designs to help users understand and control the system with a 3-second maximum response time. 
In this report, the team also displays the structure of the website through the use case diagram, the class diagram, the state chart diagram, the sequence diagram, and the activity diagram. Test cases are designed in the back end to testing the quality and stability of the website. In the end, the team summarizes the difficulties encountered and identifies the lessons learned during the process of achieving this design for further improvement.

# 2.0 Overview of Web App
As the top league of the largest sport [1] on the planet, the Premier League had a great impact around the globe with more than 1.4 billion fans [2]. Among fans of different teams, fierce debates concerning team superiority and game predictions have been raised. Millions of discussions are happening over the internet related to the Premier League; Until now, the Premier League has had 36,486,242 followers on Twitter [3], and those fans read, comment, and post about the Premier League. However, the posts on other websites, such as Twitter [3], might be inaccurate regarding the true performance of players, which can be demonstrated by statistics. The gap is a lack of reliable Online Community Site that supports Premier League discussions with official accurate information. 
Therefore, the team is motivated to establish an Online Community Site that is related to Premier League discussions with official accurate information. The goal of this project is to build an Online Community Site; with built-in functions for viewing team statistics, posting discussions, and linking statistics to comments. 
The stakeholders of this Community Site are other football-related websites, such as Twitter [3], Canadian Soccer news [4], etc., and the intended users. The key users of this Community Site are soccer fans who want to discuss soccer games, clubs, and players together using this soccer-related app/website, especially for Premier League. However, other websites mentioned above, only have one of the functions of checking official information or discussing, not both. The information gap between users may lead to unnecessary arguments, and the lack of discussion function makes it hard for users to enjoy the games with others. Based on this situation, the team created this site with both functions that will provide a friendly environment for fact-based discussion for the users. 


# 3.0 Overall architecture of the system 
The framework that is going to be used for the web application is Spring Boot. It is the starter of the java-based REST server, and the H2 database is going to be implemented together to help with managing the data storage of the application. JavaScript-based front-end user interfaces will be developed to present the content to the users. 
 The major CMS model entities are users, player statistics, team statistics, and forum posts; datasets store information about these entities. As for users, usernames, profile information, their favourite soccer teams, as well as their historical posts are stored in the database. Statistics entities include soccer teams, players, and match results; datasets containing their information are uploaded into the system. The dataset for the forum will record the content of the discussions, and the id of the user who posts the discussion. 
Correspondingly, webpages will be presented to users and enable user operations, and some involve control of the database and display of the information. As the basis of the web application, soccer teams, and players will be listed on a page where a search function will be implemented. Users will also be able to use the search function to filter out required outcomes. Besides, users can add soccer teams and/or players to their favourite list. 
 Users can post discussions on the forum page. Once a discussion is compiled and posted, a new entry will be created into the forum database. Meanwhile, the post will become visible to all other users on the page. Users can also post discussions as comments to other posts. 
Lastly, the user homepage shall display information for that user only. Aside from basic user profile information, soccer team, player and discussion entities are referenced to users as described in the database structure. Users will be able to view their favourite team and player and historical posts on the user page. This is also where users can operate with the list and posts, example functions are reading and deleting.
