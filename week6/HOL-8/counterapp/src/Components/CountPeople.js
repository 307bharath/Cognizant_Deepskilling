// src/components/CountPeople.js
import React from "react";

class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entryCount: 0,
      exitCount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1
    }));
  };

  render() {
    return (
      <div style={{
        margin: "250px",
        textAlign: "center",
        fontFamily: "Arial, sans-serif"
      }}>

        <div style={{ display: "flex", justifyContent: "center", gap: "40px" }}>
          <div>
            <button onClick={this.updateEntry} style={{background:"lime"}}>Login</button>
            <span style={{ marginLeft: "10px",  fontWeight: "bold" }}>
              {this.state.entryCount} People Entered!!!
            </span>
          </div>

          <div>
            <button onClick={this.updateExit} style={{background:"lime"}}>Exit</button>
            <span style={{ marginLeft: "10px",  fontWeight: "bold" }}>
              {this.state.exitCount} People Left!!!
            </span>
          </div>
        </div>
      </div>
    );
  }
}

export default CountPeople;
