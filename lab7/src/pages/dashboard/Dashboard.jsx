import React, { useState } from "react";
import Header from "../../containers/Header/Header";
import { AuthContext } from "../../contexts/AuthContext";
import PageRoutes from "../PageRoutes/PageRoutes";

const Dashboard = () => {
  const [authUser, setAuthUser] = useState(null);

  return (
    <React.Fragment>
      <AuthContext.Provider value={{ authUser, setAuthUser }}>
        <div className="header">
          <Header />
        </div>
        <div className="post">
          <PageRoutes />
        </div>
      </AuthContext.Provider>
    </React.Fragment>
  );
};

export default Dashboard;
