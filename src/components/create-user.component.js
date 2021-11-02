import React, { Component } from 'react';
import axios from 'axios';
export default class CreateUsers extends Component {
  constructor(props) {
    super(props);

    this.onChangeCategory = this.onChangeCategory.bind(this);
    this.onSubmit = this.onSubmit.bind(this);

    this.state = {
      category: ''
    }
  }

  onChangeCategory(e) {
    this.setState({
      category: e.target.value
    })
  }

  onSubmit(e) {
    e.preventDefault();

    const user = {
      category: this.state.category
    }

    console.log(user);
    axios.post('http://localhost:5000/users/add', user)
      .then(res => console.log(res.data));
    this.setState({
      category: ''
    })
  }

  render() {
   return (
     <div>
       <h3>Add a New Category!</h3>
       <form onSubmit={this.onSubmit}>
         <div className="form-group">
           <label>Category: </label>
           <input  type="text"
               required
               className="form-control"
               value={this.state.category}
               onChange={this.onChangeCategory}
               />
         </div>
         <div className="form-group">
           <input type="submit" value="Create Category" className="btn btn-primary" />
         </div>
       </form>
     </div>
   )
 }
}
