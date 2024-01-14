const express = require('express');
const app = express();
const animalsRouter = require('./routes/animals');

app.use(express.json());
app.use('/animals', animalsRouter);

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is running on http://localhost:${PORT}`);
});
