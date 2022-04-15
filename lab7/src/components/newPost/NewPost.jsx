import axios from "axios";
import { useRef } from "react";
import { useNavigate } from "react-router-dom";
import "./newPost.css";

const NewPost = (props) => {
  const newPostForm = useRef(null);
  const navigate = useNavigate();

  const addPost = () => {
    axios
      .post("http://localhost:8080/api/v1/posts", {
        title: newPostForm.current["title"].value,
        author: newPostForm.current["author"].value,
      })
      .then((response) => {
        navigate("/posts");
      })
      .catch((error) => console.log(error));
  };
  return (
    <div className="newPost">
      <form ref={newPostForm}>
        <label>Title: </label>
        <input type="text" name={"title"} />

        <br />
        <label>Author: </label>
        <input type="text" name={"author"} />
        <br />
        <button onClick={addPost}>Add Post</button>
      </form>
    </div>
  );
};

export default NewPost;
