import React from "react";

const IndianPlayers = () => {
  const oddPlayers = ["First : Sachin1", "Third : Virat3", "Fifth : Yuvraj5"];
  const evenPlayers = ["Second : Dhoni2", "Fourth : Rohit4", "Sixth : Raina6"];

  const merged = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player",
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player"
  ];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((p, index) => (
          <li key={index}>{p}</li>
        ))}
      </ul>
<hr></hr>
      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((p, index) => (
          <li key={index}>{p}</li>
        ))}
      </ul>
<hr></hr>
      <h2>List of Indian Players Merged:</h2>
      <ul>
        {merged.map((p, index) => (
          <li key={index}>{p}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
