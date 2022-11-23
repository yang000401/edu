import ButtonGroup from "react-bootstrap/ButtonGroup";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownButton from "react-bootstrap/DropdownButton";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import client from "../axiosUtil/axiosUtil";
// import React, { useState } from "react";
// import * as S from "../ProdBasicInfo/ProdBasicInfo.Style";

// const PRODUCT_DATA = [
//   { id: null, value: "상품을 선택하세요." },
//   { id: "0001", value: "딸기 100g" },
//   { id: "0002", value: "포도 100g" },
//   { id: "0003", value: "방울토마토 100g" },
//   { id: "0004", value: "블루베리 100g" },
//   { id: "0005", value: "홍시 100g" },
//   { id: "0006", value: "귤 100g" },
//   { id: "0007", value: "금귤 100g" },
//   { id: "0008", value: "라즈베리 100g" },
// ];

// function ProdBasicInfo() {
//   // 상품코드를 출력할 useState
//   const [selectedDropValue, setSelectedDropValue] = useState("상품을 선택하세요.");
//   // onChange 이벤트가 발생한 target을 받아와 value값이 할당해준다.
//   const handleDropProduct = (e) => {
//     const { value } = e.target;
//     // 상품코드에 넣을 데이터
//     setSelectedDropValue(PRODUCT_DATA.filter((el) => el.value === value)[0].id);
//   };

//   return (
//     <S.ProductNameContainer>
//       <S.Product>상품명 *</S.Product>
//       <S.ProductBar>
//         <S.ProductSearch onChange={handleDropProduct}>
//           {PRODUCT_DATA.map((el) => {
//             return <option key={el.id}>{el.value}</option>;
//           })}
//         </S.ProductSearch>
//       </S.ProductBar>
//       <S.ProductCode>
//         <S.Code>상품 코드</S.Code>
//         <S.ShowingCode>{selectedDropValue}</S.ShowingCode>
//       </S.ProductCode>
//     </S.ProductNameContainer>
//   );
// }

// window.onload = () => {
//     document.querySelector(".dropbtn_click").onclick = () => {
//       dropdown();
//     };
//     document.getElementsByClassName("fastfood").onclick = () => {
//       showMenu(value);
//     };
//     dropdown = () => {
//       var v = document.querySelector(".dropdown-content");
//       var dropbtn = document.querySelector(".dropbtn");
//       v.classList.toggle("show");
//       dropbtn.style.borderColor = "rgb(94, 94, 94)";
//     };

//     showMenu = (value) => {
//       var dropbtn_icon = document.querySelector(".dropbtn_icon");
//       var dropbtn_content = document.querySelector(".dropbtn_content");
//       var dropbtn_click = document.querySelector(".dropbtn_click");
//       var dropbtn = document.querySelector(".dropbtn");

//       dropbtn_icon.innerText = "";
//       dropbtn_content.innerText = value;
//       dropbtn_content.style.color = "#252525";
//       dropbtn.style.borderColor = "#3992a8";
//     };
//   };
//   window.onclick = (e) => {
//     if (!e.target.matches(".dropbtn_click")) {
//       var dropdowns = document.getElementsByClassName("dropdown-content");

//       var dropbtn_icon = document.querySelector(".dropbtn_icon");
//       var dropbtn_content = document.querySelector(".dropbtn_content");
//       var dropbtn_click = document.querySelector(".dropbtn_click");
//       var dropbtn = document.querySelector(".dropbtn");

//       var i;
//       for (i = 0; i < dropdowns.length; i++) {
//         var openDropdown = dropdowns[i];
//         if (openDropdown.classList.contains("show")) {
//           openDropdown.classList.remove("show");
//         }
//       }
//     return (
//       <div>
//         <div className='dropdown-label'>
//           Lunch Menus
//           <span style={{ fontFamily: "Material Icons" }}>restaurant</span>
//         </div>
//         <div className='dropdown'>
//           <button className='dropbtn'>
//             <span className='dropbtn_icon'>more_horiz</span>
//             <span className='dropbtn_content'>Select a menu...</span>
//             <span className='dropbtn_click' style={{ fontFamily: "Material Icons", fontSize: "16px", color: "#3b3b3b", float: "right" }} onclick='dropdown()'>
//               arrow_drop_down
//             </span>
//           </button>
//           <div className='dropdown-content'>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               Burgerking
//             </div>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               Mcdonals
//             </div>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               Lotteria
//             </div>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               Mom's touch
//             </div>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               In n out
//             </div>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               Subway
//             </div>
//             <div className='fastfood' onclick='showMenu(this.innerText)'>
//               Shake shack
//             </div>
//           </div>
//         </div>
//       </div>
//     );
//   };,
// };

// import React from "react";
// import { useCombobox } from "downshift";

// function Combobox({ label, placeholder, items }) {
//   const { isOpen, highlightedIndex, getLabelProps, getComboboxProps, getInputProps, getToggleButtonProps, getMenuProps, getItemProps } = useCombobox({
//     items,
//   });

//   return (
//     <>
//       <label>{label}</label>
//       <div>
//         <input readOnly placeholder={placeholder} />
//         <select>
//           <option>12</option>
//         </select>
//         <button>&gt;</button>
//       </div>

{
  /* <ul >
        {isOpen &&
          items.map((item, index) => (
            <li {...getItemProps({ item, index })} key={item} style={{ background: index === highlightedIndex && "lightgray" }}>
              {item}
            </li>
          ))}
      </ul> */
}
//     </>
//   );
// }

function Combobox() {
  var test = "aaa";
  client.get("/denied", test).then((res) => {
    console.log(res);
  });
  return (
    <>
      <Dropdown className='d-inline mx-2'>
        <Dropdown.Toggle id='dropdown-autoclose-true'>가맹점</Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item2</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item3</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      <Dropdown className='d-inline mx-2' autoClose='inside'>
        <Dropdown.Toggle id='dropdown-autoclose-inside'>구매물품</Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item2</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item3</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      {/* <Dropdown className='d-inline mx-2' autoClose='outside'>
        <Dropdown.Toggle id='dropdown-autoclose-outside'>결제금액</Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown> */}
      <Dropdown className='d-inline mx-2' autoClose={false}>
        <Dropdown.Toggle id='dropdown-autoclose-false'>결제수단</Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
          <Dropdown.Item href='#'>Menu Item</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      <Form>
        <Form.Group className='mb-3' controlId='formGroupEmail'>
          <Form.Label>결제금액</Form.Label>
          <Form.Control type='email' placeholder='결제금액' />
        </Form.Group>
      </Form>
      <Button href='#'>결제하기</Button>
      <Button href='payhome'>payhome</Button>
    </>
  );
}

export default Combobox;
// function Combobox() {
//   return (
//     <>
//       {["가맹점", "구매물품", "결제금액", "결제수단", "결제하기"].map((variant) => (
//         <DropdownButton as={ButtonGroup} key={variant} id={`dropdown-variants-${variant}`} variant={variant.toLowerCase()} title={variant}>
//           <Dropdown.Item eventKey='1'>Action</Dropdown.Item>
//           <Dropdown.Item eventKey='2'>Another action</Dropdown.Item>
//           <Dropdown.Item eventKey='3' active>
//             Active Item
//           </Dropdown.Item>
//           <Dropdown.Divider />
//           <Dropdown.Item eventKey='4'>Separated link</Dropdown.Item>
//         </DropdownButton>
//       ))}
//     </>
//   );
// }

// export default Combobox;
