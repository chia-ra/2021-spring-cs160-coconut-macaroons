import React, { Component } from 'react';
import { Link } from 'react-router-dom';

export default class Navbar extends Component {

  render() {
    return (
      <nav className="navbar navbar-dark bg-dark navbar-expand-lg">
        <Link to="/" className="navbar-brand">HoneyComb</Link>
        <div className="collpase navbar-collapse">
        <ul className="navbar-nav mr-auto">
          <li className="navbar-item">
          <Link to="/" className="nav-link">Posts</Link>
          </li>
          <li className="navbar-item">
          <Link to="/create" className="nav-link">Create New Listing</Link>
          </li>
          <li className="navbar-item">
          <Link to="/user" className="nav-link">Add Category</Link>
          </li>
        </ul>
        </div>
      </nav>
    );
  }
}
