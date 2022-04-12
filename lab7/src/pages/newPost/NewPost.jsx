const NewPost = (props) => {
  return (
    <div className="form">
      <label>Title: </label>
      <input
        type="text"
        name={"title"}
        onChange={props.onPostChange}
        value={props.title}
      />

      <br />
      <label>Author: </label>
      <input
        type="text"
        name={"author"}
        onChange={props.onPostChange}
        value={props.author}
      />
      <br />
      <button onClick={props.addPost}>Add Post</button>
    </div>
  );
};

export default NewPost;
