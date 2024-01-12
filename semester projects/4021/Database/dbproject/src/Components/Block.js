import { useEffect, useState, useRef } from "react";
import index from "../index.css";
const Blockk = () => {
  const [inputValue, setInputValue] = useState('');

  const handleLinkClick = (event) => {
    const clickedContent = event.target.textContent;
    setInputValue(clickedContent);
  };
    const [search, setSearch] = useState(false);
    const toggleSearch = () => {
        setSearch(!search);
      };
    
  return (
    <div className="container">
      <img src="https://wallpapercave.com/wp/wp2464201.jpg" />
      <div className="searchbar">
        <div className="absolute">
          <div>
            <h1 className="first">مسکن، یک تصمیم کیلیدی</h1>
            <h2 className="me">
              .خانه دلخواهتان را به کمک مشاورین متخصص کیلید پیدا کنید
            </h2>
          </div>
          <div className="ww">
            <input type="text" placeholder="مثال: نیاوران،تهران" onClick={toggleSearch} value={inputValue}
              onChange={(e) => setInputValue(e.target.value)}></input>
            <button
              class="items-center justify-center w-full flex btn btn-lg btn-primary lg:w-auto"
              id="headlessui-combobox-button-:rb:"
              type="button"
              tabindex="-1"
              aria-haspopup="listbox"
              aria-expanded="false"
              data-headlessui-state=""
            >
                         
                          {search && (
         <div className="mysearch">
                                  <div id="lastsearch">
                                      <a>آخرین جستجوها</a>
                                      <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" class="w-5 h-5" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12H4C4 16.4183 7.58172 20 12 20C16.4183 20 20 16.4183 20 12C20 7.58172 16.4183 4 12 4C9.53614 4 7.33243 5.11383 5.86492 6.86543L8 9H2V3L4.44656 5.44648C6.28002 3.33509 8.9841 2 12 2ZM13 7L12.9998 11.585L16.2426 14.8284L14.8284 16.2426L10.9998 12.413L11 7H13Z"></path></svg>
                                      <div id="results">
                                          <div className="box">
                                              <div id="elements"><a onClick={handleLinkClick}>سلام</a></div>
                                          </div>
                                      </div>
                                  </div>
                                  <div id="popular"> <a>جستجوی پرطرفدار</a>
                                      <svg stroke="currentColor" fill="none" stroke-width="2" viewBox="0 0 24 24" aria-hidden="true" class="w-5 h-5" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" d="M13 7h8m0 0v8m0-8l-8 8-4-4-6 6"></path></svg>
                                      <div id="results">
                                          <div className="box">
                                              <div id="elements"><a onClick={handleLinkClick}>سلام</a></div>
                                          </div>
                                      </div>
                                  </div>
                          </div>
                          
        )}
              <a class="w-[50px]"  href="searchresult">جستجو</a>
              <svg
                stroke="currentColor"
                fill="none"
                stroke-width="2"
                viewBox="0 0 24 24"
                stroke-linecap="round"
                stroke-linejoin="round"
                height="20"
                width="20"
                xmlns="http://www.w3.org/2000/svg"
              >
                <circle cx="11" cy="11" r="8"></circle>
                <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
              </svg>
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Blockk;