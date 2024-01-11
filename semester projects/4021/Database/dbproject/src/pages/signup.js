import React from "react";
import NavigationBar from "../Components/NavigationBar";
import { useState } from "react";

const Up = () => {
  const [isDiv1Enabled, setDiv1Enabled] = useState(false);
  const [isDiv2Enabled, setDiv2Enabled] = useState(false);

  const enableDiv1 = () => {
    setDiv1Enabled(true);
    setDiv2Enabled(false);
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
          <button>تعداد کارمندان</button>
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
