const mongoose = require('mongoose');

const animalSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
  },
  species: {
    type: String,
    required: true,
  },
  habitat: {
    type: String,
    required: true,
  },
});

module.exports = mongoose.model('Animal', animalSchema);
