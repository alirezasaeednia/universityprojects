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
  const [city, setcity] = useState('');
  const [mahale, setmahale] = useState('');
  const [gheymatrahn, setgheymatrahn] = useState('');
  const [norahn, setnorahn] = useState(1);
  const [gheymatejare, setgheymatejare] = useState('0');
  const [metraj, setmetraj] = useState('0');
  const [nokarbari, setnokarbari] = useState('0');
  const [bedno, setbedno] = useState('0');
  const [descp, setdescp] = useState('');
  const [title, settitle] = useState('');
  const code = Math.floor(1000000 + Math.random() * 9000000); 
  const [parking, setParking] = useState('0');
  const [lobby, setLobby] = useState('0');
  const [anbari, setAnbari] = useState('0');
  const [asansor, setAsansor] = useState('0');
  const [estakhr, setEstakhr] = useState('0');
  const [sona, setSona] = useState('0');
  const [varzesh, setVarzesh] = useState('0');
  const [negahban, setNegahban] = useState('0');
  const [balcony, setBalcony] = useState('0');
  const [tahviye, setTahviye] = useState('0');
  const [salon, setSalon] = useState('0');
  const [jakuzi, setJakuzi] = useState('0');
  const [anten, setAnten] = useState('0');
  const [darb, setDarb] = useState('0');
  const [roof, setRoof] = useState('0');
  const [id, setId] = useState(0);

  const [mall, setMall] = useState('0');
  const [mosharekati, setMosharekati] = useState('0');
  const [moavez, setMoavez] = useState('0');
  const [ghabeltabdil, setGhabeltabdil] = useState('0');
  const [pishfurush, setPishfurush] = useState('0');
  const [edari, setEdari] = useState('0');
  const [vam, setVam] = useState('0');
  const [nosaz, setNosaz] = useState('0');
  const [ghadr, setGhadr] = useState('0');;
  const [pasaj, setPasaj] = useState('0');
  const [id2, setid2] = useState(0);



  const [search, setSearch] = useState(false);
  const toggleSearch = () => {
    setSearch(!search);
  };
 
  const getPhoneValue = () => {
    handleInsert();
    handleInsert2();
    handleAgahi();
    axios.post("http://localhost:8001/api/moshavertel", { yourajans })
    .then(response => {
      console.log(response.data.message); // Handle successful insertion
      console.log('hi')
    })
    .catch(error => {
      console.error(error); // Handle error
      console.log('hi')
    });
  

  };
 
  const handleInsert = () => {
  
    console.log(selectedButtons)
 
    const random = Math.floor(Math.random() * 100) + 1
    setId(random);
    
    axios.post("http://localhost:8001/api/emkanat", {parking, lobby, anbari, asansor, estakhr, sona, varzesh, negahban, balcony, tahviye, salon, jakuzi, anten, darb, roof,id })
      .then(response => {
        console.log(response.data.message); // Handle successful insertion
        console.log (sona);
        console.log('shod')
      })
      .catch(error => {
        console.error(error); // Handle error
        console.log('nashod')
      });
    
 
  };

  const handleInsert2 = () => {
    const gg = new Array(selectedButtons.length+1);
  
    const random = Math.floor(Math.random() * 100) + 1
    setid2(random);
    
    axios.post("http://localhost:8001/api/sharayet", {id2, mosharekati, moavez, ghabeltabdil, pishfurush, edari, vam, nosaz, ghadr, pasaj, mall })
      .then(response => {
        console.log(response.data.message); // Handle successful insertion
        console.log('hi')
      })
      .catch(error => {
        console.error(error); // Handle error
        console.log('hi')
      });
    
    
  };

  const handleAgahi = () => {
    
    axios.post("http://localhost:8001/api/agahi", { code, descp, title, bedno, nokarbari, metraj, gheymatejare, gheymatrahn, norahn, mahale, city })
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
  useEffect(() => {
    console.log(selectedButtons.length, "mow",selectedButtons);
    for (let i = 0; i < selectedButtons.length; i++) {
      let button = selectedButtons[i];
      console.log('umadi');
      switch (button) {
        case 'parking':
          setParking('1');
          break;
        case 'lobby':
          setLobby('1');

          break;
        case 'anbari':
          setAnbari('1');
          break;
        case 'asansor':
          setAsansor('1');
          break;
        case 'estakhr':
          setEstakhr('1');
          break;
        case 'sona':
          setSona('1')
          break;
        case 'varzesh':
          setVarzesh('1');
          break;
        case 'negahban':
          setNegahban('1');
          break;
        case 'balcony':
          setBalcony('1');
          break;
        case 'tahviye':
          setTahviye('1');
          break;
        case 'salon':
          setSalon('1');
          break;
        case 'jakuzi':
          setJakuzi('1');
          break;
        case 'anten':
          setAnten('1');
          break;
        case 'darb':
          setDarb('1');
          break;
        case 'roof':
          setRoof('1');
          break;
        default:
          break;
      }
    } for (let i = 0; i < selectedButtons.length; i++) {
      let button = selectedButtons[i];
      switch (button) {
        case 'mosharekati':
          setMosharekati('1');
          break;
        case 'moavez':
          setMoavez('1');
          break;
        case 'ghabeltabdil':
          setGhabeltabdil('1');
          break;
        case 'pishfurush':
          setPishfurush('1');
          break;
        case 'edari':
          setEdari('1');
          break;
        case 'vam':
          setVam('1');
          break;
        case 'nosaz':
          setNosaz('1');
          break;
        case 'ghadr':
          setGhadr('1');
          break;
        case 'pasaj':
          setPasaj('1');
          break;
        case 'mall':
          setMall('1');
          break;
        
        default:
          break;
      }
    };
  }, [selectedButtons]);
  
  useEffect(() => {
    console.log( [parking, lobby, anbari, asansor, estakhr, sona, varzesh, negahban, balcony, tahviye, salon, jakuzi, anten, darb, roof,id]);
    console.log([id2, mosharekati, moavez, ghabeltabdil, pishfurush, edari, vam, nosaz, ghadr, pasaj, mall ])
 
  }, [parking, lobby, anbari, asansor, estakhr, sona, varzesh, negahban, balcony, tahviye, salon, jakuzi, anten, darb, roof,id],[id2, mosharekati, moavez, ghabeltabdil, pishfurush, edari, vam, nosaz, ghadr, pasaj, mall ]);



    
  const handleButtonClick = (button) => {
    if (selectedButtons.includes(button)) {
      setSelectedButtons(
        
        selectedButtons.filter((selectedButton) => selectedButton !== button)
      );        switch (button) {
        case 'parking':
          setParking('0');
          break;
        case 'lobby':
          setLobby('0');

          break;
        case 'anbari':
          setAnbari('0');
          break;
        case 'asansor':
          setAsansor('0');
          break;
        case 'estakhr':
          setEstakhr('0');
          break;
        case 'sona':
          setSona('0')
          break;
        case 'varzesh':
          setVarzesh('0');
          break;
        case 'negahban':
          setNegahban('0');
          break;
        case 'balcony':
          setBalcony('0');
          break;
        case 'tahviye':
          setTahviye('0');
          break;
        case 'salon':
          setSalon('0');
          break;
        case 'jakuzi':
          setJakuzi('0');
          break;
        case 'anten':
          setAnten('0');
          break;
        case 'darb':
          setDarb('0');
          break;
        case 'roof':
          setRoof('0');
          break;
        default:
          break;
      }  
        switch (button) {
          case 'mosharekati':
            setMosharekati('0');
            break;
          case 'moavez':
            setMoavez('0');
            break;
          case 'ghabeltabdil':
            setGhabeltabdil('0');
            break;
          case 'pishfurush':
            setPishfurush('0');
            break;
          case 'edari':
            setEdari('0');
            break;
          case 'vam':
            setVam('0');
            break;
          case 'nosaz':
            setNosaz('0');
            break;
          case 'ghadr':
            setGhadr('0');
            break;
          case 'pasaj':
            setPasaj('0');
            break;
          case 'mall':
            setMall('0');
            break;
          
          default:
            break;
        
      };  
    } else {
  setSelectedButtons([...selectedButtons, button]);
    }
    console.log('injai');
    console.log(selectedButtons.length ,"length");
    

   

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
            onClick={() => handleButtonClick("parking")}
            className={selectedButtons.includes("parking") ? "selected" : ""}
          >
            پارکینگ
          </button>
          <button
            onClick={() => handleButtonClick("lobby")}
            className={selectedButtons.includes("lobby") ? "selected" : ""}
          >
            لابی
          </button>
          <button
            onClick={() => handleButtonClick("anbari")}
            className={selectedButtons.includes("anbari") ? "selected" : ""}
          >
            انباری
          </button>
          <button
            onClick={() => handleButtonClick("asansor")}
            className={selectedButtons.includes("asansor") ? "selected" : ""}
          >
            آسانسور
          </button>
          <button
            onClick={() => handleButtonClick("estakhr")}
            className={selectedButtons.includes("estakhr") ? "selected" : ""}
          >
            استخر
          </button>
          <button
            onClick={() => handleButtonClick("sona")}
            className={selectedButtons.includes("sona") ? "selected" : ""}
          >
            سونا
          </button>
          <button
            onClick={() => handleButtonClick("varzesh")}
            className={selectedButtons.includes("varzesh") ? "selected" : ""}
          >
            سالن ورزش
          </button>
          <button
            onClick={() => handleButtonClick("negahban")}
            className={selectedButtons.includes("negahban") ? "selected" : ""}
          >
            نگهبان
          </button>
          <button
            onClick={() => handleButtonClick("balcony")}
            className={selectedButtons.includes("balcony") ? "selected" : ""}
          >
            بالکن
          </button>
          <button
            onClick={() => handleButtonClick("tahviye")}
            className={selectedButtons.includes("tahviye") ? "selected" : ""}
          >
            تهویه مطبوع
          </button>
          <button
            onClick={() => handleButtonClick("salon")}
            className={selectedButtons.includes("salon") ? "selected" : ""}
          >
            سالن اجتماعات
          </button>
          <button
            onClick={() => handleButtonClick("jakuzi")}
            className={selectedButtons.includes("jakuzi") ? "selected" : ""}
          >
            جکوزی
          </button>
          <button
            onClick={() => handleButtonClick("anten")}
            className={selectedButtons.includes("anten") ? "selected" : ""}
          >
            آنتن مرکزی
          </button>
          <button
            onClick={() => handleButtonClick("darb")}
            className={selectedButtons.includes("darb") ? "selected" : ""}
          >
            درب ریموت
          </button>
          <button
            onClick={() => handleButtonClick("roof")}
            className={selectedButtons.includes("roof") ? "selected" : ""}
          >
            روف گاردن
          </button>
        </div>
        <div id="mahali7">
          <a>شرایط</a>
          <button
            onClick={() => handleButtonClick("mosharekati")}
            className={selectedButtons.includes("mosharekati") ? "selected2" : ""}
          >
            مشارکتی
          </button>
          <button
            onClick={() => handleButtonClick("moavez")}
            className={selectedButtons.includes("moavez") ? "selected2" : ""}
          >
            معاوضه
          </button>
          <button
            onClick={() => handleButtonClick("ghabeltabdil")}
            className={selectedButtons.includes("ghabeltabdil") ? "selected2" : ""}
          >
            قابل تبدیل
          </button>
          <button
            onClick={() => handleButtonClick("pishfurush")}
            className={selectedButtons.includes("pishfurush") ? "selected2" : ""}
          >
            پیش فروش
          </button>
          <button
            onClick={() => handleButtonClick("edari")}
            className={selectedButtons.includes("edari") ? "selected2" : ""}
          >
            موقعیت اداری
          </button>
          <button
            onClick={() => handleButtonClick("vam")}
            className={selectedButtons.includes("vam") ? "selected2" : ""}
          >
            وام دار
          </button>
          <button
            onClick={() => handleButtonClick("nosaz")}
            className={selectedButtons.includes("nosaz") ? "selected2" : ""}
          >
            نوساز
          </button>
          <button
            onClick={() => handleButtonClick("ghadr")}
            className={selectedButtons.includes("ghadr") ? "selected2" : ""}
          >
            قدر السهم
          </button>
          <button
            onClick={() => handleButtonClick("pasaj")}
            className={selectedButtons.includes("pasaj") ? "selected2" : ""}
          >
            پاساژ
          </button>
          <button
            onClick={() => handleButtonClick("mall")}
            className={selectedButtons.includes("mall") ? "selected2" : ""}
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
          <input placeholder="اطلاعات بیشتر را وارد کنید" value={descp} onChange={e=>{setdescp(e.target.value)}}></input>
        </div>

        <button onClick={getPhoneValue} >تایید</button>
      </div>
      </div>
      </div>

  );
};



export default Agahi;
