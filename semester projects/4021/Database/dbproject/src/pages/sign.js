import React from "react";
import NavigationBar from '../Components/NavigationBar';

const Sign = () => {
    
    return (

        <div>
            <NavigationBar />
            <div>
                <div className="imageinside"></div>
                <input placeholder="شماره همراه یا ایمیل"></input>
                <button>ورود</button>
                <button>بازگشت</button>
                
            </div>
        </div>
    );
}

export default Sign;
