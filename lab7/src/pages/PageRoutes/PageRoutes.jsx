import { useContext, useState } from "react";
import { Navigate, Route, Routes } from "react-router-dom";
import NewPost from "../../components/newPost/NewPost";
import PostDetails from "../../components/postDetails/postDetails";
import PostList from "../../containers/PostList/PostList";
import { AuthContext } from "../../contexts/AuthContext";
import Login from "../login/Login";

const PageRoutes = () => {
  const { authUser } = useContext(AuthContext);

  return (
    <Routes>
      {authUser && (
        <>
          <Route path="posts" element={<PostList />}>
            <Route path=":id" element={<PostDetails />} />
          </Route>
          <Route path="create-post" element={<NewPost />} />
        </>
      )}
      {!authUser && <Route path="login" element={<Login />} />}

      <Route
        path="*"
        element={<Navigate to={authUser ? "/posts" : "/login"} />}
      />
    </Routes>
  );
};

export default PageRoutes;
