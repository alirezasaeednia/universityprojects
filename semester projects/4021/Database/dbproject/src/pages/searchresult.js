import React from "react";
import NavigationBar from '../Components/NavigationBar';

const Result = () => {
    
    return (

        <div>
            <NavigationBar />
            <div className="whole">
                <div className="filter">
                    <div id="خرید"><button>خرید</button></div>
                    <div id="انتخاب همه+2"><button>انتخاب همه +2</button></div>
                    <div id="انتخاب همه +10"><button>انتخاب همه +10</button></div>
                    <div id="قیمت"><button>قیمت</button></div>
                    <div id="متراژ"><button>متراژ</button></div>
                    <div id="تعداد خواب"><button>تعداد خواب</button></div>
                    <div id="سن"><button>سن</button></div>
                    <div id="امکانات"><button >امکانات</button></div>
                </div>



            </div>
         
        </div>
    );
}

export default Result;
