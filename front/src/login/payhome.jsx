import * as React from "react";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Button } from "react-bootstrap";
import "react-datepicker/dist/react-datepicker.css";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownButton from "react-bootstrap/DropdownButton";
import { useState } from "react";
import DatePicker from "react-datepicker";
import "../css/test.css";

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  "&:nth-of-type(odd)": {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  "&:last-child td, &:last-child th": {
    border: 0,
  },
}));

function createData(name, calories, fat, carbs, protein, pay, State) {
  return { name, calories, fat, carbs, protein, pay, State };
}

const rows = [
  createData("2022-12-31", 159, 6.0, 24, 4.0),
  createData("2022-09-21", 237, 9.0, 37, 4.3),
  createData("2022-06-30", 262, 16.0, 24, 6.0),
  createData("2022-03-28", 305, 3.7, 67, 4.3),
  createData("2022-02-17", 356, 16.0, 49, 3.9, 11, "완료"),
  createData("2022-01-22", 356, 16.0, 49, 2, 22, ""),
  createData("2022-01-11", 356, 16.0, 49, 99, 33, "완료"),
];

export default function CustomizedTables() {
  // function App() {
  //   const selectList = ["apple", "banana", "grape", "orange"];
  //   const [Selected, setSelected] = useState("");

  //   const handleSelect = (e) => {
  //     setSelected(e.target.value);
  //   };

  //   <div className='App'>
  //     <h1>Select in React</h1>
  //     <div>
  //       <select onChange={handleSelect} value={Selected}>
  //         {selectList.map((item) => (
  //           <option value={item} key={item}>
  //             {item}
  //           </option>
  //         ))}
  //       </select>
  //       <hr />
  //       <p>
  //         Selected: <b>{Selected}</b>
  //       </p>
  //     </div>
  //   </div>;
  // }
  const [startDate, setStartDate] = useState(new Date("2022/10/08"));
  const [endDate, setEndDate] = useState(new Date("2022/10/10"));
  //1 달력
  //2와 3 버튼과 드롭 셀렉트
  //4 드롭다운 버튼액션
  return (
    <TableContainer component={Paper}>
      <>
        <DatePicker selected={startDate} onChange={(date) => setStartDate(date)} selectsStart startDate={startDate} endDate={endDate} />
        <DatePicker selected={endDate} onChange={(date) => setEndDate(date)} selectsEnd startDate={startDate} endDate={endDate} minDate={startDate} />
      </>

      <select name='결제수단' id='결제수단'>
        <option value=''>결제수단</option>
        <option value=''>토스</option>
        <option value=''>카카오</option>
      </select>

      <DropdownButton id='dropdown-item-button' title='결제수단'>
        <Dropdown.ItemText>토스</Dropdown.ItemText>
        <Dropdown.Item as='button'>카카오뱅크</Dropdown.Item>
        <Dropdown.Item as='button'>Another action</Dropdown.Item>
        <Dropdown.Item as='button'>Something else</Dropdown.Item>
      </DropdownButton>
      <Button href='#'>조회</Button>
      <Table sx={{ minWidth: 700 }} aria-label='customized table'>
        <TableHead>
          <TableRow>
            <StyledTableCell>일자</StyledTableCell>
            <StyledTableCell align='right'>처리구분</StyledTableCell>
            <StyledTableCell align='right'>결제수단</StyledTableCell>
            <StyledTableCell align='right'>상품명</StyledTableCell>
            <StyledTableCell align='right'>가맹점명</StyledTableCell>
            <StyledTableCell align='right'>처리금액</StyledTableCell>
            <StyledTableCell align='right'>처리상태</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <StyledTableRow key={row.name}>
              <StyledTableCell component='th' scope='row'>
                {row.name}
              </StyledTableCell>
              <StyledTableCell align='right'>{row.calories}</StyledTableCell>
              <StyledTableCell align='right'>{row.fat}</StyledTableCell>
              <StyledTableCell align='right'>{row.carbs}</StyledTableCell>
              <StyledTableCell align='right'>{row.protein}</StyledTableCell>
              <StyledTableCell align='right'>{row.pay}</StyledTableCell>
              <StyledTableCell align='right'>{row.State}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

// const StyledTableCell = styled(TableCell)(({ theme }) => ({
//   [`&.${tableCellClasses.head}`]: {
//     backgroundColor: theme.palette.common.black,
//     color: theme.palette.common.white,
//   },
//   [`&.${tableCellClasses.body}`]: {
//     fontSize: 14,
//   },
// }));

// const StyledTableRow = styled(TableRow)(({ theme }) => ({
//   "&:nth-of-type(odd)": {
//     backgroundColor: theme.palette.action.hover,
//   },
//   // hide last border
//   "&:last-child td, &:last-child th": {
//     border: 0,
//   },
// }));

// export default function CustomizedTables() {
//   return (
//     const Example = () => {
//       const [startDate, setStartDate] = useState(new Date());
//       return <DatePicker selected={startDate} onChange={(date) => setStartDate(date)} />;
//     };
//     <TableContainer component={Paper}>

//
//       <br />
//       &n
//       <Table sx={{ minWidth: 700 }} aria-label='customized table'>

//           ))}
//         </TableBody>
//       </Table>
//     </TableContainer>
//   );
// }
