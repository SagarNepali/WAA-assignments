import "./comment.css";

const Comment = (props) => {
  console.log("Comment rendering");
  return <div className="comment">{props.comment}</div>;
};

export default Comment;
