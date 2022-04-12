import React from "react";
import "./post.css";

const Post = (props) => {
  const { post } = props;

  return (
    <div className="post">
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
