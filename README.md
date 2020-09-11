# Simple Quiz App

A simple quiz game for desktop, developed in JavaFX11 platform with FXML.

## Design Pattern
I've tried to develop this application using the MVC design pattern, the basic idea of development was to divide 
the application into three main packages.

### Model
In this package I've tried to include the classes which do not interact directly with the user. This package focuses
on the data of the application.

***FileHandler.java*** : Used to interact with the files that store the data related to the quiz. Serializes and deserializes
the object of QuizQuestion to store them in a file called quizquestions.ser, also used to import the questions into the game.

***QuizQuestion.java*** : A class that stores a single question along with the correct answer and the remaining options.
The objects of this class are serialized by FileHandler to store the questions.

***QuizGame.java*** : This class stores the the whole quiz game, ie all the questions and their answers. 

### Controller
The Controller package contains classes that form a kind of an interface between View and Model.

***MainController.java*** : This the main class of the application. Implements the logic for the quiz and responsible for transition 
from one scene to another.

***AdminWindow.java*** : One of the feature of the app is to provide an interface for the users to add questions on. This class is the 
controller class for the window where users enter their questions. 

### View

***Menu.fxml and MenuController.java*** : The root layout containing a border pane with a menu bar at the top.

***FirstView.fxml and FirstViewController.java*** : The starting scene for the app, contains options to start the game and exit.
The result page also uses the same scene by modifying the label used for the title.

***QuizView.fxml and QuizViewController.java*** : The scene for the game. Question and the options displayed, radio buttons used to 
select the answer.

***InfoView.fxml and InfoViewController.java*** : A scene used to display information about the results obtained after the game.

***CheckPassword.fxml and CheckPasswordController.fxml*** : Scene used to ask the user for a password, does not allow all users to 
add questions.

***AddQuestions.fxml and AddQuestionsController.java*** : Scene for the users to input questions for the quiz, which will be stored 
in the file.

### Tools/Software Used
Java SE 8 or above should work (personally used Java SE 12).
JavaFX 8 or above (personally used JavaFX 11) and any IDE with JavaFX libraries.

***Note :*** I'm having trouble converting the jar file to an executable file, even the jar file didn't run on my mac.
I found a different solution to this, just run the jar file in the command line using the required modules. I have created 
a .sh file to run the application which will work on mac and linux. (Batch file could be used with the same command in windows)
Replace the path to lib folder of javafx and the path to the jar file with the path in your pc.
To run the application, use the command below in the terminal, or create a .sh or batch file for the same.

```
$ java --module-path /<path to javafx>/javafx-sdk-11.0.2/lib --add-modules=javafx.controls,javafx.fxml -jar /<path to project>/QuizApp/out/artifacts/QuizApp_jar/QuizApp.jar
```

