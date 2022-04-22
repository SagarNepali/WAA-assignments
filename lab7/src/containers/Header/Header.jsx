import "../Header/Header.css";
import { Link } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../../contexts/AuthContext";

const Header = () => {
  const { authUser, setAuthUser } = useContext(AuthContext);

  return (
    <header>
      <nav>
        <ul>
          {!authUser ? (
            <li>
              <Link to="/login">Login</Link>
            </li>
          ) : (
            <>
              <li>
                <Link to="/posts">Posts</Link>
              </li>
              <li>
                <Link to="/create-post">New Post</Link>
              </li>
              <li>
                <Link
                  to="/logout"
                  onClick={() => {
                    setAuthUser(null);
                    localStorage.removeItem("accessToken");
                  }}
                >
                  Logout
                </Link>
              </li>
            </>
          )}
        </ul>
      </nav>
    </header>
  );
};

export default Header;
