const { DataTypes } = require('sequelize');

module.exports = (sequelize) => {
  return sequelize.define('Animal', {
    name: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    species: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    age: {
      type: DataTypes.INTEGER,
    },
  });
};
