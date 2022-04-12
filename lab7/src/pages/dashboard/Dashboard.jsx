import React, { useState } from "react";
import PostList from "../../containers/PostList/PostList";
import NewPost from "../newPost/NewPost";

const Dashboard = () => {
  let idCounter = 4;

  const [postState, setPostState] = useState({
    title: "",
    author: "",
  });

  const [postListState, setPostListState] = useState([
    {
      id: 1,
      title: "Spring",
      author: "Master Saap",
    },
    {
      id: 2,
      title: "Hibernate",
      author: "Toritilla",
    },
    {
      id: 3,
      title: "React",
      author: "Bynens",
    },
  ]);

  const onPostChange = (event) => {
    const objCopy = { ...postState };
    objCopy[event.target.name] = event.target.value;
    setPostState(objCopy);
  };

  const addPost = () => {
    const postStateCopy = { ...postState };
    postStateCopy.id = idCounter;
    console.log(idCounter);
    idCounter++;
    console.log(idCounter);
    const copyPostListState = [...postListState];
    copyPostListState.push(postStateCopy);
    setPostListState(copyPostListState);
  };

  return (
    <div>
      <PostList className="posts" posts={postListState} />
      <NewPost
        title={postState.title}
        author={postState.author}
        onPostChange={(event) => {
          onPostChange(event);
        }}
        addPost={addPost}
      />
    </div>
  );
};

export default Dashboard;
