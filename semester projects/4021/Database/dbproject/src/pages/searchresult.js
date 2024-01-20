import React, { useEffect } from "react";
import NavigationBar from "../Components/NavigationBar";
import Back from "../Components/goback";
import { useState } from "react";
import { MultiSelect } from "react-multi-select-component";
import axios from "axios";

const options = [
  { label: "مسکونی", value: "maskooni" },
  { label: "اداری تجاری", value: "edari" },
];

const options3 = [
  { label: "پارکینگ", value: "پارکینگ " },
  { label: "انباری", value: "انباری " },
  { label: "لابی", value: "لابی " },
  { label: "سالن ورزش", value: "سالن ورزش " },
  { label: "نگهبان", value: "نگهبان " },
  { label: "آسانسور", value: "آسانسور " },
  { label: "بالکن", value: "بالکن " },
  { label: "استخر", value: "استخر " },
  { label: "سونا", value: "سونا " },
  { label: "تهویه مطبوع", value: "تهویه مطبوع " },
  { label: "سالن اجتماعات", value: "سالن اجتماعات " },
  { label: "روف گاردن", value: "روف گاردن " },
  { label: "درب ریموت", value: "درب ریموت " },
  { label: "جکوزی", value: "جکوزی " },
  { label: "آنتن مرکزی", value: "آنتن مرکزی " },
];
const options4 = [
  { label: "مشارکتی", value: "مشارکتی " },
  { label: "معاوضه", value: "معاوضه " },
  { label: "قابل تبدیل", value: "قابل تبدیل " },
  { label: "رهن کامل", value: "رهن کامل " },
  { label: "پیش فروش", value: "پیش فروش " },
  { label: "موقعیت اداری", value: "موقعیت اداری " },
  { label: "وام دار", value: "وام دار " },
  { label: "قیمت توافقی", value: "قیمت توافقی " },
  { label: "نوساز", value: "نوساز " },
  { label: "پنت هاوس", value: "پنت هاوس " },
  { label: "مستغلات", value: "مستغلات " },
  { label: "قدرالسهم", value: "قدرالسهم " },
  { label: "پاساژ", value: "پاساژ " },
  { label: "مال", value: "مال " },
];



const customValueRenderer = (selected, _options) => {
  return selected.length
    ? selected.map(({ label }) => "✔️ " + label)
    : " تیتری انتخاب نشده است  ";
};

