import React from "react";
import NavigationBar from '../Components/NavigationBar';
import Back from "../Components/goback";
const Sign = () => {
    
    return (

        <div>
            <NavigationBar />
            <div className="main_sign_in">
                <div className="imageinside">
                    <img src="https://cdn.kilid.com/favicons/new/kilid-sign.png" id="hi" ></img>
                    <nav>به سایت کلید خوش آمدید</nav>
                </div>
                
                <input placeholder="شماره همراه یا ایمیل"></input>
                <button>ورود</button>
                <a href="signup" >ثبت نام در کلید</a>
                <Back/>
            </div>
        </div>
    );
}

export default Sign;
