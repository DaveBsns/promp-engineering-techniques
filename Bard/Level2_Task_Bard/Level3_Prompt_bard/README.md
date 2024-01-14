## Documentation Fullstack Web Application - Level 3 Prompt - Bard

**Full-Stack Web Application for Zoo Management System**

This document outlines the development of a full-stack web application for a zoo management system, encompassing the frontend and backend components, database configuration, and testing procedures.

**Application Overview**

The zoo management system provides a comprehensive platform for managing animal records, including creation, retrieval, update, and deletion. It utilizes a RESTful API architecture to facilitate communication between the frontend and backend components. Data is securely stored in a PostgreSQL database containerized using Docker.

**Frontend Development**

The frontend utilizes HTML, CSS, and JavaScript to create interactive user interfaces. HTML provides the basic structure of the application, CSS controls the visual presentation, and JavaScript handles dynamic interactions.

**Backend Development**

The backend utilizes Node.js and Express.js to develop the RESTful API endpoints. Express.js simplifies the creation of web applications with powerful routing and middleware capabilities. Node.js provides a robust JavaScript runtime environment.

**Database Configuration**

PostgreSQL is selected as the database for storing animal records. A Docker container is used to encapsulate the PostgreSQL database, ensuring portability and isolation. The Docker container is configured with the necessary database schema and data to support the zoo management system.

**Testing CRUD Operations**

Thorough testing is essential to ensure the proper functionality of CRUD operations. Automated testing frameworks can be employed to test the creation, retrieval, update, and deletion of animal records.

**Application Setup and Running**

**Installing Dependencies**

1. Install Node.js and npm (Node Package Manager) if they are not already installed.
2. Install Docker Desktop to run the PostgreSQL database container.

**Configuring the PostgreSQL Database Container**

1. Pull the PostgreSQL Docker image from the Docker Hub:

**Bash**

```
docker pull postgres

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Create a Docker network for communication between the frontend and backend containers:

**Bash**

```
docker network create zoo-network

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Run the PostgreSQL Docker container:

**Bash**

```
docker run -d -p 5432:5432 --network zoo-network --name zoo-db postgres

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Create a database and table for the zoo management system:

**Bash**

```
docker exec -it zoo-db psql -U postgres
CREATE DATABASE zoo_management;
CREATE TABLE animals (
  id SERIAL PRIMARY KEY,
  animal_name VARCHAR(255) NOT NULL,
  species VARCHAR(255) NOT NULL,
  enclosure VARCHAR(255) NOT NULL
);

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

**Running the Frontend Application**

1. Clone the frontend repository:

**Bash**

```
git clone https://github.com/[YOUR-USERNAME]/zoo-management-frontend.git

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Navigate to the frontend directory and install the dependencies:

**Bash**

```
cd zoo-management-frontend
npm install

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Start the frontend application:

**Bash**

```
npm start

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

The frontend application will be accessible at http://localhost:3000.

**Running the Backend Application**

1. Clone the backend repository:

**Bash**

```
git clone https://github.com/[YOUR-USERNAME]/zoo-management-backend.git

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Navigate to the backend directory and install the dependencies:

**Bash**

```
cd zoo-management-backend
npm install

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

1. Configure the backend application to connect to the PostgreSQL database:

**Bash**

```
nano .env

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

Replace `DATABASE_URL` with the connection string to the PostgreSQL database, which can be obtained from the Docker container logs:

`docker logs zoo-db`

1. Start the backend application:

**Bash**

```
npm start

```

**Verwende Code mit Vorsicht. [Weitere Informationen](https://bard.google.com/faq#coding)content_copy**

The backend application will be accessible at http://localhost:3001.

**User Guide**

The zoo management system allows users to manage animal records.

- **Create Animal:** Click the "Create Animal" button and enter the animal's name, species, and enclosure.
- **Retrieve Animals:** Click the "Retrieve Animals" button to view all animal records.
- **Update Animal:** Click the "Update Animal" button and select the animal to update. Update the animal's name, species, or enclosure and click "Update".
- **Delete Animal:** Click the "Delete Animal" button and select the animal to delete. Click "Delete" to remove the animal from the database.

**Conclusion**

The zoo management system provides a convenient and efficient platform for managing animal records.