const options2 = [
  { label: " آپارتمان/برج", value: " آپارتمان/برج" },
  { label: "ویلایی/باغ و باغچه  ", value: "ویلایی/باغ و باغچه  " },
  { label: " دفتر کار, اتاق اداری و مطب", value: " دفتر کار, اتاق اداری و مطب  " },
  { label: "مغازه", value: " مغازه" }, { label: "انبار, سوله, کارگاه و کارخانه  ", value: " انبار, سوله, کارگاه و کارخانه  " },
  { label: " زمین/کلنگی  ", value: " زمین/کلنگی  " }, { label: " مستغلات ", value: " مستغلات  " },
  { label: " پنت هاوس  ", value: " پنت هاوس  " }, { label: " کشاورزی   ", value: " کشاورزی   " }, { label: " سایر   ", value: " سایر   " },


];
const Result = () => {
  const [ price, setPrice ] = useState(40);
  const [jsonData, setJsonData] = useState(null);
  const [sliderValue2, setSliderValue2] = useState(50); // Initial value of the slider
  const [sliderValue3, setSliderValue3] = useState(50); // Initial value of the slider

  const [selected, setSelected] = useState([]);
  const [selected2, setSelected2] = useState([]);
  const [selected3, setSelected3] = useState([]);
  const [selected4, setSelected4] = useState([]);
  const [nokarbari, setnokarbari] = useState('');
  const [sliderValue, setSliderValue] = useState(50); // Initial value of the slider

  const handleSliderChange = (event) => {
    setSliderValue(event.target.value);
    handleSearch(sliderValue);
  };

  /*useEffect(() => {
    console.log('hello');
    console.log(selected);
    if (selected.length > 0) {
      const hi = selected[0].value;
       if (hi =='maskooni') {
      console.log('salam');
         setnokarbari('maskooni');
    }
    else {
            setnokarbari('');
    }
    if (selected.includes('edari')) {
      setnokarbari('edari');
    }
    else {
      setnokarbari('');
}
    }
   
  }, []);*/

  useEffect(() => {
    axios.get('http://localhost:8001/api/data') // Replace '/api/data' with your Express route that returns the JSON data
      .then(response => {
        setJsonData(response.data);
      })
      .catch(error => {
        console.error('Error fetching JSON data:', error);
      });
  }, [selected,selected2,selected3,sliderValue,sliderValue2,sliderValue3,selected4]);

  
  const handleSearch = (ww) => {
    axios.post("http://localhost:8001/api/results", { })
    .then(response => {
      console.log(response.data.message); // Handle successful insertion
      console.log('hi')
    })
    .catch(error => {
      console.error(error); // Handle error
      console.log('hi')
    });

  };



  const handleSliderChange2 = (event) => {
    setSliderValue2(event.target.value);
    handleSearch(sliderValue2);
  };


  const handleSliderChange3 = (event) => {
    setSliderValue3(event.target.value);
    handleSearch(sliderValue3);

  };
  return (
    <div>
      <NavigationBar />
      <Back />

      <div className="whole">
        <div className="filter">
          <div id="خرید">
            <a>خرید</a>
            <div id="mypoll">
            <select id="mypol">
              <option>رهن</option>
              <option>اجاره</option>

           </select>
            </div>
       
          </div>
          <div id="انتخاب همه+2">
            <a>انتخاب همه +2</a>
      <MultiSelect
        options={options}
        value={selected}
        onChange={setSelected}
        labelledBy="Select" valueRenderer={customValueRenderer} ClearSelectedIcon={null}
      />
          </div>
          <div id="انتخاب همه +10">
          <a>انتخاب همه +10</a>

          <MultiSelect
        options={options2}
        value={selected2}
        onChange={setSelected2}
        labelledBy="Select" valueRenderer={customValueRenderer} ClearSelectedIcon={null}
      />
          </div>
          <div id="قیمت">
            <a>قیمت</a>
            <div>
              <input type="range"   value={sliderValue}
        onChange={handleSliderChange} min={0} max={300}/>
            </div>
            <p>قیمت بزرگتر از: {sliderValue} تومان </p>

          
            </div>
          <div id="متراژ">
            <a>متراژ</a>
            <div>
              <input type="range"   value={sliderValue2}
        onChange={handleSliderChange2} min={0} max={300}/>
            </div>
            <p>متراژ بزرگتر از: {sliderValue2} متر </p>          </div>
          <div id="تعداد خواب">
            <a>تعداد خواب</a>
            <div>
            <select>
              <option>+1</option>
              <option>+2</option>
              <option>+3</option>

              <option>+4</option>

              <option>+5</option>

            </select>
            </div>
        
                 </div>
          <div id="سن">
          <a>سن</a>

            <div>
              <input type="range"   value={sliderValue3}
        onChange={handleSliderChange3} min={0} max={300}/>
            </div>
            <div>
          <p>سن بزرگتر از: {sliderValue3} سال </p>     
          </div>

          </div>
          <div id="امکانات">
            <a>امکانات</a>
            <div>
            <MultiSelect
        options={options3}
        value={selected3}
        onChange={setSelected3}
        labelledBy="Select" valueRenderer={customValueRenderer} ClearSelectedIcon={null}
      />
            </div>
        
          </div>
          <div id="شرایط">
            <a>شرایط</a>

            <div><MultiSelect
        options={options4}
        value={selected4}
        onChange={setSelected4}
        labelledBy="Select" valueRenderer={customValueRenderer} ClearSelectedIcon={null}
      /></div>
          </div>
        </div>
      </div>
      <div>
      {jsonData ? (
      <pre>{JSON.stringify(jsonData, null, 2)}</pre>
    ) : (
      <p>Loading JSON data...</p>
    )}
         </div>
    </div>
  );
};

export default Result;
