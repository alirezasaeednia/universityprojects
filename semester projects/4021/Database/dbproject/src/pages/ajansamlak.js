import React, { Component } from "react";
import NavigationBar from '../Components/NavigationBar';
import Back from "../Components/goback";
import Blockk from "../Components/Block";
import styled from 'styled-components';
import Profile from "./profile";
import { useEffect ,useState} from "react";
import axios from "axios";

const Ajans = () => {
    useEffect(() => {
        axios.get('http://localhost:8001/api/dataprofile') // Replace '/api/data' with your Express route that returns the JSON data
          .then(response => {
            setJsonData(response.data);
          })
          .catch(error => {
            console.error('Error fetching JSON data:', error);
          });
      }, []);
    
    const [jsonData, setJsonData] = useState(null);

    return (

        <div id="ajans">
            <Profile />
            <div>
      {jsonData ? (
      <pre>{JSON.stringify(jsonData, null, 2)}</pre>
    ) : (
      <p>Loading JSON data...</p>
    )}
         </div>
        </div>
    );
}





export default Ajans;
