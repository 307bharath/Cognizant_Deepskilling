// src/Getuser.js
import React, { Component } from 'react';

class GetUser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      person: null,
      loading: true,
    };
  }

  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }

  render() {
    const { person, loading } = this.state;

    if (loading) {
      return <div>Loading user data...</div>;
    }

    if (!person) {
      return <div>Error fetching data.</div>;
    }

    const { title, first } = person.name;
    const imageUrl = person.picture.large;

    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2>{title} {first}</h2>
        <img src={imageUrl} alt="User" style={{ borderRadius: '50%', width: '150px' }} />
      </div>
    );
  }
}

export default GetUser;
