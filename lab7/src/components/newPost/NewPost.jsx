import axios from "axios";
import { useState } from "react";
import "./newPost.css";

const NewPost = (props) => {
  const initialState = { title: "", author: "", content: "Fixed" };

  const [postState, setPostState] = useState(initialState);

  const onPostChange = (event) => {
    const objCopy = { ...postState };
    objCopy[event.target.name] = event.target.value;
    setPostState(objCopy);
  };

  const addPost = () => {
    axios
      .post("http://localhost:8080/api/v1/posts", postState)
      .then((response) => {
        setPostState(initialState);
        props.setReloadFlag();
      })
      .catch((error) => console.log(error));
  };
  return (
    <div className="newPost">
      <label>Title: </label>
      <input
        type="text"
        name={"title"}
        onChange={onPostChange}
        value={postState.title}
      />

      <br />
      <label>Author: </label>
      <input
        type="text"
        name={"author"}
        onChange={onPostChange}
        value={postState.author}
      />
      <br />
      <button onClick={addPost}>Add Post</button>
    </div>
  );
};

export default NewPost;
