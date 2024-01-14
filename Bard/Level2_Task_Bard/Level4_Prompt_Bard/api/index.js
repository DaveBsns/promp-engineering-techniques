const express = require('express');
const Animal = require('../models/animals');
const app = express();
const pg = require('pg');

const connectionString = `postgres://postgres:mypassword@localhost:5432/zoo`;

// Create animal endpoint
app.post('/animals', async (req, res) => {
    const client = new pg.Client(connectionString);
    client.connect();
    const newAnimal = new Animal(req.body);
    const query = `INSERT INTO animals (name, species, habitat) values ('${newAnimal.name}', '${newAnimal.species}', '${newAnimal.habitat}')`;
    client.query(query);
    await newAnimal.save();
    res.status(201).send('Animal created successfully');
    client.end();
});

// Read all animals endpoint
app.get('/animals', async (req, res) => {
    const client = new pg.Client(connectionString);
    client.connect();
    const animals = await client.find();
    res.json(animals);
    client.end();
});

// Read animal by ID endpoint
app.get('/animals/:id', async (req, res) => {
    const client = new pg.Client(connectionString);
    client.connect();
    const { id } = req.params;
    const animal = await Animal.findOne({ _id: id });
    if (!animal) {
        res.status(404).send('Animal not found');
        return;
    }
    res.json(animal);
    client.end();
});

// Update animal endpoint
app.put('/animals/:id', async (req, res) => {
    // Update logic to save animal to PostgreSQL database
    const client = new pg.Client(connectionString);
    client.connect();
    const { id } = req.params;
    const updatedAnimal = new Animal(req.body);

    const query = `INSERT INTO animals (name, species, habitat) values ($1, $2, $3)`;
    client.query(query, [updatedAnimal.name, updatedAnimal.species, updatedAnimal.habitat]);
    
    updatedAnimal._id = id;
    await client.updateOne({ _id: id }, updatedAnimal);
    res.status(200).send('Animal updated successfully');
    client.end();
});

// Delete animal endpoint
app.delete('/animals/:id', async (req, res) => {
    const client = new pg.Client(connectionString);
    client.connect();
    const { id } = req.params;
    await client.deleteOne({ _id: id });
    res.status(200).send('Animal deleted successfully');
    client.end();
});

// Start the server
app.listen(3000, () => {
  console.log('API server started on port 3000');
});
