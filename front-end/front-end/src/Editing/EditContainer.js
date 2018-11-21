import React from 'react';


const EditUser = (props) => {

  return (
    <div>
      <h4>Edit User</h4>
      <form onSubmit={props.closeAndEdit}>
        <label>
          Edit Username:
          <br/>
          <input type='text' name='username' value={props.userToEdit.username} onChange={props.handleEditChange}/>
        </label>
        <label>
          Edit Location:
          <br/>
          <input type='text' name='location' value={props.userToEdit.location} onChange={props.handleEditChange}/>
        </label>
        <button type='submit'>Edit User</button>
      </form>
    </div>
    )
}

export default EditUser;
