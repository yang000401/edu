import React from "react";
import { Route, Router, Routes } from "react-router-dom";
import Login from "./login/Logintest";
import Signup from "./login/Signup";
import AcccessibleTable from "./login/payhome";
import Combobox from "./login/Payment";
import CustomizedTables from "./login/Charging";
import { ProSidebarProvider } from "react-pro-sidebar";
import { Link } from "react-router-dom";
import { BrowserRouter, Switch } from "react-router-dom";
import Sidebar from "./login/Sidebar";

function RoutesApp() {
  return (
    <Routes>
      <Route path='/test' element={<Login />}></Route>
      <Route path='/Signup' element={<Signup />}></Route>

      <Route path='/payment' element={<Combobox />}></Route>
      <Route path='/payhome' element={<AcccessibleTable />}></Route>
      <Route path='/charging' element={<CustomizedTables />}></Route>
      {/* <Sidebar> </Sidebar> */}
    </Routes>
  );
}

export default RoutesApp;
