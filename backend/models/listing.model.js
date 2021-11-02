const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const listingSchema = new Schema({
  category: { type: String, required: true },
  image: { type: String, required: false },
  description: { type: String, required: true },
  price: { type: Number, required: true },
  date: { type: Date, required: true },
}, {
  timestamps: true,
});

const listing = mongoose.model('listing', listingSchema);
module.exports = listing;
