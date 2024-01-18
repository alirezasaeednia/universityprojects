const express = require("express");
const mysql = require("mysql");
const cors = require('cors');
const app = express();
app.use(express.json());
app.use(cors());


const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "alireza",
  database: "alireza",
});

db.connect((err) => {
  if (err) {
    console.error("Error connecting to database:", err);
    return;
  }
  console.log("Connected to the database");
  // You can perform any database queries or operations here
  // Don't forget to close the connection when you're done
});

app.post("/api/moshaver", (req, res) => {
  const { phone, name, family, password, city } = req.body;
  const query =
    "INSERT INTO moshaver (phone, name, family,password,city) VALUES (?,?, ?,?,?)";
  db.query(query, [phone, name, family, password, city], (error, results) => {
    if (error) {
        console.error(error);
      res.status(500).json({ error: "Failed to insert moshaver" });
      console.log("failed");
    } else {
      res.status(200).json({ message: "Moshaver inserted successfully" });
      console.log("Moshaver inserted successfully");
    }
  });
});
app.get("/", (re, res) => {
    return res.json("from backend side");
  });
  
app.listen(8001, () => {
  console.log("listening");
});
