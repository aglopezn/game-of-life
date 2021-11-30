# Game of Life

 It's a implementation of Conway's Game of Life based on a Spring Boot project.

 If you want to learn more about the game click [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

## Installation

You need to have the following items installed on your computer
* Package manager [maven](https://maven.apache.org/download.cgi).
* Java [JDK 1.8](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html).
* Version Control Manager [Git](https://git-scm.com/downloads).

1. First clone or download this repository
   ```bash
   git clone https://github.com/aglopezn/game-of-life.git
   ```
2. Then go to the root project folder on your terminal and install the dependencies
   ```bash
   mvn clean install
   ```

## Usage
1. Open the file initial.txt located in src/main/resources
2. The first line must contain the number of rows, cols and generationns to show,
   for example:
   ```
   3 3 5
   ```
3. The following lines must contain the initial state of the board. 
   A live cell is represented by an asterisk '*' and a dead cell by a dot '.', for example:
   ```
   ...
   ***
   ...
   ```
4. Then, on the root folder in your terminal execute
   ```bash
   mvn spring-boot:run
   ``` 
5. After that the game will show the generations on the terminal.
