import React, { useContext } from 'react';
import Styles from './EmployeeCard.module.css';
import ThemeContext from './ThemeContext';

function EmployeeCard(props) {
  const theme = useContext(ThemeContext); // Retrieve theme from context

  return (
    <div className={Styles.Card}>
      <h3>{props.employee.name}</h3>
      <p>{props.employee.email}</p>
      <p>{props.employee.phone}</p>
      <p>
        <button className={theme === 'light' ? Styles.lightBtn : Styles.darkBtn}>
          Edit
        </button>
        <button className={theme === 'light' ? Styles.lightBtn : Styles.darkBtn}>
          Delete
        </button>
      </p>
    </div>
  );
}

export default EmployeeCard;
