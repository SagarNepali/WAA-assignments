import axios from "axios";
import React, { useEffect, useState } from "react";
import Post from "../../components/post/Post";

const PostList = (props) => {
  const [postListState, setPostListState] = useState([]);

  const fetchPosts = () => {
    axios
      .get("http://localhost:8080/api/v1/posts")
      .then((response) => {
        setPostListState(response.data);
      })
      .catch((err) => console.log(err));
  };

  useEffect(() => {
    fetchPosts();
  }, [props.reloadFlagState]);

  return postListState.map((post) => {
    return (
      <Post
        key={post.id}
        author={post.author}
        title={post.title}
        setSelectedId={() => {
          props.setSelectedId(post.id);
        }}
      />
    );
  });
};

export default PostList;
