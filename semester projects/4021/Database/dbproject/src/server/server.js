
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



app.post("/api/emkanat", (req, res) => {
  const { parking, lobby, anbari, asansor, estakhr, sona, varzesh, negahban, balcony, tahviye, salon, jakuzi, anten, darb, roof,id } = req.body;


  const query =
    "INSERT INTO emkanat  (parking, lobby, anbari, asansor, estakhr, sona, varzesh, negahban, balcony, tahviye, salon, jakuzi, anten, darb, roof,id)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
  db.query(query, [parking, lobby, anbari, asansor, estakhr, sona, varzesh, negahban, balcony, tahviye, salon, jakuzi, anten, darb, roof, id], (error, results) => {
    if (error) {
      console.error(error);
      res.status(500).json({ error: "Failed to insert moshaver" });
      console.log("failed");
    } else {
      res.status(200).json({ message: "emkanat inserted successfully" });
      console.log("salammm");
    }
  });
});

app.post("/api/sharayet", (req, res) => {
  const { id2, mosharekati, moavez, ghabeltabdil, pishfurush, edari, vam, nosaz, ghadr, pasaj, mall  } = req.body;
  const query1 = "INSERT INTO sharayet (id, mosharekati, moavez, ghabeltabdil, pishfurush, edari, vam, nosaz, ghadr, pasaj, mall) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
  const query2 = "SET SQL_SAFE_UPDATES = 0";
  const query3 = "UPDATE agahi SET ajansid = (SELECT phone FROM ajans WHERE phone = LAST_INSERT_ID(phone) LIMIT 1)";
  const query4 = "UPDATE agahi SET emkanatid = (SELECT id FROM emkanat order by id desc limit 1);";
  const query5 = "UPDATE agahi SET sharayetid = (select id from sharayet order by id desc limit 1);";
  
  db.query(query1, [id2, mosharekati, moavez, ghabeltabdil, pishfurush, edari, vam, nosaz, ghadr, pasaj, mall], (error, results) => {
    if (error) {
      console.error(error);
      res.status(500).json({ error: "Failed to insert moshaver" });
      console.log("failed");
    } else {
      db.query(query2, (error, results) => {
        if (error) {
          console.error(error);
          res.status(500).json({ error: "Failed to set SQL_SAFE_UPDATES" });
        } else {
          db.query(query3, (error, results) => {
          });
          db.query(query4, (error, results) => {
          });
          db.query(query5, (error, results) => {
          });
          res.status(200).json({ message: "Moshaver inserted successfully" });
          console.log("agahi inserted successfully");
        }
      });
    }
  });


});

app.post("/api/agahi", (req, res) => {
  const {code, descp, title, bedno, nokarbari, metraj, gheymatejare, gheymatrahn, norahn, mahale, city  } = req.body;


  const query =
    "INSERT INTO agahi  (code, descp, title, bedno, nokarbari, metraj, gheymatejare, gheymatrahn, norahn, mahale, city)  VALUES (?,?,?,?,?,?,?,?,?,?,?)";
  db.query(query, [code, descp, title, bedno, nokarbari, metraj, gheymatejare, gheymatrahn, norahn, mahale, city  ], (error, results) => {
    if (error) {
      console.error(error);
      res.status(500).json({ error: "Failed to insert moshaver" });
      console.log("failed");
    } else {
      res.status(200).json({ message: "Moshaver inserted successfully" });
      console.log("agahi inserted successfully");
      
   
    }
  });
});

app.get("/api/data", (req, res) => {
  const query = "SELECT * FROM agahi";
  db.query(query, (error, results) => {
    if (error) {
      console.error(error);
      console.log('nashod');
      res.status(500).json({ error: "Failed to fetch data from agahi" });
    } else {
      res.status(200).json(results);
    }
  });
});

app.get("/api/dataprofile", (req, res) => {
  const query = "SELECT * FROM ajans";
  db.query(query, (error, results) => {
    if (error) {
      console.error(error);
      console.log('nashod');
      res.status(500).json({ error: "Failed to fetch data from agahi" });
    } else {
      res.status(200).json(results);
    }
  });
});








  
app.get("/", (re, res) => {
    return res.json("from backend side");
  });
  
app.listen(8001, () => {
  console.log("listening");
});
