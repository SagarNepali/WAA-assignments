import React from "react";
import "./post.css";

const Post = (props) => {
  const { post } = props;

  const handleClick = (e, obj) => {
    e.preventDefault();
    console.log("Post details written on console while clicking the post");
    console.log(obj);
  };

  return (
    <div className="post" onClick={(e) => handleClick(e, post)}>
      ID: {post.id}
      <br />
      Title: {post.title}
      <br />
      Author: {post.author}
      <hr />
    </div>
  );
};

export default Post;
