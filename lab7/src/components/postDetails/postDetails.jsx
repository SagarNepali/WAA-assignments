import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Comment from "../comment/Comment";
import "./postDetails.css";

const PostDetails = (props) => {
  const params = useParams();
  const navigate = useNavigate();

  const [postDetail, setPostDetail] = useState({});

  useEffect(() => {
    if (params.id) {
      axios
        .get("http://localhost:8080/api/v1/posts/" + params.id)
        .then((response) => {
          setPostDetail(response.data);
        })
        .catch((err) => console.log(err));
    }
  }, [params.id]);

  let postDetailsDisplay = null;

  if (params.id) {
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
        <button onClick={() => deleteClickHandler(params.id)}>Delete</button>
      </div>
    );
  }

  const deleteClickHandler = (id) => {
    axios
      .delete("http://localhost:8080/api/v1/posts/" + id)
      .then((response) => {
        postDetailsDisplay = null;
        alert("Deleted successfully");
        navigate("/");
      })
      .catch((err) => console.log(err));
  };

  return postDetailsDisplay;
};

export default PostDetails;
