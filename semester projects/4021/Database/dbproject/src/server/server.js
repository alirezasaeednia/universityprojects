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

app.post("/api/moshavertel", (req,res) => {
  const { yourajans } = req.body;
  const query =
    "UPDATE ajans INNER JOIN (SELECT (SELECT phone FROM moshaver LIMIT 1) AS moshavertel, (SELECT phone FROM ajans LIMIT 1) AS ajansphone) AS subquery SET ajans.moshavertel = subquery.moshavertel WHERE ajans.phone = subquery.ajansphone;";
  db.query(query, [yourajans], (error, results) => {
    if (error) {
        console.error(error);
      console.log("failed");
    } else {
      console.log("Moshavertel inserted successfully");
    }
  });
});




app.post("/api/ajans", (req, res) => {
    const {city,phone,name,moshavertel,modirtel,selectedButton1,modirname,modirfamily } = req.body;
    const query =
        "INSERT INTO ajans (city,phone,name,moshavertel,modirtel,karmandnumber,modirname,modirfamily) VALUES (?,?,?,?,?,?,?,?)";
    db.query(query, [city, phone, name, moshavertel, modirtel, selectedButton1, modirname, modirfamily], (error, results) => {
        if (error) {
            console.error(error);
            res.status(500).json({ error: "Failed to insert moshaver" });
            console.log("failed");
        } else {
            res.status(200).json({ message: "ajans inserted successfully" });
            const insertedData = { city, phone, name, moshavertel, modirtel, selectedButton1, modirname, modirfamily };

            console.log(insertedData);
        }
    });
});


  
app.get("/", (re, res) => {
    return res.json("from backend side");
  });
  
app.listen(8001, () => {
  console.log("listening");
});
