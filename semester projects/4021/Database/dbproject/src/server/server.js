const express = require("express");
const mysql = require('mysql');
const cors = require('cors');

const app = express()
app.use(cors())
app.get('/', (re, res) => {
    return res.json("from backend side");
})

const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "alireza",
    database:"alireza"
});

app.get('/users', (req, res) => {
    const sql = "Select  * from alireza ";
    db.query(sql, (err, data) => {
        if (err) return res.json(err);
        return res.json(data);
    })
})
app.listen(8001, () => {
    console.log("listening")
})