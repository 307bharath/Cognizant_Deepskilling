
import React, { useEffect, useState } from 'react';
import './App.css';
import GitClient from './GitClient';

function App() {
  const [repos, setRepos] = useState([]);

  useEffect(() => {
    async function fetchRepos() {
      const data = await GitClient.getRepositories('techiesyed');
      setRepos(data);
    }
    fetchRepos();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h2>Git Repositories of user - Techiesyed</h2>
        <ul>
          {repos.map(name => (
            <p key={name}>{name}</p>
          ))}
        </ul>
       
      </header>
    </div>
  );
}

export default App;
