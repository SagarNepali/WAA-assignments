import React, { useState } from "react";
import PostList from "../../containers/PostList/PostList";
import NewPost from "../../components/newPost/NewPost";
import PostDetails from "../../components/postDetails/postDetails";
import { PostContext } from "../../contexts/PostContext";

const Dashboard = () => {
  const [selectedIdState, setSelectedIdState] = useState(0);

  const [reloadFlagState, setReloadFlagState] = useState(false);

  const setSelectedId = (id) => {
    setSelectedIdState(id);
  };

  const setReloadFlag = () => {
    setReloadFlagState(!reloadFlagState);
  };

  return (
    <div>
      <PostContext.Provider value={setSelectedId}>
        <div className="post">
          <PostList reloadFlagState={reloadFlagState} />
        </div>
        <div>
          <PostDetails id={selectedIdState} setReloadFlag={setReloadFlag} />
        </div>
        <div>
          <NewPost setReloadFlag={setReloadFlag} />
        </div>
      </PostContext.Provider>
    </div>
  );
};

export default Dashboard;
