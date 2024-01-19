import React from "react";
import NavigationBar from "../Components/NavigationBar";
import Back from "../Components/goback";
import { useState, useEffect } from "react";
import axios from "axios";

const Agahi = () => {

  
  const [photos, setPhotos] = useState([]);
  const [mainPhoto, setMainPhoto] = useState(null);
  const [selectedButton1, setSelectedButton1] = useState(null);
  const [selectedButton2, setSelectedButton2] = useState(null);
  const [selectedButton3, setSelectedButton3] = useState(null);
  const [yourajans, setyourajans] = useState('');
  const [city, setcity] = useState("");
  const [mahale, setmahale] = useState("");
  const [gheymatrahn, setgheymatrahn] = useState("");
  const [norahn, setnorahn] = useState(1);
  const [gheymatejare, setgheymatejare] = useState("");
  const [metraj, setmetraj] = useState("");
  const [nokarbari, setnokarbari] = useState("");
  const [bedno, setbedno] = useState("");
  const [desc, setdesc] = useState("");
  const [title, settitle] = useState("");
  const code = '1234567';





  const [search, setSearch] = useState(false);
  const toggleSearch = () => {
    setSearch(!search);
  };

  const getPhoneValue = () => {
    axios.post("http://localhost:8001/api/moshavertel", { yourajans })
    .then(response => {
      console.log(response.data.message); // Handle successful insertion
      console.log('hi')
    })
    .catch(error => {
      console.error(error); // Handle error
      console.log('hi')
    });
    handleInsert();
  };

  const handleInsert = () => {
    axios.post("http://localhost:8001/api/agahi", { code,desc,title,bedno,nokarbari,metraj,gheymatejare,gheymatrahn,norahn,mahale,city,selectedButtons })
      .then(response => {
        console.log(response.data.message); // Handle successful insertion
        console.log('hi')
      })
      .catch(error => {
        console.error(error); // Handle error
        console.log('hi')
      });
  };
  const handlePhotoUpload = (event) => {
    const uploadedPhotos = Array.from(event.target.files);
    setPhotos([...photos, ...uploadedPhotos]);
  };

  const [selectedButtons, setSelectedButtons] = useState([]);

  const handleButtonClick = (button) => {
    if (selectedButtons.includes(button)) {
      setSelectedButtons(
        selectedButtons.filter((selectedButton) => selectedButton !== button)
      );
    } else {
      setSelectedButtons([...selectedButtons, button]);
    }
  };

  const handleButtonClick2 = (buttonId) => {
    if (buttonId >= 1 && buttonId <= 4) {
      setSelectedButton1(buttonId);
      if (buttonId == 1) {
        setnokarbari('maskooni');
      }
      if (buttonId == 2) {
        setnokarbari('tejari');
      }
      if (buttonId == 3) {
        setnokarbari('edari');
      }
      if (buttonId == 4) {
        setnokarbari('sanati');
      }
    }

    if (buttonId >= 5 && buttonId <= 10) {
      setSelectedButton2(buttonId);
      if (buttonId == 5) {
        setbedno('tak khab');
      }
      if (buttonId == 6) {
        setbedno('do khab');
      }
      if (buttonId == 7) {
        setbedno('se khab');
      }
      if (buttonId == 8) {
        setbedno('4 khab');
      }
      if (buttonId == 9) {
        setbedno('5 khab');
      }

      if (buttonId == 10) {
        setbedno('6 khab');
      }
    }
    if (buttonId >= 11 && buttonId <= 12) {
      setSelectedButton3(buttonId);
      if (buttonId == 11) {
        setnorahn('ejare');
      }
      if (buttonId == 12) {
        setnorahn('tavafoghi');
      }
    }
  };

  const handlePhotoClick = (index) => {
    setMainPhoto(photos[index]);
  };

  return (
    <div id="upperdiv">
      <div  class="background-image"></div>

    <div id="whole">
      <NavigationBar />
      <Back />

      <div id="myagahi">
        <div id="mahali0">
          <button onClick={toggleSearch}>تلفن آژانس مورد نظر را انتخاب کنید</button>
     
          <input placeholder="تلفن آژانس مورد نظر شما" value={yourajans} onChange={e=>(setyourajans(e.target.value))}></input>
        </div>
        <div id="mahali">
          <a>محله</a>
          <input placeholder=">شهر مورد نظر خود را وارد کنید" value={city} onChange={e=>{setcity(e.target.value)}}></input>

          <a>شهر</a>
          <input placeholder=">محله مورد نظر خود را وارد کنید" value={mahale} onChange={e=>{setmahale(e.target.value)}}></input>
        </div>
        <div id="mahali2">
          <a>رهن</a>
          <input placeholder="مبلغ رهن را به تومان وارد کنید"  value={gheymatrahn} onChange={e=>{setgheymatrahn(e.target.value)}} />
          <button
            onClick={() => handleButtonClick2(11)}
            className={selectedButton3 === 11 ? "selected4" : "" } value={norahn} onChange={e=>{setnorahn(!norahn)}}
          >
            رهن کامل
          </button>
          <button
            onClick={() => handleButtonClick2(12)}
            className={selectedButton3 === 12 ? "selected4" : ""}
          >
            قیمت توافقی
          </button>
        </div>

        <div id="mahali3">
          <a>اجاره</a>
          <input placeholder="اجاره به تومان را وارد کنید"  value={gheymatejare} onChange={e=>{setgheymatejare(e.target.value)}}/>
        </div>

        <div id="mahali3">
          <a>متراژ</a>
          <input placeholder="متراژ   را وارد کنید" value={metraj} onChange={e=>{setmetraj(e.target.value)}}/>
        </div>

        <div id="mahali4">
          <a>نوع کاربری</a>
          <button
            onClick={() => handleButtonClick2(1)}
            className={selectedButton1 === 1 ? "selected" : ""}
          >
            مسکونی
          </button>
          <button
            onClick={() => handleButtonClick2(2)}
            className={selectedButton1 === 2 ? "selected" : ""}
          >
            تجاری
          </button>
          <button
            onClick={() => handleButtonClick2(3)}
            className={selectedButton1 === 3 ? "selected" : ""}
          >
            اداری
          </button>
          <button
            onClick={() => handleButtonClick2(4)}
            className={selectedButton1 === 4 ? "selected" : ""}
          >
            صنعتی
          </button>
        </div>

        <div id="mahali5">
          <a>تعداد خواب</a>
          <button
            onClick={() => handleButtonClick2(5)}
            className={selectedButton2 === 5 ? "selected4" : ""}
          >
            یک خوابه
          </button>
          <button
            onClick={() => handleButtonClick2(6)}
            className={selectedButton2 === 6 ? "selected4" : ""}
          >
            دو خوابه
          </button>
          <button
            onClick={() => handleButtonClick2(7)}
            className={selectedButton2 === 7 ? "selected4" : ""}
          >
            سه خوابه
          </button>
          <button
            onClick={() => handleButtonClick2(8)}
            className={selectedButton2 === 8 ? "selected4" : ""}
          >
            چهار خوابه
          </button>
          <button
            onClick={() => handleButtonClick2(9)}
            className={selectedButton2 === 9 ? "selected4" : ""}
          >
            پنج خوابه
          </button>
          <button
            onClick={() => handleButtonClick2(10)}
            className={selectedButton2 === 10 ? "selected4" : ""}
          >
            شش خوابه
          </button>
        </div>

        <div id="mahali6">
          <a>امکانات </a>
          <button
            onClick={() => handleButtonClick("Button 1")}
            className={selectedButtons.includes("Button 1") ? "selected" : ""}
          >
            پارکینگ
          </button>
          <button
            onClick={() => handleButtonClick("Button 2")}
            className={selectedButtons.includes("Button 2") ? "selected" : ""}
          >
            لابی
          </button>
          <button
            onClick={() => handleButtonClick("Button 3")}
            className={selectedButtons.includes("Button 3") ? "selected" : ""}
          >
            انباری
          </button>
          <button
            onClick={() => handleButtonClick("Button 4")}
            className={selectedButtons.includes("Button 4") ? "selected" : ""}
          >
            آسانسور
          </button>
          <button
            onClick={() => handleButtonClick("Button 5")}
            className={selectedButtons.includes("Button 5") ? "selected" : ""}
          >
            استخر
          </button>
          <button
            onClick={() => handleButtonClick("Button 6")}
            className={selectedButtons.includes("Button 6") ? "selected" : ""}
          >
            سونا
          </button>
          <button
            onClick={() => handleButtonClick("Button 7")}
            className={selectedButtons.includes("Button 7") ? "selected" : ""}
          >
            سالن ورزش
          </button>
          <button
            onClick={() => handleButtonClick("Button 8")}
            className={selectedButtons.includes("Button 8") ? "selected" : ""}
          >
            نگهبان
          </button>
          <button
            onClick={() => handleButtonClick("Button 9")}
            className={selectedButtons.includes("Button 9") ? "selected" : ""}
          >
            بالکن
          </button>
          <button
            onClick={() => handleButtonClick("Button 10")}
            className={selectedButtons.includes("Button 10") ? "selected" : ""}
          >
            تهویه مطبوع
          </button>
          <button
            onClick={() => handleButtonClick("Button 11")}
            className={selectedButtons.includes("Button 11") ? "selected" : ""}
          >
            سالن اجتماعات
          </button>
          <button
            onClick={() => handleButtonClick("Button 12")}
            className={selectedButtons.includes("Button 12") ? "selected" : ""}
          >
            جکوزی
          </button>
          <button
            onClick={() => handleButtonClick("Button 13")}
            className={selectedButtons.includes("Button 13") ? "selected" : ""}
          >
            آنتن مرکزی
          </button>
          <button
            onClick={() => handleButtonClick("Button 14")}
            className={selectedButtons.includes("Button 14") ? "selected" : ""}
          >
            درب ریموت
          </button>
          <button
            onClick={() => handleButtonClick("Button 15")}
            className={selectedButtons.includes("Button 15") ? "selected" : ""}
          >
            روف گاردن
          </button>
        </div>
        <div id="mahali7">
          <a>شرایط</a>
          <button
            onClick={() => handleButtonClick("Button 16")}
            className={selectedButtons.includes("Button 16") ? "selected2" : ""}
          >
            مشارکتی
          </button>
          <button
            onClick={() => handleButtonClick("Button 17")}
            className={selectedButtons.includes("Button 17") ? "selected2" : ""}
          >
            معاوضه
          </button>
          <button
            onClick={() => handleButtonClick("Button 18")}
            className={selectedButtons.includes("Button 18") ? "selected2" : ""}
          >
            قابل تبدیل
          </button>
          <button
            onClick={() => handleButtonClick("Button 19")}
            className={selectedButtons.includes("Button 19") ? "selected2" : ""}
          >
            پیش فروش
          </button>
          <button
            onClick={() => handleButtonClick("Button 20")}
            className={selectedButtons.includes("Button 20") ? "selected2" : ""}
          >
            موقعیت اداری
          </button>
          <button
            onClick={() => handleButtonClick("Button 21")}
            className={selectedButtons.includes("Button 21") ? "selected2" : ""}
          >
            وام دار
          </button>
          <button
            onClick={() => handleButtonClick("Button 22")}
            className={selectedButtons.includes("Button 22") ? "selected2" : ""}
          >
            نوساز
          </button>
          <button
            onClick={() => handleButtonClick("Button 23")}
            className={selectedButtons.includes("Button 23") ? "selected2" : ""}
          >
            قدر السهم
          </button>
          <button
            onClick={() => handleButtonClick("Button 24")}
            className={selectedButtons.includes("Button 24") ? "selected2" : ""}
          >
            پاساژ
          </button>
          <button
            onClick={() => handleButtonClick("Button 25")}
            className={selectedButtons.includes("Button 25") ? "selected2" : ""}
          >
            مال
          </button>
        </div>

        <div id="mahali8">
          <a>افزودن تصویر</a>
          <div className="tasviriezafekon">
            <input type="file" multiple onChange={handlePhotoUpload} />
            <div className="photo-container">
              {photos.map((photo, index) => (
                <div
                  className={`photo-item ${
                    photo === mainPhoto ? "selected" : ""
                  }`}
                  key={index}
                  onClick={() => handlePhotoClick(index)}
                >
                  <img
                    src={URL.createObjectURL(photo)}
                    width="180"
                    height="200"
                    alt={`User's Photo ${index}`}
                  />
                </div>
              ))}
            </div>
          </div>
        </div>

        <div id="mahali9">
          <a>عنوان</a>
          <input placeholder="عنوان" value={title} onChange={e=>{settitle(e.target.value)}}></input>
        </div>

        <div id="mahali10">
          <a>توضیحات</a>
          <input placeholder="اطلاعات بیشتر را وارد کنید" value={desc} onChange={e=>{setdesc(e.target.value)}}></input>
        </div>

        <button onClick={getPhoneValue} >تایید</button>
      </div>
      </div>
      </div>

  );
};

export default Agahi;
