import React, { useState } from "react";
import Header from "../../containers/Header/Header";
import PageRoutes from "../PageRoutes/PageRoutes";

const Dashboard = () => {
  return (
    <React.Fragment>
      <div className="header">
        <Header />
      </div>
      <div className="post">
        <PageRoutes />
      </div>
    </React.Fragment>
  );
};

export default Dashboard;
