import React from "react";
import officeimage from './officeimage.png'
const App = () => {
  // 1. Heading element using JSX
  const element = "Office Space";

  // 2. Image element with JSX attributes
  const sr = officeimage;
  const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;

  // 3. Single office item
  const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };

  // 4. Color condition using hint
  let colors = [];
  if (ItemName.Rent <= 60000) {
    colors.push("textRed");
  } else {
    colors.push("textGreen");
  }

  // 5. Office list
  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "Tidel Park", Rent: 75000, Address: "Chennai" },
    { Name: "Mindspace", Rent: 60000, Address: "Hyderabad" },
    { Name: "WeWork", Rent: 45000, Address: "Bangalore" }
  ];

  return (
    <div style={{ padding: "20px", fontFamily: "Arial", marginLeft:"200px" }}>
      <h1>{element}, at Affordable Range</h1>

      {jsxatt}

      <h2>Featured Office</h2>
      <h3>Name: {ItemName.Name}</h3>
      <h3 className={colors.join(" ")}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>

      <h2>All Available Office Spaces</h2>
      <ul>
        {officeList.map((item, index) => {
          let dynamicColor = [];
          if (item.Rent <= 60000) {
            dynamicColor.push("textRed");
          } else {
            dynamicColor.push("textGreen");
          }

          return (
            <li key={index} style={{ marginBottom: "10px" }}>
              <strong>{item.Name}</strong> –{" "}
              <span className={dynamicColor.join(" ")}>Rs. {item.Rent}</span>
              <br />
              <em>{item.Address}</em>
            </li>
          );
        })}
      </ul>
    </div>
  );
};

export default App;
