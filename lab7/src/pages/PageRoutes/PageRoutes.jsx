import { Navigate, Route, Routes } from "react-router-dom";
import NewPost from "../../components/newPost/NewPost";
import PostDetails from "../../components/postDetails/postDetails";
import PostList from "../../containers/PostList/PostList";
import Login from "../login/Login";

const PageRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/posts" />} />
      <Route path="posts" element={<PostList />}>
        <Route path=":id" element={<PostDetails />} />
      </Route>
      <Route path="create-post" element={<NewPost />} />
      <Route path="login" element={<Login />} />
    </Routes>
  );
};

export default PageRoutes;
