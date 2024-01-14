## Documentation Fullstack Web Application - Level 1 Prompt - Bard

**Frontend:**

- Create a React application using a framework like Create React App.
- Design and implement a user interface (UI) for managing animals, including:
    - A list of animals with basic information like name, species, and enclosure.
    - Options to create, read, update, and delete animals.
- Use React Router to handle navigation between different pages (e.g., animal list, animal details, animal creation).

**API:**

- Develop an Express.js API to handle CRUD operations for animals.
- Create endpoints for:
    - `GET /animals`: Retrieve the list of all animals.
    - `POST /animals`: Create a new animal.
    - `GET /animals/:id`: Retrieve details of a specific animal by ID.
    - `PUT /animals/:id`: Update the information of an existing animal.
    - `DELETE /animals/:id`: Delete an animal by ID.
- Use JSON Web Tokens (JWTs) for authentication and authorization.

**Database:**

- Set up a PostgreSQL database to store animal information.
- Create a table called `animals` with columns for:
    - `id`: Unique identifier for each animal.
    - `name`: The name of the animal.
    - `species`: The species of the animal.
    - `enclosure`: The enclosure where the animal is housed.

**Integration:**

- Connect the React frontend to the Express.js API using Axios or a similar HTTP client library.
- Implement the CRUD operations in the frontend by making API calls to the corresponding endpoints.
- Handle authentication and authorization by sending the JWT token in the header of API requests.

**Testing:**

- Write unit tests for the API endpoints to ensure they function correctly.
- Write end-to-end tests to verify the overall functionality of the application.