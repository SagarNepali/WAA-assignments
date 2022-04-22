import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Post from "../../components/post/Post";
import PostDetails from "../../components/postDetails/postDetails";

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

  return (
    <React.Fragment>
      <div className="post">
        {postListState.map((post) => {
          return (
            <Link to={`${post.id}`} key={post.id}>
              <Post
                key={post.id}
                author={post.author}
                title={post.title}
                id={post.id}
              />
            </Link>
          );
        })}
      </div>
      <PostDetails />
    </React.Fragment>
  );
};

export default PostList;
