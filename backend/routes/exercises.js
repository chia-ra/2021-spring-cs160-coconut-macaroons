const router = require('express').Router();
let listing = require('../models/listing.model');

router.route('/').get((req, res) => {
  listing.find()
    .then(listings => res.json(listings))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/add').post((req, res) => {
  const category = req.body.category;
  const image = req.body.image;
  const description = req.body.description;
  const price = Number(req.body.price);
  const date = Date.parse(req.body.date);

  const newlisting = new listing({
    category,
    image,
    description,
    price,
    date,
  });

  newlisting.save()
  .then(() => res.json('listing added!'))
  .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').get((req, res) => {
  listing.findById(req.params.id)
    .then(listing => res.json(listing))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/:id').delete((req, res) => {
  listing.findByIdAndDelete(req.params.id)
    .then(() => res.json('listing deleted.'))
    .catch(err => res.status(400).json('Error: ' + err));
});

router.route('/update/:id').post((req, res) => {
  listing.findById(req.params.id)
    .then(listing => {
      listing.category = req.body.category;
      listing.image = req.body.image;
      listing.description = req.body.description;
      listing.price = Number(req.body.price);
      listing.date = Date.parse(req.body.date);
      listing.save()
        .then(() => res.json('listing updated!'))
        .catch(err => res.status(400).json('Error: ' + err));
    })
    .catch(err => res.status(400).json('Error: ' + err));
});
module.exports = router;
