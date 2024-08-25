const express = require('express');
const router = express.Router();
const Contact = require('../models/contact');
const multer = require('multer');
const csv = require('csv-parser');
const fs = require('fs');
const fastcsv = require('fast-csv');

const upload = multer({ dest: 'uploads/' });

router.get('/', async (req, res) => {
  try {
    const contacts = await Contact.find();
    res.json(contacts);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

router.get('/search', async (req, res) => {
  try {
    const { name, phone, email, group } = req.query;
    const query = {};

    if (name) {
      query.name = new RegExp(name, 'i');
    }
    if (phone) {
      query.phone = new RegExp(phone, 'i');
    }
    if (email) {
      query.email = new RegExp(email, 'i');
    }
    if (group) {
      query.group = new RegExp(group, 'i');
    }

    const contacts = await Contact.find(query);

    if (contacts.length === 0) {
      return res.status(404).json({ message: 'Contact not found' });
    }

    res.json(contacts);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// Add a new contact
router.post('/', async (req, res) => {
  const contact = new Contact({
    name: req.body.name,
    phone: req.body.phone,
    email: req.body.email,
    group: req.body.group
  });

  try {
    const newContact = await contact.save();
    res.status(201).json(newContact);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

router.put('/:id', async (req, res) => {
  try {
    console.log(`Attempting to update contact with ID: ${req.params.id}`);
    const contact = await Contact.findById(req.params.id);
    if (!contact) {
      console.log('Contact not found');
      return res.status(404).json({ message: 'Contact not found' });
    }
    contact.name = req.body.name || contact.name;
    contact.phone = req.body.phone || contact.phone;
    contact.email = req.body.email || contact.email;
    contact.group = req.body.group || contact.group;
    const updatedContact = await contact.save();
    console.log('Contact updated successfully');
    res.json(updatedContact);
  } catch (err) {
    console.error('Error updating contact:', err);
    res.status(500).json({ message: err.message });
  }
});

router.delete('/:id', async (req, res) => {
  try {
    console.log(`Attempting to delete contact with ID: ${req.params.id}`);
    const contact = await Contact.findById(req.params.id);
    if (!contact) {
      console.log('Contact not found');
      return res.status(404).json({ message: 'Contact not found' });
    }
    await contact.deleteOne(); 
    console.log('Contact deleted successfully');
    res.json({ message: 'Contact deleted' });
  } catch (err) {
    console.error('Error deleting contact:', err);
    res.status(500).json({ message: err.message });
  }
});


router.post('/import', upload.single('file'), (req, res) => {
  const filePath = req.file.path;
  const contacts = [];

  fs.createReadStream(filePath)
    .pipe(csv())
    .on('data', (row) => {
      contacts.push(row);
    })
    .on('end', async () => {
      try {
        await Contact.insertMany(contacts);
        fs.unlinkSync(filePath); 
        res.status(200).json({ message: 'Contacts imported successfully' });
      } catch (error) {
        console.error('Error importing contacts:', error);
        res.status(500).json({ message: 'Error importing contacts' });
      }
    });
});


router.get('/export', async (req, res) => {
  try {
    const contacts = await Contact.find().lean().select('-__v'); 
    const ws = fs.createWriteStream('contacts.csv');

    fastcsv
      .write(contacts, { headers: true })
      .pipe(ws)
      .on('finish', () => {
        res.download('contacts.csv', 'contacts.csv', (err) => {
          if (err) {
            console.error('Error downloading CSV:', err);
            res.status(500).json({ message: 'Error downloading CSV' });
          } else {
            fs.unlinkSync('contacts.csv'); 
          }
        });
      });
  } catch (error) {
    console.error('Error exporting contacts:', error);
    res.status(500).json({ message: 'Error exporting contacts' });
  }
});

module.exports = router;
