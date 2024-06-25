<a name="readme-top"></a>
<h1>Stakkowerflov</h1>
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#contributors">Contributors</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
<h3>Welcome to Stakkowerflov, a Q&A platform inspired by Stack Overflow but dedicated to all things related to furniture service. The name Stakkowerflov was chosen to give the project a unique Scandinavian flair, reminiscent of furniture names, to align with our focus on furniture service discussions. This was our first project at Codecool with Spring Boot, and we built most of it in a 5 day sprint, so its still under development. Enjoy!</h3>
<h3>As part of the Stakkowerflov team, we worked collaboratively on different layers of the application. My specific contributions included developing the question and answer layers from the frontend to the database. I was responsible for ensuring that questions and answers were correctly handled and displayed in the user interface, efficiently processed in the backend, and accurately stored and retrieved from the database. Additionally, I implemented sorting and filtering features to enhance user experience, allowing users to easily find relevant questions and answers. Later on, I also took on the task of refactoring the code to improve its efficiency, readability, and maintainability.</h3>
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Contributors
- [Blanka Pasztor](https://github.com/blankapsz)
- [Brigi Jasz](https://github.com/igirb)
- [Levente Hrabetz](https://github.com/grindlevi)
<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Built With
* [![React][React.js]][React-url]
* [![Node][NodeJs]][NodeJs-url]
* [![Postgres][PostgreSQL]][Postgres-url]
* [![SpringBoot][Spring]][SpringBoot-url]
* [![Java][Java]][Java-url]
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started
### Prerequisites:

<p>Install the latest NPM</p>
<p>Java Development Kit(JDK21) installed</p>
<p>PostgreSQL database set up</p>

<p>Frontend Setup: </p>
<ul>
  <li>cd frontend</li>
  <li>npm install</li>
</ul>

### Installation
1. Clone the repo
   ```sh
   git clone https://github.com/blankapsz/stackoverflow
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
3. Backend Setup:
Configure the application.properties file with your PostgreSQL database credentials.
![image](https://github.com/blankapsz/stackoverflow/assets/134206215/0ac224a5-e940-4379-b318-8170f0034a71)

5. Create the PSQL table by running the query from table_creation.sql

6. Run backend

7. Navigate to the stackoverflow_frontend folder and run this command:
   ```sh
   npm run dev
   ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage
Stakkowerflov is designed to help users find and share information about furniture service. Here's an example of how you might use the platform:
1. **Asking a Question**:
   - Navigate to the homepage and fill out the form with your question title, description.
   - Click on the "Send Question" button.
   - Submit your question to make it visible to other users.

2. **Answering a Question**:
   - Browse through the list of questions on the homepage or use the search functionality to find questions you're knowledgeable about.
   - Click on a question to view its details.
   - Provide a helpful and detailed answer in the answer box and submit it.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact
Levente Hrabetz - grindlevi@gmail.com
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[PostgreSQL]:https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[Postgres-url]:https://www.postgresql.org/
[Spring]:https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[SpringBoot-url]:https://spring.io/projects/spring-boot
[NodeJs]:https://img.shields.io/badge/Node.js-43853D?style=for-the-badge&logo=node.js&logoColor=white
[NodeJs-url]:https://nodejs.org/en
[Java]:https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]:https://www.java.com/en/
