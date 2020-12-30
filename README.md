Java learning and projects

## GRADLE 

### gradle-wrapper.jar 
gradle-wrapper.jar is placed in .gitignore - so it wont go to git as a useless piece
You wont get it it when you clone/download this repo
To re-create it - just run "gradle wrapper" from project root

### Build a project
From project root run:  
$ gradle build  

Classes are created in build/classes  
Jar is created in build/libs  

### Run a project
$ gradle run  

However, this gave error: "Task 'run' not found in root project "

### Clean the build folder
$ gradle clean

### Generate javadoc
$ gradle javadoc  

Docs will be in build/docs  
 


