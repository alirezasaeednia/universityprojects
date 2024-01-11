import React from "react";
import NavigationBar from "../Components/NavigationBar";
import Back from "../Components/goback";
const Agahi = () => {
  return (
    <div>
          <NavigationBar />
          <Back/>

      <div id="myagahi">
        <div>
          <a>محله</a>
          <button>شهر مورد نظر خود را وارد کنید</button>
          <a>شهر</a>

          <button>محله مورد نظر خود را وارد کنید</button>
        </div>
        <div>
          <a>رهن</a>
          <input placeholder="مبلغ رهن را به تومان وارد کنید" />
          <button>رهن کامل</button>
          <button>قیمت توافقی</button>
        </div>

        <div>
          <a>اجاره</a>
          <input placeholder="اجاره به تومان را وارد کنید" />
        </div>

        <div>
          <a>متراژ</a>
          <input placeholder="متراژ   را وارد کنید" />
              </div>
              
              <div>
                  <a>نوع کاربری</a>
                  <button>مسکونی</button>
                  <button>تجاری</button>
                  <button>اداری</button>
                  <button>صنعتی</button>

              </div>

              <div>
                  <a>تعداد خواب</a>
                  <button>یک خوابه</button>
                  <button>دو خوابه</button>
                  <button>سه خوابه</button>
                  <button>چهار خوابه</button>
                  <button>پنج خوابه</button>
                  <button>شش خوابه</button>
              </div>

              <div>
                  <a>امکانات </a>
                  <button>پارکینگ</button>
                  <button>لابی</button>
                  <button>انباری</button>
                  <button>آسانسور</button>
                  <button>استخر</button>
                  <button>سونا</button>
                  <button>سالن ورزش</button>
                  <button>نگهبان</button>
                  <button>بالکن</button>
                  <button>تهویه مطبوع</button>
                  <button>سالن اجتماعات</button>
                  <button>جکوزی</button>
                  <button>آنتن مرکزی</button>
                  <button>درب ریموت</button>
                  <button>روف گاردن</button>
              </div>
              <div>
                  <a>شرایط</a>
                  <button>مشارکتی</button>
                  <button>معاوضه</button>
                  <button>قابل تبدیل</button>
                  <button>پیش فروش</button>
                  <button>موقعیت اداری</button>
                  <button>وام دار</button>
                  <button>نوساز</button>
                  <button>قدر السهم</button>
                  <button>پاساژ</button>
                  <button>مال</button>
              </div>

              <div>
                  <a>افزودن تصویر</a>
                  <div className="tasviriezafekon">
                      

                  </div>
              </div>

              <div>
                  <a>عنوان</a>
                  <input placeholder="عنوان"></input>
              </div>

              <div>
                  <a>توضیحات</a>
                  <input placeholder="اطلاعات بیشتر را وارد کنید"></input>
              </div>
      </div>
    </div>
  );
};

export default Agahi;
