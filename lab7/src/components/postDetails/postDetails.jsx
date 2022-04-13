import axios from "axios";
import { useEffect, useState } from "react";
import Comment from "../comment/Comment";
import "./postDetails.css";

const PostDetails = (props) => {
  const [postDetail, setPostDetail] = useState({});

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/posts/" + props.id)
      .then((response) => {
        setPostDetail(response.data);
      })
      .catch((err) => console.log(err));
  }, [props.id]);

  let postDetailsDisplay = null;

  if (props.id != 0) {
    postDetailsDisplay = (
      <div className="PostDetail">
        <h1>Post Details</h1>
        <h2>{postDetail.title}</h2>
        <h3>{postDetail.author}</h3>
        <h3>{postDetail.content}</h3>
        <div style={{ textAlign: "left" }}>
          <h2 style={{ textAlign: "left" }}>&nbsp;Comments</h2>
          {postDetail.comments != null
            ? postDetail.comments.map((comment) => {
                return <Comment comment={comment.name} key={comment.id} />;
              })
            : null}
        </div>

        <button>Edit</button>
        <button onClick={() => deleteClickHandler(postDetail.id)}>
          Delete
        </button>
      </div>
    );
  }

  const deleteClickHandler = (id) => {
    axios
      .delete("http://localhost:8080/api/v1/posts/" + id)
      .then((response) => {
        postDetailsDisplay = null;
        alert("Deleted successfully");
        props.setReloadFlag();
      })
      .catch((err) => console.log(err));
  };

  return postDetailsDisplay;
};

export default PostDetails;
