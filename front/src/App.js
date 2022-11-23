import "./App.css";
import { BrowserRouter } from "react-router-dom";
import RoutesApp from "./RoutesApp";
import { Router } from "react-router-dom";
import { ProSidebarProvider } from "react-pro-sidebar";
import sidebar from "./login/Sidebar";
import { Switch } from "react-router-dom";
import Sidebar from "./login/Sidebar";
function App() {
  return (
    // <div className='App'>
    <BrowserRouter>
      <Sidebar></Sidebar>
      <RoutesApp></RoutesApp>
    </BrowserRouter>
    /* </div> // 중앙 정렬 */
  );
}

export default App;
