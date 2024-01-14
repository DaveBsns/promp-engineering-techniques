const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = process.env.PORT || 5000;

app.use(bodyParser.json());
app.use(cors());

// Connect to MongoDB
mongoose.connect('mongodb://localhost:27017/zoo', { useNewUrlParser: true, useUnifiedTopology: true });

// Define mongoose schema and model (e.g., Animal)
const animalSchema = new mongoose.Schema({
  name: String,
  species: String,
  age: Number,
});

const Animal = mongoose.model('Animal', animalSchema);

// CRUD operations
app.get('/api/animals', async (req, res) => {
  const animals = await Animal.find();
  res.json(animals);
});

app.post('/api/animals', async (req, res) => {
  const newAnimal = new Animal(req.body);
  await newAnimal.save();
  res.json(newAnimal);
});

app.put('/api/animals/:id', async (req, res) => {
  const updatedAnimal = await Animal.findByIdAndUpdate(req.params.id, req.body, { new: true });
  res.json(updatedAnimal);
});

app.delete('/api/animals/:id', async (req, res) => {
  await Animal.findByIdAndDelete(req.params.id);
  res.json({ message: 'Animal deleted' });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
