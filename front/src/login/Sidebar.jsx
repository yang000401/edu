import React from "react";
import { Link } from "react-router-dom";

import SidebarItem from "./SidebarItem";

function Sidebar() {
  const menus = [
    { name: "대시보드", path: "/payhome" },
    { name: "충전", path: "/Charging" },
    { name: "캐시 관리", path: "/payment" },
  ];

  return (
    <div className='Sidebar'>
      {menus.map((menu, index) => {
        return (
          <Link to={menu.path} key={index}>
            <SidebarItem menu={menu} />
          </Link>
        );
      })}
    </div>
  );
}

export default Sidebar;
