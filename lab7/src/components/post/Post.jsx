import React, { useContext } from "react";
import { PostContext } from "../../contexts/PostContext";
import "./post.css";

const Post = (props) => {
  const setSelectedId = useContext(PostContext);
  return (
    <div
      className="content"
      onClick={() => {
        setSelectedId(props.id);
      }}
    >
      <h2>{props.title}</h2>
      <em>
        <br />
        By: <b>{props.author}</b>
      </em>
      <hr />
    </div>
  );
};

export default Post;
