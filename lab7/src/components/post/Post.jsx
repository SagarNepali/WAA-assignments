import React from "react";
import "./post.css";

const Post = (props) => {
  return (
    <div className="content" onClick={props.setSelectedId}>
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
