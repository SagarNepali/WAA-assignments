import React from "react";
import Post from "../../components/post/Post";

const PostList = (props) => {
  return props.posts.map((post) => {
    return <Post key={post.id} post={post} />;
  });
  // return posts;
};

export default PostList;
