import { useEffect, useState, useRef } from "react";
import index from "../index.css";
const NavigationBar = () => {
    const [signUp, setSignUp] = useState(false);
    const refone = useRef(null);
  
    useEffect(() => {
      document.addEventListener("click", handleClickOutside, true);
    });
  
    const handleClickOutside = (e) => {
      if (!refone.current.contains(e.target)) {
        hideSignUp();
      }
    };
    const toggleSignUp = () => {
      setSignUp(!signUp);
    };
  
    const hideSignUp = () => {
      setSignUp(false);
    };
  
    return (
      <div className="navigationbar">
        <div className="stuff">
          <a onClick={toggleSignUp} ref={refone}>
            {" "}
            ورود | ثبت نام
          </a>
          {signUp && (
            <div id="options">
                        <div id="option1">
                            <a href="sign">ورود| ثبت نام</a>
                        </div>
                        <div id="option2">ملک های من</div>
                        
            </div>
                )}
                <a  href="agahi" id="agahi" >ثبت آگهی مشاورین</a>
        </div>
      </div>
    );
  };
  
export default NavigationBar;