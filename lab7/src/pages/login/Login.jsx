import axios from "axios";
import { useRef } from "react";
import { Link } from "react-router-dom";
import "./Login.css";
const Login = () => {
  const login = useRef(null);

  const signIn = (e) => {
    e.preventDefault();
    let obj = {
      userName: login.current["username"].value,
      password: login.current["ssoId"].value,
    };

    axios
      .post("http://localhost:8080/api/v1/authenticate/login", obj)
      .then((response) => console.log(response))
      .catch((err) => console.log(err));
  };

  return (
    <div className="login">
      <form ref={login}>
        <label>Username</label>
        <input type="text" name={"username"} required />
        <label>Password</label>
        <input type="password" name={"ssoId"} required />
        <button onClick={signIn}>Sign In</button>
      </form>
    </div>
  );
};
export default Login;
