import logo from "./logo.svg";
import "./App.css";
import Dashboard from "./pages/dashboard/Dashboard";
import { BrowserRouter } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <div>
          <Dashboard className="container" />
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
