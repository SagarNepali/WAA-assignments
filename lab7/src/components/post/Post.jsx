import React, { useContext } from "react";
import { PostContext } from "../../contexts/PostContext";
import "./post.css";

const Post = (props) => {
  return (
    <div className="content">
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
