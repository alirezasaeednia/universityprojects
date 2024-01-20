import React from "react";
import NavigationBar from '../Components/NavigationBar';
import Back from "../Components/goback";

const Profile = () => {
    
    return (

        <div>
            <NavigationBar />
            <Back/>

            <div className="toppicture">
                <div className="background3"></div>
                <img src="https://cdn-cashy-static-assets.lucidchart.com/marketing/blog/2019Q2/classroom-seating-chart/classroom-seating-header.png"></img>
            </div>
            
            <div className="profilegrid">

                <div></div>

                <div></div>


            </div>
        </div>
    );
}





export default Profile;
