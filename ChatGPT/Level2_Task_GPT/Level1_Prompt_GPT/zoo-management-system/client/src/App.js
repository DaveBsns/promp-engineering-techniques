import React, { useState, useEffect } from 'react';
import Animal from './components/Animal';

function App() {
  const [animals, setAnimals] = useState([]);
  const [newAnimal, setNewAnimal] = useState({ name: '', species: '', age: '' });

  useEffect(() => {
    fetch('/api/animals')
      .then((res) => res.json())
      .then((data) => setAnimals(data));
  }, []);

  const handleAddAnimal = () => {
    fetch('/api/animals', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newAnimal),
    })
      .then((res) => res.json())
      .then((data) => setAnimals([...animals, data]));
  };

  const handleDeleteAnimal = (id) => {
    fetch(`/api/animals/${id}`, {
      method: 'DELETE',
    })
      .then(() => setAnimals(animals.filter((animal) => animal._id !== id)));
  };

  return (
    <div>
      <h1>Zoo Management System</h1>
      <div>
        <h2>Animals</h2>
        {animals.map((animal) => (
          <Animal key={animal._id} animal={animal} onDelete={handleDeleteAnimal} />
        ))}
      </div>
      <div>
        <h2>Add Animal</h2>
        <input
          type="text"
          placeholder="Name"
          value={newAnimal.name}
          onChange={(e) => setNewAnimal({ ...newAnimal, name: e.target.value })}
        />
        <input
          type="text"
          placeholder="Species"
          value={newAnimal.species}
          onChange={(e) => setNewAnimal({ ...newAnimal, species: e.target.value })}
        />
        <input
          type="text"
          placeholder="Age"
          value={newAnimal.age}
          onChange={(e) => setNewAnimal({ ...newAnimal, age: e.target.value })}
        />
        <button onClick={handleAddAnimal}>Add Animal</button>
      </div>
    </div>
  );
}

export default App;

