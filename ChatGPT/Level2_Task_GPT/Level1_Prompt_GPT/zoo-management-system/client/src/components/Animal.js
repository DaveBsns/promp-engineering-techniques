import React from 'react';

const Animal = ({ animal, onDelete }) => {
  return (
    <div>
      <p>{`Name: ${animal.name}, Species: ${animal.species}, Age: ${animal.age}`}</p>
      <button onClick={() => onDelete(animal._id)}>Delete</button>
    </div>
  );
};

export default Animal;
