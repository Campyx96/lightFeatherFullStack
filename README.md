# lightFeatherFullStack
Full Stack Coding Challenge for lightFeather io LLC

This project is a simple form application build using Java and Springboot.
- The form takes as input, the users first and last name, email and/or phone number, and their supervisor (chosen from a list). 
- The application then sends the information to the provided API endpoint and displays a summary of the data that was sent if it was sent successfully.
- Note: First Name, Last Name, and Supervisor are required fields. If they are not filled then the app will not send the information and will instead reload the form.

# Run Instructions 
Open CMD and navigate to the project folder
- Run `mvn clean package`
This step builds the jar that will be needed to run it either in docker or directly out of the command line.

  Run in Docker:
  
- Run `docker build -t lightfeather-fullstack-docker .` (Build the image)
- Run `docker run -p 8080:8080 lightfeather-fullstack-docker` (Run the image)
- The app should be running in your browser at http://localhost:8080/
  
  Run in Command Line
  
- Run `java -jar target/lightFeatherFullStack-0.0.1-SNAPSHOT.jar` (Run the Jar File)
