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
import Form from "react-bootstrap/Form";

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

const rows = [createData("가계좌", 159, "", 24), createData("나계좌", 237, "", 37), createData("다계좌", 262, ""), createData("라계좌", 305, "", 3)];

export default function CustomizedTables() {
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 700 }} aria-label='customized table'>
        <TableHead>
          <TableRow>
            <StyledTableCell>머니충전</StyledTableCell>
            <StyledTableCell align='right'>잔액</StyledTableCell>
            <StyledTableCell align='right'>충전액</StyledTableCell>

            <StyledTableCell align='right'>충전결과예정액 →</StyledTableCell>
            <StyledTableCell align='right'>총액</StyledTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <StyledTableRow key={row.name}>
              <StyledTableCell component='th' scope='row'>
                {row.name}
              </StyledTableCell>
              <StyledTableCell align='right'>{row.calories}</StyledTableCell>

              <StyledTableCell align='right' style={{ textAlign: "center", width: "500px" }}>
                <Form.Label htmlFor='inputPassword5'>충전금액</Form.Label>
                <Form.Control type='password' id='inputPassword5' aria-describedby='passwordHelpBlock' />
              </StyledTableCell>
              <StyledTableCell align='right'>{row.carbs}</StyledTableCell>
              <StyledTableCell align='right'>{row.protein}</StyledTableCell>
            </StyledTableRow>
          ))}
        </TableBody>
      </Table>
      <Button href='#'>충전하기</Button>
    </TableContainer>
  );
}
