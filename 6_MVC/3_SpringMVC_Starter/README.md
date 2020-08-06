## SpringMVC Starter
<p> A Spring starter project with XML based configuration to get you upp and running for a small to medium scale spring application with a database and spring security for those who do not want to use Spring-Boot</p>


## Dependencies included (Some in comments) 
- Spring Framework (4.3.10.RELEASE)
- Hibernate
- Spring security
- taglibs
- log4j
- slf4j
- fasterxml jackson
- Mail sender
- GZip for web compression
<p> Dependencies can be changed as you like update to current version if you like</p>

## How to setup on Intellij Idea
- Clone the repo: `git clone https://github.com/Recks11/SpringMVC-Starter.git` or download it
- Import on Intellij Idea from external sources as a maven project and enable auto import when asked. if you are not asked go to `Preferences > Build, execution, deployment > Build Tools > Maven > Importing ` and tick `Import maven projects automatically`
- In the `POM.xml` file change the spring version to the version you want to use this repo uses the 4.3.10.RELEASE
- !IMPORTANT Create the web facet, In Intellij IDEA go to `File > Project Structure > Facets` and add a web facet
- In the web facet change the `web resource directory` to the location of the `web.xml` file which is
`src/main/webapp`  and the `web module deployment descriptor` to the `web.xml` file itself in `src/main/webapp/WEB-INF/web.xml`
- you will also see an error saying there is no artifact here click create artifact
- In `File > Project Structure > artifacts` select all available artifacts and add to lib or just double click them one at a time
- Create a new run configuration from `run > Edit configurations` click the `+` and select `Tomcat > local` if you have tomcat installed select tomcat home (where its installed or extracted to) in the before lunch section you'll see an error click fix to select the artifact to use for deployment
- Press apply then press OK and now run the application. you should immediately land in the 'IT WORKS page'.
- Happy development

## How to setup on eclipse
<p>Coming soon...</P>

## How to setup Hibernate
- Uncomment the hibernate dependencies in the `Pom.xml` file
- Uncomment the Database configuration section in the `applicationContext.xml` file
- Go to the `hibernate.properties` file
- Enter the database url in `jdbc.url` an example is `jdbc:mysql://localhost:3306/DatabaseName?useSSL=false`
- Enter the database username in `jdbc.username`
- Enter the database password in `jdbc.username`
- Thats all! You can now use hibernate for the selected database
<p>I prefer using a hibernate.properties file instead of directly editing the appliocationContext file because the database can be changed at any point in time by just changing or editing only that file</p>

## HOW TO SETUP SPRING SECURITY
<p>Coming soon...</P>

## Project Structure
<p>This is the overall project structure. the full project naming scheme can be refactored to suit your needs</p>

```
SpringMVC Starter/
├── src/
│   ├── main/
│   │   └── com/
│   │       └── name/
│   │           ├── controllers/
│   │           │   └── indexController.java
│   │           └── data/
│   │                 ├── model/
│   │                 │   └── user.java
│   │                 ├── repository
│   │                 └── services
│   │
│   ├── resources/
│   │   ├── hibernate.properties
│   │   ├── jdbc.properties
│   │   └── log4j.properties
│   │
│   ├── webapp/
│   │   ├── resources/
│   │   │   ├── css/
│   │   │   ├── js/
│   │   │   └── media/
│   │   │
│   │   └── WEB-INF/
│   │       ├── spring/
│   │       │   ├── applicationContext.xml
│   │       │   └── dispatcher-servlet.xml
│   │       ├── views/
│   │       │   └── index.jsp
│   │       └── web.xml
│   │
│   └── test/
│       └── java/
│   
└── pom.xml
```
