## Documentation Fullstack Web Application - Level 4 Prompt - Bard

To run the zoo management system, follow these steps:

**1. Install Dependencies:**

- Frontend: Install HTML, CSS, and JavaScript as mentioned before.
- Backend: Install Node.js, Express.js, mongoose, MongoDB, and Docker.

**2. Start MongoDB Server:**

- Open a terminal window and navigate to the MongoDB installation directory.
- Run the command `mongod` to start the MongoDB server.

**3. Create PostgreSQL Container (Optional):**

- If you are using PostgreSQL instead of MongoDB, follow the steps in the previous section to pull the PostgreSQL image, create a container, and establish a connection to the database.

**4. Start the Backend:**

- Navigate to the backend directory.
- Run the command `npm start` to start the Node.js server on port 3000.

**5. Run the Frontend:**

- Navigate to the frontend directory.
- Run the command `npm start` to start the web server on port 3001.

**6. Access the Zoo Management System:**

- Open a web browser and navigate to `http://localhost:3001`.

**User Guide for Zoo Management System**

**1. Adding Animals:**

- Click the "Add Animal" button.
- Enter the animal's name, species, and habitat in the corresponding fields.
- Click the "Add Animal" button to save the animal.

**2. Viewing Animals:**

- The table below the "Add Animal" button will display a list of all animals in the zoo.
- You can click on a row in the table to view more details about the animal, such as its name, species, and habitat.

**3. Updating Animals:**

- Click on a row in the table to view the details of the animal.
- Click the "Update Animal" button.
- Make any necessary changes to the animal's information in the corresponding fields.
- Click the "Update Animal" button to save the changes.

**4. Deleting Animals:**

- Click on a row in the table to view the details of the animal.
- Click the "Delete Animal" button. A confirmation dialog will appear.
- Click the "Yes" button to delete the animal.