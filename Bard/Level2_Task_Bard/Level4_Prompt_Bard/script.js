const animalsTable = document.getElementById('animals-table');


// Add animal function
const addAnimalButton = document.getElementById('add-animal-button');

addAnimalButton.addEventListener('click', () => {
  // Fetch animal data from the form
  const name = document.getElementById('animal-name').value;
  const species = document.getElementById('animal-species').value;
  const habitat = document.getElementById('animal-habitat').value;

  // Create animal object
  const animal = {
    name,
    species,
    habitat,
  };


  // Send animal data to API endpoint
  fetch('/api/animals', {
    method: 'POST',
    body: JSON.stringify(animal),
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then(response => response.json())
    .then(data => {
      console.log('Animal added successfully:', data);

      // Refresh the table with updated data
      fetch('/api/animals')
        .then(response => response.json())
        .then(animals => {
          animalsTable.innerHTML = '';

          for (const animal of animals) {
            const tr = document.createElement('tr');

            const nameTd = document.createElement('td');
            nameTd.textContent = animal.name;
            tr.appendChild(nameTd);

            const speciesTd = document.createElement('td');
            speciesTd.textContent = animal.species;
            tr.appendChild(speciesTd);

            const habitatTd = document.createElement('td');
            habitatTd.textContent = animal.habitat;
            tr.appendChild(habitatTd);

            animalsTable.appendChild(tr);
          }
        });
    });
});


// Delete animal function
const deleteAnimalButton = document.getElementById('delete-animal-button');

deleteAnimalButton.addEventListener('click', () => {
  const animalId = parseInt(document.getElementById('animal-id').value);

  if (window.confirm('Are you sure you want to delete the animal with ID ' + animalId + '?')) {
    deleteAnimalButton.click();
  }
});


// Update Animal Button
const updateAnimalButton = document.getElementById('update-animal-button');

updateAnimalButton.addEventListener('click', () => {
  // Fetch animal ID, name, species, and habitat from the table
  const animalId = parseInt(document.getElementById('animal-id').value);
  const name = document.getElementById('animal-name').value;
  const species = document.getElementById('animal-species').value;
  const habitat = document.getElementById('animal-habitat').value;

  // Create updated animal object
  const updatedAnimal = {
    id: animalId,
    name,
    species,
    habitat,
  };

  // Send updated animal data to API endpoint
  fetch(`/api/animals/${animalId}`, {
    method: 'PUT',
    body: JSON.stringify(updatedAnimal),
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then(response => response.json())
    .then(data => {
      console.log('Animal updated successfully:', data);

      // Refresh the table with updated data
      fetch('/api/animals')
        .then(response => response.json())
        .then(animals => {
          animalsTable.innerHTML = '';

          for (const animal of animals) {
            const tr = document.createElement('tr');

            const nameTd = document.createElement('td');
            nameTd.textContent = animal.name;
            tr.appendChild(nameTd);

            const speciesTd = document.createElement('td');
            speciesTd.textContent = animal.species;
            tr.appendChild(speciesTd);

            const habitatTd = document.createElement('td');
            habitatTd.textContent = animal.habitat;
            tr.appendChild(habitatTd);

            animalsTable.appendChild(tr);
          }
        });
    });
});

const addAnimalForm = document.querySelector('#add-animal-form');

if (addAnimalForm) {
  addAnimalForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const name = document.getElementById('animal-name').value;
    const species = document.getElementById('animal-species').value;

    if (!name) {
      alert('Please enter a name for the animal.');
      return;
    }

    if (!species) {
      alert('Please enter the animal species.');
      return;
    }

    // Add animal to the table
    addAnimalButton.click();
  });
} else {
  console.error('Error: Could not find element with ID "add-animal-form"');
}


// Fill the table with data
const animals = [
  { name: 'Lion', species: 'Felidae', habitat: 'Africa' },
  { name: 'Tiger', species: 'Felidae', habitat: 'Asia' },
  { name: 'Elephant', species: 'Elephantidae', habitat: 'Africa, Asia' },
];

animalsTable.innerHTML = '';

for (const animal of animals) {
  const tr = document.createElement('tr');

  const nameTd = document.createElement('td');
  nameTd.textContent = animal.name;
  tr.appendChild(nameTd);

  const speciesTd = document.createElement('td');
  speciesTd.textContent = animal.species;
  tr.appendChild(speciesTd);

  const habitatTd = document.createElement('td');
  habitatTd.textContent = animal.habitat;
  tr.appendChild(habitatTd);

  animalsTable.appendChild(tr);
}

// Fetch animal data
fetch('/api/animals')
  .then(response => response.json())
  .then(animals => {
    animalsTable.innerHTML = '';

    for (const animal of animals) {
      const tr = document.createElement('tr');

      const nameTd = document.createElement('td');
      nameTd.textContent = animal.name;
      tr.appendChild(nameTd);

      const speciesTd = document.createElement('td');
      speciesTd.textContent = animal.species;
      tr.appendChild(speciesTd);

      const habitatTd = document.createElement('td');
      habitatTd.textContent = animal.habitat;
      tr.appendChild(habitatTd);

      animalsTable.appendChild(tr);
    }
  });

