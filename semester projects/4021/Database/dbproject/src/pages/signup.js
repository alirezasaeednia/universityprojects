import React from "react";
import NavigationBar from "../Components/NavigationBar";
import { useState } from "react";
import Back from "../Components/goback";

const Up = () => {

  const [search, setSearch] = useState(false);
  const toggleSearch = () => {
      setSearch(!search);
  };
  const [selectedButton1, setSelectedButton1] = useState(null);

  const [isDiv1Enabled, setDiv1Enabled] = useState(false);
  const [isDiv2Enabled, setDiv2Enabled] = useState(false);

  const enableDiv1 = () => {
    setDiv1Enabled(true);
    setDiv2Enabled(false);
  };

  
  const handleButtonClick2 = (buttonId) => {
   
        setSelectedButton1(buttonId);
      
  };


  const enableDiv2 = () => {
    setDiv1Enabled(false);
    setDiv2Enabled(true);
  };
  return (
    <div>
      <NavigationBar />
      <div className="myselect">
        <div><button onClick={enableDiv1}>مشاور</button></div>
        <div><button onClick={enableDiv2}>مدیر آژانس</button> </div>
          </div>
          <Back/>

      {isDiv1Enabled && <div className="moshaver">
        <div>
          <a>اطلاعات مشاور</a>
          <div>
            <input placeholder="نام  "></input>
          </div>
          <div>
            <input placeholder="نام خانوادگی  "></input>
          </div>
          <div>
            <input placeholder="شهر حوزه ففعالیت  "></input>
          </div>
          <div>
            <input placeholder="شماره تلفن همراه  "></input>
          </div>
          <div>
            <input placeholder="رمز عبور  "></input>
          </div>
          <div>
            <input placeholder="تکرار رمز عبور  "></input>
          </div>
          <div>
            {" "}
            <button>ثبت نام</button>
          </div>
        </div>
      </div>}
      {isDiv2Enabled && <div className="up">
        <div>
          <a>اطلاعات آژانس</a>
        </div>
        <div>
          <input placeholder="*نام آژانس ( فارسی)"></input>
        </div>
        <div>
          <input placeholder="تلفن آژانس "></input>
        </div>

        <div>
          <button onClick={toggleSearch}>تعداد کارمندان</button>

          { search&&(<div className="tedad"> 

            <div><button onClick={() => handleButtonClick2(40)}
        className={selectedButton1 === 40 ? 'selected4' : ''}>کمتر از 3</button></div>
            <div><button onClick={() => handleButtonClick2(41)}
        className={selectedButton1 === 41 ? 'selected4' : ''}> سه تا 5 نفر</button></div>
            <div><button onClick={() => handleButtonClick2(42)}
        className={selectedButton1 === 42 ? 'selected4' : ''}>پنج تا 10 نفر  </button></div>
            <div><button onClick={() => handleButtonClick2(43)}
        className={selectedButton1 === 43 ? 'selected4' : ''}>  بیشتر از 10 نفر</button></div>

          </div>)}
         
          <input placeholder="*شهر حوزه فعالیت   "></input>
        </div>
        <div>
          <a>اطلاعات مدیر</a>
        </div>
        <div>
          <input placeholder="*نام"></input>
        </div>
        <div>
          <input placeholder="نام خانوادگی"></input>
        </div>

        <div>
          <input placeholder="*شماره تلفن همراه "></input>
        </div>

        <div>
          <a>تعیین رمز عبور </a>
        </div>
        <div>
          <input placeholder="*نام"></input>
        </div>
        <div>
          <input placeholder="*رمز عبور "></input>
        </div>

        <div>
          <input placeholder="* تکرار رمز عبور  "></input>
        </div>
        <div>
          {" "}
          <button>ثبت نام</button>
        </div>
      </div>}
    </div>
  );
};

export default Up;
