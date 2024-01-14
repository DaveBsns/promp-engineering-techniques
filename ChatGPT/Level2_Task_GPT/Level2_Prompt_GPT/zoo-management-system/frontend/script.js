document.addEventListener('DOMContentLoaded', () => {
    const animalForm = document.getElementById('add-animal-form');
    const animalsList = document.getElementById('animals');

    animalForm.addEventListener('submit', (event) => {
        event.preventDefault();

        const name = document.getElementById('name').value;
        const species = document.getElementById('species').value;
        const age = document.getElementById('age').value;

        // Validate input (you can add more validation)

        addAnimal(name, species, age);
        animalForm.reset();
    });

    function addAnimal(name, species, age) {
        const animalItem = document.createElement('li');
        animalItem.innerHTML = `<strong>${name}</strong> - ${species}, Age: ${age}`;
        animalsList.appendChild(animalItem);
    }

    // You can add code to fetch existing animals from the backend and display them on page load.
    // Use Fetch API to interact with your backend.
});
